package com.resident.mvc.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ViewPrincipal extends JFrame {

	private JPanel contentPane;
	private JLabel btnJugar;
	private JLabel btnSalir;

	/**
	 * Create the frame.
	 */
	public ViewPrincipal() {
		setMaximumSize(new Dimension(1200, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(1200, 600));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(1200, 600));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		btnJugar = new JLabel("");
		btnJugar.setIcon(new ImageIcon(ViewPrincipal.class.getResource("/resources/img/botonJugar.fw.png")));
		btnJugar.setBounds(425, 390, 259, 112);
		panel.add(btnJugar);

		btnSalir = new JLabel("");
		btnSalir.setIcon(new ImageIcon(ViewPrincipal.class.getResource("/resources/img/botonSalir.fw.png")));
		btnSalir.setBounds(0, 0, 259, 112);
		panel.add(btnSalir);

		JLabel imgP_Inicio = new JLabel("");
		imgP_Inicio.setIcon(new ImageIcon(ViewPrincipal.class.getResource("/resources/img/pantallaInicio.fw.png")));
		imgP_Inicio.setPreferredSize(new Dimension(1200, 600));
		imgP_Inicio.setBounds(0, 0, 1172, 543);
		panel.add(imgP_Inicio);
	}
	
	public JLabel getBtnJugar() {
		return btnJugar;
	}

	public void setBtnJugar(JLabel btnJugar) {
		this.btnJugar = btnJugar;
	}

	public JLabel getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JLabel btnSalir) {
		this.btnSalir = btnSalir;
	}

	public void init() {
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
