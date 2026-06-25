package com.resident.mvc.view;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Image;

import javax.swing.ImageIcon;

public class PanelGanador extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelGanador() {
		setLayout(null);
		
		
		ImageIcon iconOriginalSalir = new ImageIcon(PanelGanador.class.getResource("/resources/img/botonSalir.fw.png"));
		Image imagenEscaladaSalir = iconOriginalSalir.getImage().getScaledInstance(150, 45, Image.SCALE_SMOOTH);
		JLabel lblSalir = new JLabel("Salir");
		lblSalir.setIcon(new ImageIcon(imagenEscaladaSalir));
		lblSalir.setBounds(506, 314, 150, 45);
		add(lblSalir);
		
		ImageIcon iconOriginal = new ImageIcon(PanelGanador.class.getResource("/resources/img/botonVolver_Jugar.fw.png"));
		Image imagenEscalada = iconOriginal.getImage().getScaledInstance(250, 50, Image.SCALE_SMOOTH);
		JLabel lblNewLabel = new JLabel("Volver a jugar");
		lblNewLabel.setIcon(new ImageIcon(imagenEscalada));
		lblNewLabel.setBounds(202, 311, 250, 50);
		add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PanelGanador.class.getResource("/resources/img/PantallaWinner.fw.png")));
		label.setBounds(0, 0, 1044, 627);
		add(label);

	}
}
