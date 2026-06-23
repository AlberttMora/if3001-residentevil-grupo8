package com.resident.mvc.view;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Image;

import javax.swing.ImageIcon;

public class PanelPerdedor extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelPerdedor() {
		setLayout(null);
		
		ImageIcon iconOriginal = new ImageIcon(PanelPerdedor.class.getResource("/resources/img/botonVolver_Jugar.fw.png"));
		Image imagenEscalada = iconOriginal.getImage().getScaledInstance(250, 50, Image.SCALE_SMOOTH);
		JLabel lblNewLabel = new JLabel("Volver a jugar");
		lblNewLabel.setIcon(new ImageIcon(imagenEscalada));
		lblNewLabel.setBounds(234, 304, 250, 50);
		add(lblNewLabel);
		
		ImageIcon iconOriginalSalir = new ImageIcon(PanelPerdedor.class.getResource("/resources/img/botonSalir.fw.png"));
		Image imagenEscaladaSalir = iconOriginalSalir.getImage().getScaledInstance(150, 45, Image.SCALE_SMOOTH);
		JLabel lblSalir = new JLabel("Salir");
		lblSalir.setIcon(new ImageIcon(imagenEscaladaSalir));
		lblSalir.setBounds(494, 307, 150, 45);
		add(lblSalir);
		
		ImageIcon iconFondo = new ImageIcon(PanelPerdedor.class.getResource("/resources/img/PantallaDead.fw.png"));
		Image imagenFondo = iconFondo.getImage().getScaledInstance(667, 384, Image.SCALE_SMOOTH);
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(imagenFondo));
		label.setBounds(0, 0, 667, 384);
		add(label);
		

	}

}
