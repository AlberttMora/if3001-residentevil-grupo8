package com.resident.mvc.models.services;

import com.resident.mvc.view.PanelPerdedor;

import javax.swing.*;

public class AnimacionService {

    private Timer timerFinal;

    private static final int DELAY_BRUSCO = 16;
    private static final int PASO_BRUSCO  = 20;

    public void iniciarGameOver(PanelPerdedor panelPerdedor) {
        detenerTimer(timerFinal);

        JLabel fondo = (JLabel) panelPerdedor.getComponent(panelPerdedor.getComponentCount() - 1);
        int xOriginal = fondo.getX();
        int[] direccion = {1};

        timerFinal = new Timer(DELAY_BRUSCO, e -> {
            int xActual = fondo.getX();
            int nuevoX = xActual + (PASO_BRUSCO * direccion[0]);
            if (nuevoX > xOriginal + 40 || nuevoX < xOriginal - 40) {
                direccion[0] *= -1;
            }
            fondo.setLocation(nuevoX, fondo.getY());
        });
        timerFinal.start();
    }

    public void detenerTodo() {
        detenerTimer(timerFinal);
    }

    private void detenerTimer(Timer t) {
        if (t != null && t.isRunning()) t.stop();
    }
}