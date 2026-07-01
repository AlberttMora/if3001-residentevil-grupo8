package com.resident.mvc.models;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Almacén principal de notas usando HashMap<id, Nota>. Provee la Queue temporal
 * de notas ocultas para generación del árbol.
 */
public class Notas {

	private final HashMap<Integer, Nota> mapa;
	private Nota ultimaNotaEncontrada;

	public Notas() {
		mapa = new HashMap<>();
	}

	public void inicializar() {
		mapa.clear();
		ultimaNotaEncontrada = null;
		for (int i = 1; i <= 6; i++) {
			mapa.put(i, new Nota(i));
		}
	}

	public void marcarEncontrada(int numero) {
		Nota nota = mapa.get(numero);

		if (nota != null) {
			nota.setEncontrada(true);
			ultimaNotaEncontrada = nota;
		}
	}

	public Nota getNota(int numero) {
		return mapa.get(numero);
	}

	/**
	 * Cola temporal con solo las notas aún ocultas — para el ArbolGeneratorService.
	 */
	public Queue<Nota> getColaOcultas() {
		Queue<Nota> cola = new LinkedList<>();
		for (int i = 1; i <= 6; i++) {
			Nota n = mapa.get(i);
			if (n != null && !n.isEncontrada()) {
				cola.offer(n);
			}
		}
		return cola;
	}

	public boolean todasEncontradas() {
		for (Nota n : mapa.values()) {
			if (!n.isEncontrada())
				return false;
		}
		return true;
	}

	public int getTotalEncontradas() {
		int cont = 0;
		for (Nota n : mapa.values()) {
			if (n.isEncontrada())
				cont++;
		}
		return cont;
	}

	public int[] getNumerosEncontrados() {
		int[] encontrados = new int[getTotalEncontradas()];
		int indice = 0;

		for (int i = 1; i <= 6; i++) {
			Nota nota = mapa.get(i);
			if (nota != null && nota.isEncontrada()) {
				encontrados[indice++] = i;
			}
		}

		return encontrados;
	}

	public int getTotal() {
		return mapa.size();
	}
	
	public Nota getUltimaNotaEncontrada() {
	    return ultimaNotaEncontrada;
	}

	public void reiniciar() {
		ultimaNotaEncontrada = null;
		for (Nota n : mapa.values()) {
			n.setEncontrada(false);
		}
	}
}