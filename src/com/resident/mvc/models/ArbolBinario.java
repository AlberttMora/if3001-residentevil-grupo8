package com.resident.mvc.models;

public class ArbolBinario {

	private Nodo<Puerta> raiz;
	private Nodo<Puerta> nodoActual;

	public ArbolBinario() {
		this.raiz = null;
		this.nodoActual = null;
	}

	public void vaciar() {
		raiz = null;
		nodoActual = null;
	}

	public void insertar(Puerta puerta) {
		Nodo<Puerta> nuevo = new Nodo<>(puerta);
		if (raiz == null) {
			raiz = nuevo;
		} else {
			insertar(nuevo, raiz);
		}
	}

	private void insertar(Nodo<Puerta> nuevo, Nodo<Puerta> padre) {
		if (nuevo.getDato().getNumero() <= padre.getDato().getNumero()) {
			if (padre.getIzquierdo() == null) {
				padre.setIzquierdo(nuevo);
			} else {
				insertar(nuevo, padre.getIzquierdo());
			}
		} else {
			if (padre.getDerecho() == null) {
				padre.setDerecho(nuevo);
			} else {
				insertar(nuevo, padre.getDerecho());
			}
		}
	}

	/**
	 * Mueve el puntero actual al hijo izquierdo o derecho (lado 0 = izq, 1 = der).
	 */
	public void avanzar(int lado) {
		if (nodoActual == null)
			return;
		if (lado == 0 && nodoActual.getIzquierdo() != null) {
			nodoActual = nodoActual.getIzquierdo();
		} else if (lado == 1 && nodoActual.getDerecho() != null) {
			nodoActual = nodoActual.getDerecho();
		}
	}

	public Puerta getIzquierda() {
		if (nodoActual != null && nodoActual.getIzquierdo() != null) {
			return nodoActual.getIzquierdo().getDato();
		}
		return null;
	}

	public Puerta getDerecha() {
		if (nodoActual != null && nodoActual.getDerecho() != null) {
			return nodoActual.getDerecho().getDato();
		}
		return null;
	}

	public boolean esHoja() {
		if (nodoActual == null)
			return true;
		return nodoActual.getIzquierdo() == null && nodoActual.getDerecho() == null;
	}

	/** Reinicia el recorrido desde la raï¿½z. */
	public void reiniciar() {
		nodoActual = raiz;
	}

	public Nodo<Puerta> getRaiz() {
		return raiz;
	}

	public Nodo<Puerta> getNodoActual() {
		return nodoActual;
	}
}