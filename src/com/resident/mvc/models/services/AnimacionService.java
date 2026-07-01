package com.resident.mvc.models.services;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.*;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimacionService {

	private static final int DELAY_SECUENCIA = 25;
	private static final int DELAY_GAMEOVER = 16;
	private static final int PASO_GAMEOVER = 20;

	private Timer timerSecuencia;
	private Timer timerScrollBg;
	private Timer timerScrollNiebla;
	private Timer timerGameOver;

	/**
	 * Animacion de entrada dinde se expande verticalmente el panel desde el centro
	 *  El botn recibido se oculta durante la animación y vuelve al terminar.
	 */
	public void iniciarSecuenciaFondos(JLabel fondo, ImageIcon[] imagenes, int msVisible, int msTransicion) {
	    detenerTimer(timerSecuencia);
	    if (imagenes == null || imagenes.length == 0) return;

	    final int w = fondo.getWidth();
	    final int h = fondo.getHeight();

	    final BufferedImage[] frames = new BufferedImage[imagenes.length];
	    for (int i = 0; i < imagenes.length; i++) {
	        frames[i] = ajustarCover(imagenes[i].getImage(), w, h);
	    }

	    fondo.setIcon(new ImageIcon(frames[0])); // el primero aparece de una vez
	    if (frames.length == 1)
	        return;

	    final int pasosEspera = Math.max(1, msVisible / DELAY_SECUENCIA);
	    final int pasosTransicion = Math.max(1, msTransicion / DELAY_SECUENCIA);
	    final int[] indiceActual = { 0 };
	    final int[] pasoEspera = { 0 };
	    final int[] pasoTransicion = { 0 };
	    final boolean[] enTransicion = { false };

	    timerSecuencia = new Timer(DELAY_SECUENCIA, e -> {
	    	// Ya se llego al ultimo fond entonces este se queda quieto ahi
	    	if (indiceActual[0] >= frames.length - 1) {
	    	    detenerTimer(timerSecuencia);
	    	    return;
	    	}
	    	if (!enTransicion[0]) {
	            if (++pasoEspera[0] >= pasosEspera) {
	                enTransicion[0] = true;
	                pasoTransicion[0] = 0;
	            }
	            return;
	        }
	        pasoTransicion[0]++;
	        float alpha = Math.min(1f, pasoTransicion[0] / (float) pasosTransicion);
	        int siguiente = indiceActual[0] + 1;

	        BufferedImage compuesto = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	        Graphics2D g2 = compuesto.createGraphics();
	        g2.drawImage(frames[indiceActual[0]], 0, 0, null);
	        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
	        g2.drawImage(frames[siguiente], 0, 0, null);
	        g2.dispose();
	        fondo.setIcon(new ImageIcon(compuesto));

	        if (alpha >= 1f) {
	            indiceActual[0] = siguiente;
	            enTransicion[0] = false;
	            pasoEspera[0] = 0;
	        }
	    });
	    timerSecuencia.start();
	}
//esto es para austar las imagenes que aun no logro ajustar
	private BufferedImage ajustarCover(Image img, int w, int h) {
	    int iw = img.getWidth(null);
	    int ih = img.getHeight(null);
	    double escala = Math.max(w / (double) iw, h / (double) ih);
	    int nw = (int) Math.ceil(iw * escala);
	    int nh = (int) Math.ceil(ih * escala);
	    int x = (w - nw) / 2;
	    int y = (h - nh) / 2;

	    BufferedImage out = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = out.createGraphics();
	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	    g2.drawImage(img, x, y, nw, nh, null);
	    g2.dispose();
	    return out;
	}
	/**
	 * Scroll horizontal continuo del fondo de inicio o victoria. Llama
	 * detenerScrollBg() antes de iniciar una nueva para evitar acumular timers si
	 * se reinicia la pantalla.
	 */
	public void iniciarScrollBg(JLabel fondo, JPanel panel, boolean derecha, int velocidad) {
		detenerTimer(timerScrollBg);
		timerScrollBg = crearScrollTimer(fondo, panel, derecha, velocidad);
		timerScrollBg.start();
	}

	/**
	 * Scroll horizontal continuo de la niebla (imagen más ancha).
	 */
	public void iniciarScrollNiebla(JLabel fondo, JPanel panel, boolean derecha, int velocidad) {
		detenerTimer(timerScrollNiebla);
		timerScrollNiebla = crearScrollTimer(fondo, panel, derecha, velocidad);
		timerScrollNiebla.start();
	}

	/**
	 * Efecto de sacudida horizontal para la pantalla de derrota. Recibe solo el
	 * JLabel del fondo para no acoplar este service a la vista.
	 */
	public void iniciarGameOver(JLabel fondo) {
		detenerTimer(timerGameOver);
		final int xOriginal = fondo.getX();
		final int[] direccion = { 1 };

		timerGameOver = new Timer(DELAY_GAMEOVER, e -> {
			int nuevoX = fondo.getX() + (PASO_GAMEOVER * direccion[0]);
			if (nuevoX > xOriginal + 40 || nuevoX < xOriginal - 40) {
				direccion[0] *= -1;
			}
			fondo.setLocation(nuevoX, fondo.getY());
		});
		timerGameOver.start();
	}

	public void detenerTodo() {
		detenerTimer(timerSecuencia);
		detenerTimer(timerScrollBg);
		detenerTimer(timerScrollNiebla);
		detenerTimer(timerGameOver);
	}

	private Timer crearScrollTimer(JLabel fondo, JPanel panel, boolean derecha, int velocidad) {
		final int w = fondo.getWidth();
		final int h = fondo.getHeight();
		final int y = fondo.getY();
		final int pw = 1024;
		final int[] x = { derecha ? pw - w : 0 };
		final boolean[] volver = { derecha };

		return new Timer(velocidad, e -> {
			if (volver[0]) {
				if (++x[0] >= 0)
					volver[0] = false;
			} else {
				if (--x[0] <= pw - w)
					volver[0] = true;
			}
			fondo.setBounds(x[0], y, w, h);
			panel.repaint();
		});
	}

	private void detenerTimer(Timer timer) {
		if (timer != null && timer.isRunning())
			timer.stop();
	}
}