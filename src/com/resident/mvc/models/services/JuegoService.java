package com.resident.mvc.models.services;
 
import com.resident.mvc.models.ArbolBinario;
import com.resident.mvc.models.Nota;
import com.resident.mvc.models.Notas;
import com.resident.mvc.models.Puerta;
 
import java.util.LinkedList;
import java.util.Queue;
 
public class JuegoService {
 
    private static final int VIDAS_INICIALES = 3;
    private static final String TIPO_NOTA    = "NOTA";
    private static final String TIPO_SLENDER = "SLENDER";
 
    private int vidas;
    private ArbolBinario<Puerta> arbol;
    private Notas notas;
    private Queue<Nota> colaPendientes;
 
    public JuegoService() {
        this.arbol           = new ArbolBinario<>();
        this.notas           = new Notas();
        this.colaPendientes  = new LinkedList<>();
    }
 
 
    public void iniciar() {
        vidas           = VIDAS_INICIALES;
        notas.inicializar();
        colaPendientes  = notas.getNotasOcultas();
        arbol.generarArbol(colaPendientes);
    }
 
    public void reiniciar() {
        iniciar();
    }
 
    public String procesarEleccion(int lado) {
        Puerta puerta = (lado == 0) ? arbol.getIzquierda() : arbol.getDerecha();
        
        if (puerta == null) return "NADA";

        arbol.avanzar(lado);
        String resultado = puerta.getTipo();

        if (TIPO_NOTA.equals(resultado)) {
            Nota nota = puerta.getNota();
            if (nota != null) notas.marcarEncontrada(nota.getId());
        } else if (TIPO_SLENDER.equals(resultado)) {
            vidas--;
        }

        return resultado;
    }
    
 
    public int getVidas() {
        return vidas;
    }
 
    public int getNotasEncontradas() {
        return notas.getTotalEncontradas();
    }
 
    public int getTotalNotas() {
        return notas.getTotal();
    }
 
    public boolean haGanado() {
        return notas.todasEncontradas();
    }
 
    public boolean haPerdido() {
        return vidas <= 0;
    }
 
    public Puerta getPuertaIzquierda() {
        return arbol.getIzquierda();
    }
 
    public Puerta getPuertaDerecha() {
        return arbol.getDerecha();
    }
    
    public void regenerarArbol() {
        colaPendientes = notas.getNotasOcultas();
        arbol.reiniciar();
        arbol.generarArbol(colaPendientes);
    }
    
    public boolean esHoja() {
        return arbol != null && arbol.esHoja();
    }
}