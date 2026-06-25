package com.resident.mvc.models.services;

import javax.sound.sampled.*;
import java.net.URL;
import java.io.IOException;
 
public class SonidoService {
 
	private static final String PATH_DENTRO    = "/resources/sounds/DentroDelJuego.wav";
	private static final String PATH_SLENDER   = "/resources/sounds/GritoSlender.wav";
	private static final String PATH_INICIO    = "/resources/sounds/PantallaDeInicio.wav";
	private static final String PATH_FINAL     = "/resources/sounds/PantallaFinal.wav";
	private static final String PATH_PUERTA    = "/resources/sounds/SonidoPuerta.wav";
 
    private Clip musicaDentroDelJuego;
    private Clip gritoSlender;
    private Clip musicaInicio;
    private Clip musicaFinal;
    private Clip sonidoPuerta;
 
    public SonidoService() {
        musicaDentroDelJuego = cargarClip(PATH_DENTRO);
        gritoSlender         = cargarClip(PATH_SLENDER);
        musicaInicio         = cargarClip(PATH_INICIO);
        musicaFinal          = cargarClip(PATH_FINAL);
        sonidoPuerta         = cargarClip(PATH_PUERTA);
    }
 
 
    public void reproducirMusicaJuego() {
        detenerTodo();
        reproducirClip(musicaDentroDelJuego, true);
    }
 
    public void reproducirMusicaInicio() {
        detenerTodo();
        reproducirClip(musicaInicio, true);
    }
 
    public void reproducirMusicaFinal() {
        detenerTodo();
        reproducirClip(musicaFinal, true);
    }
 
    public void reproducirGritoSlender() {
        reproducirClip(gritoSlender, false);
    }
 
    public void reproducirPuerta() {
        reproducirClip(sonidoPuerta, false);
    }
 
    public void detenerTodo() {
        detenerClip(musicaDentroDelJuego);
        detenerClip(musicaInicio);
        detenerClip(musicaFinal);
        detenerClip(gritoSlender);
        detenerClip(sonidoPuerta);
    }
 
 
    private Clip cargarClip(String ruta) {
        try {
            URL url = getClass().getResource(ruta);
            if (url == null) {
                System.err.println("[SonidoService] No se encontró: " + ruta);
                return null;
            }
            AudioInputStream ais = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            return clip;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.err.println("[SonidoService] Error cargando " + ruta + ": " + e.getMessage());
            return null;
        }
    }
 
    private void reproducirClip(Clip clip, boolean loop) {
        if (clip == null) return;
        if (clip.isRunning()) clip.stop();
        clip.setFramePosition(0);
        if (loop) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } else {
            clip.start();
        }
    }
 
    private void detenerClip(Clip clip) {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.setFramePosition(0);
        }
    }
}