package com.ait.calc.Controller;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.ait.calc.Model.Complex;
import com.ait.calc.Model.FFT;

public class Audio_IO implements Runnable {
	private GUIController guiController;
	private int sample_rate = 44100;
	private int sample_size = 4096;
	private int bandwidth = 5000;
	private int multiplier = 12;
	
	private File audioFile;
	private AudioFileFormat audioFileFormat;
	private AudioFormat audioFormat;
	private AudioInputStream audioInputStream;

	private SourceDataLine speakerLine;
	
	private byte[] buffer;
	private double[] wave;
	private Complex[] c;
	private double[] freq;
	
	public Audio_IO(GUIController guiController) {
		this.guiController = guiController;

		try {
			String dir = System.getProperty("user.dir");
			audioFile = new File(dir + "\\Resources\\zephyr.wav"); //Added Resources folder to store external resources
			audioFileFormat = AudioSystem.getAudioFileFormat(audioFile);
			audioFormat = audioFileFormat.getFormat();
			
			audioInputStream = AudioSystem.getAudioInputStream(audioFile);
			
			speakerLine = AudioSystem.getSourceDataLine(audioFormat);
			speakerLine.open(audioFormat, sample_size);
			speakerLine.start();
			
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}

		buffer = new byte[sample_size * audioFormat.getFrameSize()];
		wave = new double[buffer.length / 2];
		c = new Complex[buffer.length / 2];
		freq = new double[c.length * bandwidth / sample_rate];
	}
	
	@Override
	public void run() {
		while(true) {

			int readBytes;
			
			try {
				readBytes = audioInputStream.read(buffer);
				wave = convertToDoubles(wave, buffer, readBytes);
				
				for (int i = 0; i < wave.length; i++) {
					c[i] = new Complex(wave[i], 0.0);
				}
				
				c = FFT.fft(c);
				
				for (int i = 1; i < freq.length; i++) {
					freq[i] = (c[i].abs() / 65536.0 * 2.0 / sample_size * multiplier);
				}

				guiController.plot(wave, 65536.0, 1000 * sample_size / sample_rate, "ms", 0.0F, guiController.gui.dy / 4.0F);
				guiController.plot2(freq, 1.0, bandwidth, "Hz", -guiController.gui.dy / 4.0F + 11.0F + 1.0F, -guiController.gui.dy / 4.0F);

				speakerLine.write(buffer, 0, buffer.length);
			} catch (IOException e) {
				
			}
		}		
	}

	private double[] convertToDoubles(double[] wave, byte[] buffer, int readBytes) {
		double[] byteDoubles = new double[wave.length];
		
		for (int i = wave.length - 1; i >= readBytes / 2; i--) {
			byteDoubles[i] = wave[(i - readBytes / 2)];
		}
		
		for (int i = 0; i < readBytes / 2; i++) {
			byteDoubles[i] = (buffer[(readBytes - 1 - 2 * i)] << 8 | buffer[(readBytes - 2 - 2 * i)] & 0xFF);
		}
		
		return byteDoubles;
	}
}
