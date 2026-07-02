package com.resident.mvc.view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ViewPrincipal extends JFrame {

	private JPanel contenedor;

	private PanelInicio panelInicio;
	private PanelJuego panelJuego;
	private PanelGanador panelGanador;
	private PanelPerdedor panelPerdedor;
//
	public ViewPrincipal() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.BLACK);
		setLayout(null);

		contenedor = new JPanel(null);
		contenedor.setBackground(Color.BLACK);
		contenedor.setBounds(0, 0, 1024, 768);

		panelInicio = new PanelInicio();
		panelJuego = new PanelJuego();
		panelGanador = new PanelGanador();
		panelPerdedor = new PanelPerdedor();

		panelJuego.setVisible(false);
		panelGanador.setVisible(false);
		panelPerdedor.setVisible(false);

		contenedor.add(panelInicio);
		contenedor.add(panelJuego);
		contenedor.add(panelGanador);
		contenedor.add(panelPerdedor);

		getContentPane().add(contenedor);
	}

	public void init() {
		setLocationRelativeTo(null);
		setVisible(true);
		centrarContenedor();
	}

	private void centrarContenedor() {
		int x = (getWidth() - contenedor.getWidth()) / 2;
		int y = (getHeight() - contenedor.getHeight()) / 2;
		contenedor.setBounds(x, y, contenedor.getWidth(), contenedor.getHeight());
	}

	public void mostrarPanel(String nombre) {
		panelInicio.setVisible(false);
		panelJuego.setVisible(false);
		panelGanador.setVisible(false);
		panelPerdedor.setVisible(false);

		switch (nombre.toLowerCase()) {
		case "inicio":
			panelInicio.setVisible(true);
			break;
		case "juego":
			panelJuego.setVisible(true);
			break;
		case "ganador":
			panelGanador.setVisible(true);
			break;
		case "perdedor":
			panelPerdedor.setVisible(true);
			break;
		}
	}

	public PanelInicio getPanelInicio() {
		return panelInicio;
	}

	public PanelJuego getPanelJuego() {
		return panelJuego;
	}

	public PanelGanador getPanelGanador() {
		return panelGanador;
	}

	public PanelPerdedor getPanelPerdedor() {
		return panelPerdedor;
	}
}