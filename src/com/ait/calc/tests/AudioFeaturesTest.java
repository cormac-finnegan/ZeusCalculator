package com.ait.calc.tests;

import static org.junit.Assert.*;

import javax.sound.sampled.UnsupportedAudioFileException;

import org.junit.Test;

import com.ait.calc.init.AudioInit;
import com.ait.calc.view.FFTGUI;

public class AudioFeaturesTest {
	
	@Test
	public void testAudioStartFromFile() {
		AudioInit.audioStart(true, "zephyr.wav");
	}
	
	@Test
	public void testAudioStartFromMic() {
		AudioInit.audioStart(false, "");
	}

	@Test
	public void testAudioStopFromFile() {
		AudioInit.audioStart(true, "zephyr.wav");
		AudioInit.audioStop();
	}
	
	@Test
	public void testAudioDCT() throws InterruptedException {
		AudioInit.audioCompressor("testFile.wav", 99);
		Thread.sleep(1000);
	}
	
}