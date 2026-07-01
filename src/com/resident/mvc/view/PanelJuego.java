package com.resident.mvc.view;

import com.resident.mvc.assets.Assets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;

public class PanelJuego extends JPanel {

	private JLabel lblFondo;
	private JButton btnPuertaIzq;
	private JButton btnPuertaDer;
	private JLabel lblPuertaIzqCerrada;
	private JLabel lblPuertaDerCerrada;
	private JLabel lblSlenderIzq;
	private JLabel lblSlenderDer;
	private JLabel lblNotaIzq;
	private JLabel lblNotaDer;
	private JPanel panelNotas;
	private JLabel lblVidas;
	private JLabel lblNotas;
	private JButton btnSiguiente;
	private JButton btnSalir;

	public PanelJuego() {
		setLayout(null);
		setBounds(0, 0, 1024, 768);
		setBackground(Color.BLACK);
		setOpaque(true);

		btnSalir = new JButton(Assets.getBtnSalir1());
		btnSalir.setBounds(900, 30, 83, 50);
		btnSalir.setOpaque(false);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorderPainted(false);
		btnSalir.setFocusPainted(false);
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSalir.setIcon(Assets.getBtnSalir2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnSalir.setIcon(Assets.getBtnSalir1());
			}
		});

		panelNotas = new JPanel();
		panelNotas.setBounds(310, 660, 600, 95);
		panelNotas.setOpaque(false);
		panelNotas.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));

		// Posiciones recalibradas para calzar con los pilares y el piso del
		// pasillo de bg_question.png (puerta izq y der, mismo tamano).
		final int puertaX_izq = 268;
		final int puertaX_der = 568;
		final int puertaY = 255;
		final int puertaW = 185;
		final int puertaH = 375;
		
		lblSlenderIzq = new JLabel(Assets.getSpecimenIzq());
		lblSlenderIzq.setBounds(297, 282, 140, 361);
		lblSlenderIzq.setVisible(false);

		lblSlenderDer = new JLabel(Assets.getSpecimenDer());
		lblSlenderDer.setPreferredSize(new Dimension(243, 527));
		lblSlenderDer.setBounds(613, 286, 133, 361);
		lblSlenderDer.setVisible(false);

		lblNotaIzq = new JLabel();
		lblNotaIzq.setBounds(287, 390, 150, 105);
		lblNotaIzq.setVisible(false);

		lblNotaDer = new JLabel();
		lblNotaDer.setBounds(puertaX_der + 18, puertaY + 135, 150, 105);
		lblNotaDer.setVisible(false);
