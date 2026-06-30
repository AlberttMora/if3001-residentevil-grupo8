package com.resident.mvc.models.services;

import com.resident.mvc.assets.Assets;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class SonidoService {

	private Clip musicaInicio;
	private Clip musicaJuego;
	private Clip musicaFinal;
	private Clip gritoSlender;
	private Clip sonidoPuerta;

	public SonidoService() {
		musicaInicio = cargar(Assets.getSndInicio());
		musicaJuego = cargar(Assets.getSndJuego());
		musicaFinal = cargar(Assets.getSndFinal());
		gritoSlender = cargar(Assets.getSndSlender());
		sonidoPuerta = cargar(Assets.getSndPuerta());
	}

	public void reproducirMusicaInicio() {
		detenerTodo();
		loop(musicaInicio);
	}

	public void reproducirMusicaJuego() {
		detenerTodo();
		loop(musicaJuego);
	}

	public void reproducirMusicaFinal() {
		detenerTodo();
		loop(musicaFinal);
	}

	public void reproducirGritoSlender() {
		play(gritoSlender);
	}

	public void reproducirPuerta() {
		play(sonidoPuerta);
	}

	public void detenerTodo() {
		detener(musicaInicio);
		detener(musicaJuego);
		detener(musicaFinal);
		detener(gritoSlender);
		detener(sonidoPuerta);
	}

	private Clip cargar(URL url) {
		try {
			AudioInputStream audio = AudioSystem.getAudioInputStream(url);
			Clip clip = AudioSystem.getClip();
			clip.open(audio);
			return clip;
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
			return null;
		}
	}

	private void loop(Clip clip) {
		if (clip == null)
			return;
		clip.stop();
		clip.setFramePosition(0);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	private void play(Clip clip) {
		if (clip == null)
			return;
		clip.stop();
		clip.setFramePosition(0);
		clip.start();
	}

	private void detener(Clip clip) {
		if (clip != null && clip.isRunning()) {
			clip.stop();
			clip.setFramePosition(0);
		}
	}
}