package com.ait.calc.Init;

import com.ait.calc.Controller.Audio_IO;
import com.ait.calc.Controller.GUIController;
import com.ait.calc.View.FFTGUI;

public class FFTMain {
	public static void main(String[] args) {
		FFTGUI gui = new FFTGUI();
		GUIController guiController = new GUIController(gui);
		Thread guiControllerThread = new Thread(guiController);
		guiControllerThread.start();
		
		Audio_IO sound = new Audio_IO(guiController);
		Thread soundThread = new Thread(sound);
		soundThread.start();
	}
}
