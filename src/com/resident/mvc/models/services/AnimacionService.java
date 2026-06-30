package com.resident.mvc.models.services;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimacionService {

	private static final int DELAY_EXPANSION = 30;
	private static final int DELAY_GAMEOVER = 16;
	private static final int PASO_GAMEOVER = 20;

	private Timer timerExpansion;
	private Timer timerScrollBg;
	private Timer timerScrollNiebla;
	private Timer timerGameOver;

	/**
	 * Animación de entrada: expande verticalmente el panel desde el centro. El
	 * botón recibido se oculta durante la animación y vuelve al terminar.
	 */
	public void iniciarExpansion(JPanel panel, JButton boton) {
		detenerTimer(timerExpansion);
		boton.setVisible(false);
		panel.setVisible(false);

		final int x = panel.getX();
		final int w = panel.getWidth();
		final int alturaFinal = panel.getHeight();
		final int[] y = { panel.getY() + alturaFinal / 2 };
		final int[] h = { 0 };
		final int[] paso = { 0 };

		timerExpansion = new Timer(DELAY_EXPANSION, e -> {
			panel.setBounds(x, --y[0], w, h[0] += 2);
			panel.setVisible(true);
			if (++paso[0] >= alturaFinal / 2) {
				timerExpansion.stop();
				boton.setVisible(true);
				panel.repaint();
				panel.revalidate();
			}
		});
		timerExpansion.setInitialDelay(500);
		timerExpansion.start();
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
		detenerTimer(timerExpansion);
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