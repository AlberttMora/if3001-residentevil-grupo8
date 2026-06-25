package com.resident.mvc.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.resident.mvc.models.Puerta;
import com.resident.mvc.models.services.AnimacionService;
import com.resident.mvc.models.services.JuegoService;
import com.resident.mvc.models.services.SonidoService;
import com.resident.mvc.view.PanelGanador;
import com.resident.mvc.view.PanelJuego;
import com.resident.mvc.view.PanelPerdedor;
import com.resident.mvc.view.ViewPrincipal;

public class ControllerJuego {

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
	}

	private void setupListeners() {

		vp.getBtnJugar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				iniciarJuego();
			}
		});

		vp.getBtnSalir().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});

		panelJuego.getBtnPuertaIzq().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (panelJuego.getBtnPuertaIzq().isEnabled()) {
					procesarEleccion(0);
				}
			}
		});

		panelJuego.getBtnPuertaDer().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (panelJuego.getBtnPuertaDer().isEnabled()) {
					procesarEleccion(1);
				}
			}
		});

		panelJuego.getBtnSalir().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});

		panelJuego.getBtnSiguiente().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				siguienteRonda();
			}
		});

		panelGanador.getLblVolverJugar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				reiniciarJuego();
			}
		});

		panelGanador.getLblSalir().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});

		panelPerdedor.getLblVolverJugar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				reiniciarJuego();
			}
		});

		panelPerdedor.getLblSalir().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
	}

	private void iniciarJuego() {
		juegoService.iniciar();
		actualizarHUD();
		panelJuego.getPnlNotasEncontradas().removeAll();
		panelJuego.getPnlNotasEncontradas().revalidate();
		panelJuego.getPnlNotasEncontradas().repaint();
		panelJuego.habilitarPuertas(true);
		panelJuego.mostrarSiguiente(false);
		vp.mostrarPanel(panelJuego);
		sonidoService.reproducirMusicaJuego();
	}

	private void procesarEleccion(int lado) {
		panelJuego.habilitarPuertas(false);
		sonidoService.reproducirPuerta();

		Puerta puertaElegida = (lado == 0) ? juegoService.getPuertaIzquierda() : juegoService.getPuertaDerecha();
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
			return;
		}

		if (juegoService.haPerdido()) {
			mostrarFinal("PERDEDOR");
			return;
		}

		panelJuego.mostrarSiguiente(true);
	}

	private void siguienteRonda() {
	    
	    if (juegoService.esHoja()) {
	        juegoService.regenerarArbol();
	    }
	    
	    panelJuego.mostrarSiguiente(false);
	    panelJuego.habilitarPuertas(true);
	}

	private void mostrarFinal(String modo) {
		sonidoService.reproducirMusicaFinal();

		if ("GANADOR".equals(modo)) {
			vp.mostrarPanel(panelGanador);
		} else {
			vp.mostrarPanel(panelPerdedor);
			animService.iniciarGameOver(panelPerdedor);
		}
	}

	private void reiniciarJuego() {
		animService.detenerTodo();
		juegoService.reiniciar();
		actualizarHUD();
		panelJuego.getPnlNotasEncontradas().removeAll();
		panelJuego.getPnlNotasEncontradas().revalidate();
		panelJuego.getPnlNotasEncontradas().repaint();
		panelJuego.habilitarPuertas(true);
		panelJuego.mostrarSiguiente(false);
		vp.mostrarPanel(panelJuego);
		sonidoService.reproducirMusicaJuego();
	}

	private void actualizarHUD() {
		panelJuego.setVidas(juegoService.getVidas());
		panelJuego.setNotas(juegoService.getNotasEncontradas(), juegoService.getTotalNotas());
	}
}