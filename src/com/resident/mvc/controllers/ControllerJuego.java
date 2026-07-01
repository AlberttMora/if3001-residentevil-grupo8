package com.resident.mvc.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import com.resident.mvc.assets.Assets;
import com.resident.mvc.models.ContenidoPuerta;
import com.resident.mvc.models.Puerta;
import com.resident.mvc.models.services.AnimacionService;
import com.resident.mvc.models.services.JuegoService;
import com.resident.mvc.models.services.SonidoService;
import com.resident.mvc.view.PanelGanador;
import com.resident.mvc.view.PanelInicio;
import com.resident.mvc.view.PanelJuego;
import com.resident.mvc.view.PanelPerdedor;
import com.resident.mvc.view.ViewPrincipal;

public class ControllerJuego {

	private final ViewPrincipal vista;

	private final JuegoService juegoService;
	private final SonidoService sonidoService;
	private final AnimacionService animacionService;

	//private boolean primeraAnimacion = true;
	private boolean sonidoJuegoIniciado = true;
	private boolean bloqueado = false;

	public ControllerJuego() {

		juegoService = new JuegoService();
		sonidoService = new SonidoService();
		animacionService = new AnimacionService();

		vista = new ViewPrincipal();

		setupListeners();
	}

	public void init() {//

		vista.init();

		mostrarPantalla("inicio");
	}

	private void setupListeners() {

		PanelInicio inicio = vista.getPanelInicio();
		PanelJuego juego = vista.getPanelJuego();
		PanelGanador ganador = vista.getPanelGanador();
		PanelPerdedor perdedor = vista.getPanelPerdedor();

		inicio.getBtnJugar().addActionListener(e -> cargarJuego());
		inicio.getBtnSalir().addActionListener(e -> System.exit(0));
		juego.getBtnSalir().addActionListener(e -> System.exit(0));
		juego.getBtnPuertaIzq().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				juego.getBtnPuertaIzq().setIcon(Assets.getBtnDoorIzq());
				sonidoService.reproducirPuerta();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				juego.getBtnPuertaIzq().setIcon(null);
			}

		});

		juego.getBtnPuertaDer().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				juego.getBtnPuertaDer().setIcon(Assets.getBtnDoorDer());
				sonidoService.reproducirPuerta();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				juego.getBtnPuertaDer().setIcon(null);
			}

		});

		juego.getBtnPuertaIzq().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (!bloqueado) {
					manejarEleccion(0);
				}

			}

		});

		juego.getBtnPuertaDer().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (!bloqueado) {
					manejarEleccion(1);
				}

			}

		});

		juego.getBtnSiguiente().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (!bloqueado) {
					continuarJuego();
				}

			}

		});

		ganador.getBtnMas().addActionListener(e -> cargarJuego());
		ganador.getBtnSalir().addActionListener(e -> System.exit(0));
		perdedor.getBtnMas().addActionListener(e -> cargarJuego());
		perdedor.getBtnSalir().addActionListener(e -> System.exit(0));
	}

	private void cargarJuego() {
		juegoService.iniciar();
		sonidoJuegoIniciado = true;
		bloqueado = false;
		vista.getPanelJuego().ocultarConsecuencia();
		actualizarHud();
		mostrarPantalla("juego");
	}

	private void mostrarPantalla(String pantalla) {
		animacionService.detenerTodo();

		switch (pantalla.toLowerCase()) {
		case "inicio":
		    vista.mostrarPanel("inicio");
		    sonidoService.reproducirMusicaInicio();
		    ImageIcon[] secuenciaInicio = { Assets.getBgInicio(), Assets.getBgInicio2(), Assets.getBgInicio3(), Assets.getBgInicio4() };
		    animacionService.iniciarSecuenciaFondos(vista.getPanelInicio().getLblFondo(), secuenciaInicio, 2200, 1300);
		    break;

		case "juego":
			vista.mostrarPanel("juego");
			if (sonidoJuegoIniciado) {
				sonidoService.reproducirMusicaJuego();
				sonidoJuegoIniciado = false;
			}
			break;

		case "ganador":
		    vista.mostrarPanel("ganador");
		    sonidoService.reproducirMusicaFinal();
		    break;

		case "perdedor":
			vista.mostrarPanel("perdedor");
			sonidoService.reproducirMusicaFinal();
			animacionService.iniciarGameOver(vista.getPanelPerdedor().getLblFondo());
			break;
		}
	}

	private void manejarEleccion(int lado) {
		bloqueado = true;
		PanelJuego panel = vista.getPanelJuego();
		String ladoTexto = (lado == 0) ? "izq" : "der";

		Puerta puerta = (lado == 0) ? juegoService.getPuertaIzquierda() : juegoService.getPuertaDerecha();
		ContenidoPuerta resultado = juegoService.procesarEleccion(lado);

		switch (resultado) {
		case NOTA:
			int numeroNota = puerta.getNota().getNumero();
			panel.mostrarNotaEnPuerta(ladoTexto, numeroNota);
			break;

		case SLENDERMAN:
			panel.mostrarSlenderEnPuerta(ladoTexto);
			sonidoService.reproducirGritoSlender();
			break;

		case NADA:
			break;
		}

		panel.mostrarConsecuencia(ladoTexto);
		actualizarHud();

		if (juegoService.haGanado()) {
			mostrarPantalla("ganador");
			return;
		}

		if (juegoService.haPerdido()) {
			mostrarPantalla("perdedor");
			return;
		}

		bloqueado = false;
	}

	private void continuarJuego() {
		vista.getPanelJuego().ocultarConsecuencia();
		mostrarPantalla("juego");
	}

	private void actualizarHud() {
		PanelJuego panel = vista.getPanelJuego();
		panel.setVidasTexto(String.valueOf(juegoService.getVidas()));
		panel.setNotasTexto(juegoService.getNotasEncontradas() + "/" + juegoService.getTotalNotas());
		panel.setNotasEncontradas(juegoService.getNumerosNotasEncontradas());
	}
}