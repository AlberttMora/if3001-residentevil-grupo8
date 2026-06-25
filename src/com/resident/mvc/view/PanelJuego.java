package com.resident.mvc.view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.GridLayout;

public class PanelJuego extends JPanel {
	private JPanel btnPuertaIzq;
	private JPanel btnPuertaDer;
	private JLabel btnSalir;
	private JLabel btnSiguiente;
	private JPanel pnlNotasEncontradas;

	/**
	 * Create the panel.
	 */
	public PanelJuego() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btnPuertaIzq = new JPanel();
		btnPuertaIzq.setOpaque(false);
		btnPuertaIzq.setIgnoreRepaint(true);
		btnPuertaIzq.setBounds(396, 133, 151, 331);
		panel.add(btnPuertaIzq);
		btnPuertaIzq.setLayout(null);
		
		btnPuertaDer = new JPanel();
		btnPuertaDer.setLayout(null);
		btnPuertaDer.setOpaque(false);
		btnPuertaDer.setIgnoreRepaint(true);
		btnPuertaDer.setBounds(654, 133, 151, 331);
		panel.add(btnPuertaDer);
		
		pnlNotasEncontradas = new JPanel();
		pnlNotasEncontradas.setOpaque(false);
		pnlNotasEncontradas.setBounds(810, 510, 330, 55);
		panel.add(pnlNotasEncontradas);
		pnlNotasEncontradas.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnSalir = new JLabel("");
		btnSalir.setIcon(new ImageIcon(PanelJuego.class.getResource("/resources/img/botonSalir.fw.png")));
		btnSalir.setBounds(0, 0, 259, 112);
		panel.add(btnSalir);
		
		JLabel imgVidas_Notas = new JLabel("");
		imgVidas_Notas.setIcon(new ImageIcon(PanelJuego.class.getResource("/resources/img/Vidas_Notas.fw.png")));
		imgVidas_Notas.setBounds(0, 488, 259, 112);
		panel.add(imgVidas_Notas);
		
		JLabel imgVerNotas = new JLabel("");
		imgVerNotas.setBounds(732, 466, 468, 145);
		panel.add(imgVerNotas);
		imgVerNotas.setIcon(new ImageIcon(PanelJuego.class.getResource("/resources/img/verNotas.fw.png")));
		
		btnSiguiente = new JLabel("");
		btnSiguiente.setIcon(new ImageIcon(PanelJuego.class.getResource("/resources/img/botonSiguiente.fw.png")));
		btnSiguiente.setBounds(905, -23, 295, 135);
		panel.add(btnSiguiente);
		
		JLabel imgP_Juego = new JLabel("");
		imgP_Juego.setIcon(new ImageIcon(PanelJuego.class.getResource("/resources/img/PantallaJuego.fw.png")));
		imgP_Juego.setBounds(0, 0, 1200, 600);
		panel.add(imgP_Juego);
	}

	public JPanel getBtnPuertaIzq() {
		return btnPuertaIzq;
	}

	public void setBtnPuertaIzq(JPanel btnPuertaIzq) {
		this.btnPuertaIzq = btnPuertaIzq;
	}

	public JPanel getBtnPuertaDer() {
		return btnPuertaDer;
	}

	public void setBtnPuertaDer(JPanel btnPuertaDer) {
		this.btnPuertaDer = btnPuertaDer;
	}

	public JLabel getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JLabel btnSalir) {
		this.btnSalir = btnSalir;
	}

	public JLabel getBtnSiguiente() {
		return btnSiguiente;
	}

	public void setBtnSiguiente(JLabel btnSiguiente) {
		this.btnSiguiente = btnSiguiente;
	}

	public JPanel getPnlNotasEncontradas() {
		return pnlNotasEncontradas;
	}

	public void setPnlNotasEncontradas(JPanel pnlNotasEncontradas) {
		this.pnlNotasEncontradas = pnlNotasEncontradas;
	}
	
	public void habilitarPuertas(boolean habilitar) {
	    btnPuertaIzq.setEnabled(habilitar);
	    btnPuertaDer.setEnabled(habilitar);
	}

	public void mostrarSiguiente(boolean visible) {
	    btnSiguiente.setVisible(visible);
	}

	public void setVidas(int vidas) {
	    // Aquí deberías actualizar un JLabel que muestre las vidas
	}

	public void setNotas(int encontradas, int total) {
	    // Aquí deberías actualizar un JLabel o texto que muestre "Notas: x/y"
	}
}
