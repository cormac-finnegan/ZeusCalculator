package com.ait.calc.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.ait.calc.model.DctAndIdct;

public class AudioDCT implements Runnable {
	private File audioFile;
	private File resultAudioFile;
	private AudioFileFormat audioFileFormat;
	private AudioFileFormat.Type resultFileType;
	private AudioFormat audioFormat;
	private AudioInputStream audioInputStream;
	private AudioInputStream audioOutputStream;
	
	private ByteArrayOutputStream baos;
	private ByteArrayOutputStream baos2;
	private ByteArrayInputStream bais;
	
	private int qLevel;
	
	public AudioDCT(String fileName, int qLevel) {
		this.qLevel = qLevel;
		
		try {
			String dir = System.getProperty("user.dir");
			audioFile = new File(dir + "\\Resources\\" + fileName);
			audioFileFormat = AudioSystem.getAudioFileFormat(audioFile);
			audioFormat = audioFileFormat.getFormat();
			audioInputStream = AudioSystem.getAudioInputStream(audioFile);
			audioFileFormat = AudioSystem.getAudioFileFormat(audioFile);
			
			resultFileType = audioFileFormat.getType();
			
			resultAudioFile = new File(dir + "\\Resources\\DCT.wav");
			
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		}
		
		baos = new ByteArrayOutputStream();
		baos2 = new ByteArrayOutputStream();
	}
	
	@Override
	public void run() {
		System.out.println("Reading file...");
		
		try {
			/** Read a file into bytes	**/
			int read;
			byte[] buff = new byte[1024];
			while((read = audioInputStream.read(buff)) > 0) {
				baos.write(buff, 0, read);
			}
			
			baos.flush();
			byte[] audioBytes = baos.toByteArray();
			
			System.out.println("File read! Bytes: " + audioBytes.length);
			
			/** Convert the bytes to ints	**/
			System.out.println("\nConverting bytes to ints...");
			int[] audio = convertBytesToInts(audioBytes);
			System.out.println("Converted to ints! Ints: " + audio.length);
			
			/**	Convert the audio signal into a 2D signal	**/
			System.out.println("\nConverting to 2D...");
			int[][] twoDaudio = convert1DsignalTo2Dsignal(audio);
			System.out.println("Converted to 2D!");
			
			/** Compress the signal		**/
			System.out.println("\nCompressing the signal...");
			
			int[][] compressedSignal = new int[twoDaudio.length][8];
			int[][] signalToBeCompressed = new int[8][8];

			for(int i = 0; i < twoDaudio.length; i++) {
				for(int j = 0; j < twoDaudio[i].length; j++) {
					signalToBeCompressed[i % 8][j] = twoDaudio[i][j];
				}
				
				if(i % 8 == 0) {
					compressedSignal = DctAndIdct.dct(signalToBeCompressed, qLevel);
					compressedSignal = DctAndIdct.Idct();
					int[] oneDaudio = convert2DsignalTo1Dsignal(compressedSignal, 8*8);
					byte[] compressedBuffer = convertIntsToBytes(oneDaudio, oneDaudio.length*2);
					baos2.write(compressedBuffer);
				}
			}
			System.out.println("Compressed!");

			/**	Save received bytes to a .wav file	**/
			byte[] outputBuffer = baos2.toByteArray();
			System.out.println("\nWriting to a .wav file...");
			bais = new ByteArrayInputStream(outputBuffer);
			audioOutputStream = new AudioInputStream(bais, audioFormat, outputBuffer.length / audioFormat.getFrameSize());
			AudioSystem.write(audioOutputStream, resultFileType, resultAudioFile);
			System.out.println("File created!");
			
			// Show difference in values.
//			for(int i = 0; i < outputBuffer.length; i++) {
//				if(outputBuffer[i] != 0)
//					System.out.println(outputBuffer[i] + " (" + audioBytes[i] + ")");
//			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private int[] convertBytesToInts(byte[] data) {
		int[] audio = new int[data.length/2];
		int i = 0;
		while(i < data.length-2) {
			ByteBuffer bb = ByteBuffer.allocate(2);
	 		bb.order(ByteOrder.LITTLE_ENDIAN);
	 		bb.put(data[i]);
	 		bb.put(data[i+1]);
	 		audio[(i/2)] = bb.getShort(0);
	 		i += 2;
		}
		
		return audio;
	}
	
	private byte[] convertIntsToBytes(int[] audio, int size) {
		byte[] audioBytes = new byte[size];
		int i = 0;
		while(i <= size-1) {
			ByteBuffer bb = ByteBuffer.allocate(2);
			bb.order(ByteOrder.LITTLE_ENDIAN);
			bb.putShort((short) audio[i/2]);
			audioBytes[i] = bb.get(0);
			audioBytes[i+1] = bb.get(1);
			i += 2;
		}
		
		return audioBytes;
	}
	
	private int[][] convert1DsignalTo2Dsignal(int[] audio) {
		int[][] twoDaudio = new int[(audio.length/8)][8];
		int k = 0;
		
		for(int i = 0; i < twoDaudio.length; i++) {
			for(int j = 0; j < twoDaudio[i].length; j++) {
				twoDaudio[i][j] = audio[k];
				k++;
			}
		}
		
		return twoDaudio;
	}
	
	private int[] convert2DsignalTo1Dsignal(int[][] twoDaudio, int size) {
		int[] audio = new int[size];
		int k = 0;
		
		for(int i = 0; i < twoDaudio.length; i++) {
			for(int j = 0; j < twoDaudio[i].length; j++) {
				audio[k] = twoDaudio[i][j];
				k++;
			}
		}
		
		return audio;
	}
}
