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

public class PanelGanador extends JPanel {
//
    private JLabel lblFondo;
    //private JLabel lblNiebla;
    private JLabel lblLogo;
    private JPanel panelControl;
    private JButton btnMas;
    private JButton btnSalir;

    public PanelGanador() {
        setLayout(null);
        setBounds(0, 0, 1024, 768);
        setBackground(Color.BLACK);
        setOpaque(true);

        btnSalir = new JButton(Assets.getBtnSalir1());
        btnSalir.setBounds(827, 13, 143, 58);
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

        ImageIcon textWinOriginal = Assets.getTextWin();
        int tww = textWinOriginal.getIconWidth();
        int twh = textWinOriginal.getIconHeight();
        double escalaTexto = 900.0 / tww;
        int twNuevo = (int) Math.round(tww * escalaTexto);
        int thNuevo = (int) Math.round(twh * escalaTexto);
        lblLogo = new JLabel(new ImageIcon(
                textWinOriginal.getImage().getScaledInstance(twNuevo, thNuevo, Image.SCALE_SMOOTH)));
        lblLogo.setBounds((1024 - twNuevo) / 2, 90, twNuevo, thNuevo);

        panelControl = new JPanel();
        panelControl.setBounds(312, 550, 400, 150);
        panelControl.setOpaque(false);
        panelControl.setLayout(new FlowLayout());

        btnMas = new JButton(Assets.getBtnMore1());
        btnMas.setBounds(0, 0, 103, 62);
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

        panelControl.add(btnMas);

        //lblNiebla = new JLabel(Assets.getNiebla());
        //lblNiebla.setBounds(0, 0, 2422, 681);
        lblFondo = new JLabel(Assets.getBgWin());
        lblFondo.setBounds(0, 0, 1024, 768);

        add(btnSalir);
        add(lblLogo);
        add(panelControl);
        //add(lblNiebla);
        add(lblFondo);
    }

    public JLabel getLblFondo()     { return lblFondo; }
    //public JLabel getLblNiebla()    { return lblNiebla; }
    public JLabel getLblLogo()      { return lblLogo; }
    public JPanel getPanelControl() { return panelControl; }
    public JButton getBtnMas()      { return btnMas; }
    public JButton getBtnSalir()    { return btnSalir; }
}