//
		btnPuertaIzq = new JButton();
		btnPuertaIzq.setBounds(297, 282, 137, 365);
		btnPuertaIzq.setOpaque(false);
		btnPuertaIzq.setContentAreaFilled(false);
		btnPuertaIzq.setBorderPainted(false);
		btnPuertaIzq.setFocusPainted(false);

		btnPuertaDer = new JButton();
		btnPuertaDer.setBounds(603, 286, 143, 357);
		btnPuertaDer.setOpaque(false);
		btnPuertaDer.setContentAreaFilled(false);
		btnPuertaDer.setBorderPainted(false);
		btnPuertaDer.setFocusPainted(false);

		lblPuertaIzqCerrada = new JLabel(Assets.getImgDoorIzq());
		lblPuertaIzqCerrada.setBounds(287, 276, 150, 375);
		lblPuertaIzqCerrada.setVisible(false);

		lblPuertaDerCerrada = new JLabel(Assets.getImgDoorDer());
		lblPuertaDerCerrada.setBounds(603, 283, 140, 365);
		lblPuertaDerCerrada.setVisible(false);

		btnSiguiente = new JButton(Assets.getBtnNext1());
		btnSiguiente.setBounds(465, 390, 103, 62);
		btnSiguiente.setOpaque(false);
		btnSiguiente.setContentAreaFilled(false);
		btnSiguiente.setBorderPainted(false);
		btnSiguiente.setFocusPainted(false);
		btnSiguiente.setVisible(false);
		btnSiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSiguiente.setIcon(Assets.getBtnNext2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnSiguiente.setIcon(Assets.getBtnNext1());
			}
		});

		lblNotas = new JLabel("0");
		lblNotas.setBounds(200, 698, 50, 50);
		lblNotas.setFont(new Font("Consolas", Font.PLAIN, 35));
		lblNotas.setForeground(Color.WHITE);

		lblVidas = new JLabel("0");
		lblVidas.setBounds(200, 658, 50, 50);
		lblVidas.setFont(new Font("Consolas", Font.PLAIN, 35));
		lblVidas.setForeground(Color.WHITE);

		lblFondo = new JLabel(Assets.getBgQuestion());
		lblFondo.setBounds(0, 0, 1024, 768);

		add(btnSalir);
		add(panelNotas);
		add(lblSlenderIzq);
		add(lblSlenderDer);
		add(lblNotaIzq);
		add(lblNotaDer);
		add(btnPuertaIzq);
		add(btnPuertaDer);
		add(lblPuertaIzqCerrada);
		add(lblPuertaDerCerrada);
		add(btnSiguiente);
		add(lblNotas);
		add(lblVidas);
		add(lblFondo);
	}

	public JButton getBtnPuertaIzq() {
		return btnPuertaIzq;
	}

	public JButton getBtnPuertaDer() {
		return btnPuertaDer;
	}

	public JButton getBtnSiguiente() {
		return btnSiguiente;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public JLabel getLblFondo() {
		return lblFondo;
	}

	public void setVidasTexto(String texto) {
		lblVidas.setText(texto);
	}

	public void setNotasTexto(String texto) {
		lblNotas.setText(texto);
	}

	public void setNotasEncontradas(int[] numerosNotas) {
		panelNotas.removeAll();
		for (int numero : numerosNotas) {
			JLabel lbl = new JLabel(escalarNota(Assets.getNote(numero), 90, 63));
			panelNotas.add(lbl);
		}
		panelNotas.repaint();
		panelNotas.revalidate();
	}

	public void mostrarNotaEnPuerta(String lado, int numero) {
		if (lado.equalsIgnoreCase("izq")) {
			lblNotaIzq.setIcon(escalarNota(Assets.getNote(numero), lblNotaIzq.getWidth(), lblNotaIzq.getHeight()));
			lblNotaIzq.setVisible(true);
		} else {
			lblNotaDer.setIcon(escalarNota(Assets.getNote(numero), lblNotaDer.getWidth(), lblNotaDer.getHeight()));
			lblNotaDer.setVisible(true);
		}
	}

	private javax.swing.ImageIcon escalarNota(javax.swing.ImageIcon original, int w, int h) {
		java.awt.Image img = original.getImage();
		int iw = original.getIconWidth();
		int ih = original.getIconHeight();
		double escala = Math.min(w / (double) iw, h / (double) ih);
		int nw = (int) Math.round(iw * escala);
		int nh = (int) Math.round(ih * escala);
		return new javax.swing.ImageIcon(img.getScaledInstance(nw, nh, java.awt.Image.SCALE_SMOOTH));
	}

	public void mostrarSlenderEnPuerta(String lado) {
		if (lado.equalsIgnoreCase("izq")) {
			lblSlenderIzq.setVisible(true);
		} else {
			lblSlenderDer.setVisible(true);
		}
	}

	public void mostrarConsecuencia(String lado) {
		btnPuertaIzq.setVisible(false);
		btnPuertaDer.setVisible(false);
		if (lado.equalsIgnoreCase("izq")) {
			lblPuertaIzqCerrada.setVisible(true);
		} else {
			lblPuertaDerCerrada.setVisible(true);
		}
		btnSiguiente.setVisible(true);
	}

	public void ocultarConsecuencia() {
		btnSiguiente.setVisible(false);
		lblPuertaIzqCerrada.setVisible(false);
		lblPuertaDerCerrada.setVisible(false);
		lblSlenderIzq.setVisible(false);
		lblSlenderDer.setVisible(false);
		lblNotaIzq.setVisible(false);
		lblNotaDer.setVisible(false);
		btnPuertaIzq.setVisible(true);
		btnPuertaDer.setVisible(true);
	}
}