package com.ait.calc.init;

import java.util.Scanner;

import com.ait.calc.controller.AudioDCT;
import com.ait.calc.controller.Audio_IO;
import com.ait.calc.controller.FFTGUIController;
import com.ait.calc.view.FFTGUI;

public class AudioInit {
	
	private static FFTGUI gui;
	private static FFTGUIController fftGuiController;
	private static Thread fftGuiControllerThread;
	private static Thread audioIOThread;
	public static Audio_IO audioIO;
	
	/**
	 * Used only to test the code.
	 * Delete before final version.
	 * The boolean passed into audioStart method should be passed from the main GUI
	 * after a specific button is pressed.
	 */
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Press 1 to perform FFT from file.");
//		System.out.println("Press 2 to perform FFT Real-Time.");
//		int response = sc.nextInt();
//		
//		if(response == 1)
//			audioStart(true);
//		else
//			audioStart(false);
//	}
	
	/**
	 * Kick-start method for the Audio feature.
	 * fromFile flag should be passed from the main GUI after a specific button is pressed.
	 * 
	 * @param boolean fromFile
	 */
	public static void audioStart(boolean fromFile, String fileName) {
		gui = new FFTGUI();
		fftGuiController = new FFTGUIController(gui);
		fftGuiControllerThread = new Thread(fftGuiController);
		
		audioIO = new Audio_IO(fftGuiController, fromFile, fileName);
		audioIOThread = new Thread(audioIO);

		audioIOThread.start();
		fftGuiControllerThread.start();
	}
	
	/**
	 * Used to terminate the audio interface lines and threads.
	 * This will provide re-usability in the main application (instead of restarting it every time).
	 */
	public static void audioStop() {
		audioIO.closeLines();
		audioIO.keepRunning = false;
		fftGuiController.keepRunning = false;
	}
	
	public static void audioCompressor(String fileName, int qLevel) {
		AudioDCT compressor = new AudioDCT(fileName, qLevel);
		Thread compressorThread = new Thread(compressor);
		compressorThread.start();
	}
}
