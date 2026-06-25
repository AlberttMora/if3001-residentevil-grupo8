package com.resident.mvc.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.resident.mvc.controllers.functions.Functions;
import com.resident.mvc.models.Puerta;
import com.resident.mvc.models.services.AnimacionService;
import com.resident.mvc.models.services.JuegoService;
import com.resident.mvc.models.services.SonidoService;
import com.resident.mvc.view.PanelGanador;
import com.resident.mvc.view.PanelJuego;
import com.resident.mvc.view.PanelPerdedor;
import com.resident.mvc.view.ViewPrincipal;

public class ControllerJuego extends Functions {

	private static final String TIPO_NOTA = "NOTA";
	private static final String TIPO_SLENDER = "SLENDER";

	private ViewPrincipal vp;
	private PanelJuego panelJuego;
	private PanelGanador panelGanador;
	private PanelPerdedor panelPerdedor;

	private JuegoService juegoService;
	private SonidoService sonidoService;
	private AnimacionService animService;

	public ControllerJuego() {
		this.vp = new ViewPrincipal();
		this.panelJuego = new PanelJuego();
		this.panelGanador = new PanelGanador();
		this.panelPerdedor = new PanelPerdedor();
		this.juegoService = new JuegoService();
		this.sonidoService = new SonidoService();
		this.animService = new AnimacionService();
	}

	public void init() {
		setupListeners();
		vp.init();
		sonidoService.reproducirMusicaInicio();
		animService.iniciarAnimacionInicio(vp);
	}

	private void setupListeners() {

		vp.getBtnJugar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				iniciarJuego();
			}
		});

		vp.getBtnSalir().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				System.exit(0);
			}
		});

		panelJuego.getBtnPuertaIzq().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				procesarEleccion(0);
			}
		});

		panelJuego.getBtnPuertaDer().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				procesarEleccion(1);
			}
		});

		panelJuego.getBtnSalir().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				System.exit(0);
			}
		});

		panelJuego.getBtnSiguiente().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				siguienteRonda();
			}
		});

		panelGanador.getLblVolverJugar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				reiniciarJuego();
			}
		});

		panelGanador.getLblSalir().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				System.exit(0);
			}
		});

		panelPerdedor.getLblVolverJugar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				reiniciarJuego();
			}
		});

		panelPerdedor.getLblSalir().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				System.exit(0);
			}
		});
	}

	private void iniciarJuego() {
		juegoService.iniciar();
		actualizarHUD();
		vp.mostrarPanel(panelJuego);
		sonidoService.reproducirMusicaJuego();
		animService.iniciarAnimacionJuego(panelJuego);
	}

	private void procesarEleccion(int lado) {
		sonidoService.reproducirPuerta();

		Puerta puertaElegida = (lado == 0)
				? juegoService.getPuertaIzquierda()
				: juegoService.getPuertaDerecha();

		String resultado = juegoService.procesarEleccion(lado);

		if (TIPO_SLENDER.equals(resultado)) {
			sonidoService.reproducirGritoSlender();
		} else if (TIPO_NOTA.equals(resultado) && puertaElegida != null && puertaElegida.getNota() != null) {
			JLabel imgNota = new JLabel();
			imgNota.setIcon(new ImageIcon(PanelJuego.class.getResource(puertaElegida.getNota().getImagen())));
			panelJuego.getPnlNotasEncontradas().add(imgNota);
			panelJuego.getPnlNotasEncontradas().revalidate();
			panelJuego.getPnlNotasEncontradas().repaint();
		}

		actualizarHUD();

		if (juegoService.haGanado()) {
			mostrarFinal("GANADOR");
		} else if (juegoService.haPerdido()) {
			mostrarFinal("PERDEDOR");
		}
	}

	private void siguienteRonda() {
		actualizarHUD();
	}

	private void mostrarFinal(String modo) {
		sonidoService.reproducirMusicaFinal();

		if ("GANADOR".equals(modo)) {
			vp.mostrarPanel(panelGanador);
			animService.iniciarVictoria(panelGanador);
		} else {
			vp.mostrarPanel(panelPerdedor);
			animService.iniciarGameOver(panelPerdedor);
		}
	}

	private void reiniciarJuego() {
		animService.detenerTodo();
		juegoService.reiniciar();
		actualizarHUD();
		vp.mostrarPanel(panelJuego);
		sonidoService.reproducirMusicaJuego();
		animService.iniciarAnimacionJuego(panelJuego);
	}

	private void actualizarHUD() {
		// Las vidas y notas se consultan desde juegoService.getVidas() /
		// juegoService.getNotasEncontradas() según se requiera mostrar en el HUD.
	}
	
	//Sera que si se suveeeeeeeeeeeeeeeeeeeeee
}