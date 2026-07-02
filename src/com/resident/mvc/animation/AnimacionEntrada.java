package com.resident.mvc.animation;

import com.resident.mvc.assets.Assets;

import javax.swing.*;
import java.awt.*;

public class AnimacionEntrada {

        private static final int DURACION_IMAGEN_MS = 1800;
        private static final float PASO_FADE = 0.07f;

        /**
         * Inicia la animacion de acercamiento via glass pane.
         * Flujo: fade-a-negro -> imagen1 fade-in -> espera -> fade-out -> imagen2 ... -> callback
         */
        public void iniciar(JFrame frame, Runnable alTerminar) {
                int fw = frame.getWidth();
                int fh = frame.getHeight();
                int offsetX = (fw - 1024) / 2;
                int offsetY = (fh - 768) / 2;

                // Pre-escalar imagenes antes de mostrar nada (evita lag visible)
                ImageIcon[] fases = {
                        escalar(Assets.getBgSegundoInicio(), 1024, 768),
                        escalar(Assets.getBgTercerInicio(),  1024, 768),
                        escalar(Assets.getBgCuartoInicio(),  1024, 768)
                };

                float[] alpha = { 0f };

                JLabel lblImagen = new JLabel();
                lblImagen.setBounds(offsetX, offsetY, 1024, 768);

                // Mascara negra superpuesta que controla visibilidad con fade
                JPanel mascara = new JPanel() {
                        @Override
                        protected void paintComponent(Graphics g) {
                                Graphics2D g2 = (Graphics2D) g.create();
                                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha[0]));
                                g2.setColor(Color.BLACK);
                                g2.fillRect(0, 0, getWidth(), getHeight());
                                g2.dispose();
                        }
                        @Override public boolean isOpaque() { return false; }
                };
                mascara.setBounds(0, 0, fw, fh);

                JPanel overlay = new JPanel(null) {
                        @Override public boolean isOptimizedDrawingEnabled() { return false; }
                };
                overlay.setOpaque(false);
                overlay.setBounds(0, 0, fw, fh);
                overlay.add(mascara);
                overlay.add(lblImagen);

                java.util.concurrent.atomic.AtomicBoolean terminado =
                                new java.util.concurrent.atomic.AtomicBoolean(false);
                Runnable finSeguro = () -> {
                        if (terminado.compareAndSet(false, true)) {
                                overlay.setVisible(false);
                                SwingUtilities.invokeLater(alTerminar);
                        }
                };
                overlay.addMouseListener(new java.awt.event.MouseAdapter() {
                        @Override
                        public void mousePressed(java.awt.event.MouseEvent e) {
                                finSeguro.run();
                        }
                });

                frame.setGlassPane(overlay);
                overlay.setVisible(true);

                // Paso 1: oscurecer pantalla actual (alpha 0->1)
                fade(alpha, mascara, 0f, 1f, () ->
                        mostrarSiguiente(0, fases, alpha, mascara, lblImagen, overlay, finSeguro)
                );
        }

        private void mostrarSiguiente(int idx, ImageIcon[] fases, float[] alpha,
                        JPanel mascara, JLabel lblImagen, JPanel overlay, Runnable alTerminar) {

                if (idx >= fases.length) {
                        fade(alpha, mascara, 0f, 1f, alTerminar);
                        return;
                }

                lblImagen.setIcon(fases[idx]);
                overlay.repaint();
                fade(alpha, mascara, 1f, 0f, () -> {
                        Timer espera = new Timer(DURACION_IMAGEN_MS, e -> {
                                ((Timer) e.getSource()).stop();
                                fade(alpha, mascara, 0f, 1f, () ->
                                        mostrarSiguiente(idx + 1, fases, alpha, mascara, lblImagen, overlay, alTerminar)
                                );
                        });
                        espera.setRepeats(false);
                        espera.start();
                });
        }

        private void fade(float[] alpha, JPanel mascara, float desde, float hasta, Runnable alTerminar) {
                alpha[0] = desde;
                boolean subiendo = hasta > desde;
                Timer t = new Timer(15, null);
                t.addActionListener(e -> {
                        alpha[0] = subiendo
                                ? Math.min(alpha[0] + PASO_FADE, hasta)
                                : Math.max(alpha[0] - PASO_FADE, hasta);
                        mascara.repaint();
                        if (Math.abs(alpha[0] - hasta) < 0.005f) {
                                alpha[0] = hasta;
                                t.stop();
                                SwingUtilities.invokeLater(alTerminar);
                        }
                });
                t.start();
        }

        private ImageIcon escalar(ImageIcon src, int w, int h) {
                return new ImageIcon(src.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH));
        }
}
