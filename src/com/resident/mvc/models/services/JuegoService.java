package com.resident.mvc.models.services;

import com.resident.mvc.models.ArbolBinario;
import com.resident.mvc.models.ContenidoPuerta;
import com.resident.mvc.models.Notas;
import com.resident.mvc.models.Puerta;

public class JuegoService {

	private static final int VIDAS_INICIALES = 3;

	private int vidas;
	private final ArbolBinario arbol;
	private final Notas notas;
	private final ArbolGeneratorService generador;

	public JuegoService() {
		this.arbol = new ArbolBinario();
		this.notas = new Notas();
		this.generador = new ArbolGeneratorService();
	}

	public void iniciar() {
		vidas = VIDAS_INICIALES;
		notas.inicializar();
		generador.generar(arbol, notas.getColaOcultas());
	}

	public void reiniciar() {
		iniciar();
	}

	/**
	 * Procesa la elección del jugador (0 = izquierda, 1 = derecha). Actualiza
	 * vidas, marca nota encontrada y regenera el árbol si se llegó a una hoja y aún
	 * quedan notas ocultas.
	 */
	public ContenidoPuerta procesarEleccion(int lado) {
		Puerta puerta = (lado == 0) ? arbol.getIzquierda() : arbol.getDerecha();

		if (puerta == null) {
			generador.generar(arbol, notas.getColaOcultas());
			return ContenidoPuerta.NADA;
		}

		arbol.avanzar(lado);

		switch (puerta.getTipo()) {
		case NOTA:
			if (puerta.getNota() != null)
				notas.marcarEncontrada(puerta.getNota().getNumero());
			break;
		case SLENDERMAN:
			vidas--;
			break;
		default:
			break;
		}

		if (arbol.esHoja() && !haGanado()) {
			generador.generar(arbol, notas.getColaOcultas());
		}

		return puerta.getTipo();
	}

	public int[] getNumerosNotasEncontradas() {
		int total = getNotasEncontradas();
		int[] numeros = new int[total];
		int idx = 0;
		for (int i = 1; i <= getTotalNotas(); i++) {
			if (notas.getNota(i).isEncontrada()) {
				numeros[idx++] = i;
			}
		}
		return numeros;
	}

	public void regenerarArbol() {
		generador.generar(arbol, notas.getColaOcultas());
	}

	public Puerta getPuertaIzquierda() {
		return arbol.getIzquierda();
	}

	public Puerta getPuertaDerecha() {
		return arbol.getDerecha();
	}

	public boolean esHoja() {
		return arbol.esHoja();
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
}