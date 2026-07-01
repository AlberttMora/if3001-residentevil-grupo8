package com.resident.mvc.view;

import com.resident.mvc.assets.Assets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelInicio extends JPanel {

	private JLabel lblFondo;
	//private JLabel lblNiebla;
	private JLabel lblLogo;
	private JPanel panelControl;
	private JButton btnJugar;
	private JButton btnSalir;

	public PanelInicio() {
		setLayout(null);
		setBounds(0, 0, 1024, 768);

		panelControl = new JPanel();
		panelControl.setBounds(100, 150, 400, 450);
		panelControl.setOpaque(false);
		panelControl.setLayout(new FlowLayout());

		lblLogo = new JLabel(Assets.getLogo());
		lblLogo.setBounds(0, 0, 400, 250);

		btnJugar = new JButton(Assets.getBtnPlay1());
		btnJugar.setBounds(0, 0, 194, 116);
		btnJugar.setOpaque(false);
		btnJugar.setContentAreaFilled(false);
		btnJugar.setBorderPainted(false);
		btnJugar.setFocusPainted(false);
		btnJugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnJugar.setIcon(Assets.getBtnPlay2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnJugar.setIcon(Assets.getBtnPlay1());
			}
		});

		panelControl.add(lblLogo);
		panelControl.add(btnJugar);

		//lblNiebla = new JLabel(Assets.getNiebla());
		//lblNiebla.setBounds(0, 0, 2422, 681);

		lblFondo = new JLabel(Assets.getBgInicio());
		lblFondo.setBounds(0, 0, 1805, 768);

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
//
		add(btnSalir);
		add(panelControl);
		//add(lblNiebla);
		add(lblFondo);
	}

	public JLabel getLblFondo() {
		return lblFondo;
	}

	//public JLabel getLblNiebla() {
		//return lblNiebla;
	//}

	public JLabel getLblLogo() {
		return lblLogo;
	}

	public JPanel getPanelControl() {
		return panelControl;
	}

	public JButton getBtnJugar() {
		return btnJugar;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}
}