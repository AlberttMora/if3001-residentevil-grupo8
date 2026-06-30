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
		panelNotas.setBounds(420, 670, 500, 80);
		panelNotas.setOpaque(false);
		panelNotas.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));

		lblSlenderIzq = new JLabel(Assets.getSlenderIzq());
		lblSlenderIzq.setBounds(152, 99, 240, 527);
		lblSlenderIzq.setVisible(false);

		lblSlenderDer = new JLabel(Assets.getSlenderDer());
		lblSlenderDer.setBounds(608, 99, 240, 527);
		lblSlenderDer.setVisible(false);

		lblNotaIzq = new JLabel();
		lblNotaIzq.setBounds(227, 230, 100, 161);
		lblNotaIzq.setVisible(false);

		lblNotaDer = new JLabel();
		lblNotaDer.setBounds(673, 230, 100, 161);
		lblNotaDer.setVisible(false);

		btnPuertaIzq = new JButton();
		btnPuertaIzq.setBounds(152, 99, 240, 527);
		btnPuertaIzq.setOpaque(false);
		btnPuertaIzq.setContentAreaFilled(false);
		btnPuertaIzq.setBorderPainted(false);
		btnPuertaIzq.setFocusPainted(false);

		btnPuertaDer = new JButton();
		btnPuertaDer.setBounds(608, 99, 240, 527);
		btnPuertaDer.setOpaque(false);
		btnPuertaDer.setContentAreaFilled(false);
		btnPuertaDer.setBorderPainted(false);
		btnPuertaDer.setFocusPainted(false);

		lblPuertaIzqCerrada = new JLabel(Assets.getImgDoorIzq());
		lblPuertaIzqCerrada.setBounds(152, 99, 240, 527);
		lblPuertaIzqCerrada.setVisible(false);

		lblPuertaDerCerrada = new JLabel(Assets.getImgDoorDer());
		lblPuertaDerCerrada.setBounds(608, 99, 240, 527);
		lblPuertaDerCerrada.setVisible(false);

		btnSiguiente = new JButton(Assets.getBtnNext1());
		btnSiguiente.setBounds(450, 450, 103, 62);
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
			JLabel lbl = new JLabel(new javax.swing.ImageIcon(
					Assets.getNote(numero).getImage().getScaledInstance(50, 80, java.awt.Image.SCALE_SMOOTH)));
			panelNotas.add(lbl);
		}
		panelNotas.repaint();
		panelNotas.revalidate();
	}

	public void mostrarNotaEnPuerta(String lado, int numero) {
		if (lado.equalsIgnoreCase("izq")) {
			lblNotaIzq.setIcon(Assets.getNote(numero));
			lblNotaIzq.setVisible(true);
		} else {
			lblNotaDer.setIcon(Assets.getNote(numero));
			lblNotaDer.setVisible(true);
		}
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