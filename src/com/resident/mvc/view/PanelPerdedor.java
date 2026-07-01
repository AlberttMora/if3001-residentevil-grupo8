package com.resident.mvc.view;

import com.resident.mvc.assets.Assets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelPerdedor extends JPanel {

	private JLabel lblFondo;
	//private JLabel lblNiebla;
	private JLabel lblLogo;
	private JPanel panelControl;
	private JButton btnMas;
	private JButton btnSalir;

	public PanelPerdedor() {
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

		panelControl = new JPanel();
		panelControl.setBounds(100, 150, 400, 450);
		panelControl.setOpaque(false);
//
		ImageIcon textOverOriginal = Assets.getTextOver();
		int tow = textOverOriginal.getIconWidth();
		int toh = textOverOriginal.getIconHeight();
		double escalaTexto = Math.min(260.0 / tow, 310.0 / toh);
		int twNuevo = (int) Math.round(tow * escalaTexto);
		int thNuevo = (int) Math.round(toh * escalaTexto);
		lblLogo = new JLabel(new ImageIcon(
		        textOverOriginal.getImage().getScaledInstance(twNuevo, thNuevo, Image.SCALE_SMOOTH)));
		lblLogo.setBounds(132, 40, 0, 0);

		btnMas = new JButton(Assets.getBtnMore1());
		btnMas.setBounds(-3, 367, 135, 70);
		btnMas.setOpaque(false);
		btnMas.setContentAreaFilled(false);
		btnMas.setBorderPainted(false);
		btnMas.setFocusPainted(false);
		btnMas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMas.setIcon(Assets.getBtnMore2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnMas.setIcon(Assets.getBtnMore1());
			}
		});
		panelControl.setLayout(null);

		panelControl.add(lblLogo);
		panelControl.add(btnMas);

		//lblNiebla = new JLabel(Assets.getNiebla());
		//lblNiebla.setBounds(0, 0, 2422, 681);

		ImageIcon bgOverOriginal = Assets.getBgOver();
		Image bgOverEscalada = bgOverOriginal.getImage().getScaledInstance(1104, 828, Image.SCALE_SMOOTH);
		lblFondo = new JLabel(new ImageIcon(bgOverEscalada));
		lblFondo.setBounds(-40, -30, 1104, 828);
		setLayout(null);

		add(btnSalir);
		add(panelControl);
		//add(lblNiebla);
		add(lblFondo);
	}

	public JLabel getLblFondo() {
		return lblFondo;
	}

	

	public JLabel getLblLogo() {
		return lblLogo;
	}

	public JPanel getPanelControl() {
		return panelControl;
	}

	public JButton getBtnMas() {
		return btnMas;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}
}