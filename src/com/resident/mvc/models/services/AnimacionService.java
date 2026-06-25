package com.resident.mvc.models.services;



import com.resident.mvc.view.PanelGanador;
import com.resident.mvc.view.PanelJuego;
import com.resident.mvc.view.PanelPerdedor;
import com.resident.mvc.view.ViewPrincipal;
 
import javax.swing.*;
import java.awt.*;
 
public class AnimacionService {
 
    private Timer timerInicio;
    private Timer timerJuego;
    private Timer timerFinal;
 
    private static final int DELAY_SUAVE  = 30;  
    private static final int DELAY_BRUSCO = 16;  
    private static final int PASO_SUAVE   = 1;   
    private static final int PASO_BRUSCO  = 20; 
 
 
    
    public void iniciarAnimacionInicio(ViewPrincipal vp) {
        detenerTimer(timerInicio);
 
        JPanel panel = (JPanel) vp.getContentPane().getComponent(0);
        JLabel fondo = (JLabel) panel.getComponent(panel.getComponentCount() - 1);
 
        int anchoOriginal = fondo.getWidth();
        int[] x = {fondo.getX()};
 
        timerInicio = new Timer(DELAY_SUAVE, e -> {
            x[0] -= PASO_SUAVE;
            if (Math.abs(x[0]) >= anchoOriginal) x[0] = 0;
            fondo.setLocation(x[0], fondo.getY());
        });
        timerInicio.start();
    }
 
   
    public void iniciarAnimacionJuego(PanelJuego panelJuego) {
        detenerTimer(timerJuego);
 
        JPanel panelInterno = (JPanel) panelJuego.getComponent(0);
        JLabel fondo = (JLabel) panelInterno.getComponent(panelInterno.getComponentCount() - 1);
 
        int anchoOriginal = fondo.getWidth();
        int[] x = {fondo.getX()};
 
        timerJuego = new Timer(DELAY_SUAVE, e -> {
            x[0] -= PASO_SUAVE;
            if (Math.abs(x[0]) >= anchoOriginal) x[0] = 0;
            fondo.setLocation(x[0], fondo.getY());
        });
        timerJuego.start();
    }
 
    public void iniciarVictoria(PanelGanador panelGanador) {
        detenerTimer(timerFinal);
 
        JLabel fondo = (JLabel) panelGanador.getComponent(panelGanador.getComponentCount() - 1);
        int anchoOriginal = fondo.getWidth();
        int[] x = {fondo.getX()};
 
        timerFinal = new Timer(DELAY_SUAVE, e -> {
            x[0] -= PASO_SUAVE;
            if (Math.abs(x[0]) >= anchoOriginal) x[0] = 0;
            fondo.setLocation(x[0], fondo.getY());
        });
        timerFinal.start();
    }
 
    
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
        detenerTimer(timerInicio);
        detenerTimer(timerJuego);
        detenerTimer(timerFinal);
    }
 
 
    private void detenerTimer(Timer t) {
        if (t != null && t.isRunning()) t.stop();
    }
}
 
