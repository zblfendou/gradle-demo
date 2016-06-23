package com.utils;

import it.sauronsoftware.jave.*;

import java.io.File;

/**
 * Created by Administrator on 2016.6.23.
 */
public class Wav2Mp3 {
	/**
	 * wav转化mp3
	 * @param source
	 * @param desFileName
	 * @throws EncoderException
	 */
	public static void wav2Mp3 (File source, String desFileName) throws EncoderException {
		File target = new File (desFileName);
		AudioAttributes audio = new AudioAttributes ();
		audio.setCodec ("libmp3lame");
		audio.setBitRate (new Integer (1280000)); //音频比率 MP3默认是1280000
		audio.setChannels (new Integer (2));
		audio.setSamplingRate (new Integer (44100));
		EncodingAttributes attrs = new EncodingAttributes ();
		attrs.setFormat ("mp3");
		attrs.setAudioAttributes (audio);
		Encoder encoder = new Encoder ();
		encoder.encode (source, target, attrs);
	}

	public static void main (String[] args) throws EncoderException {
		wav2Mp3 (new File ("d:/menu.wav"), "d:/123.mp3");
	}
}
