package com.resident.mvc.models;

public class Nodo<T> {
	private T dato;
	private Nodo<T> izquierdo, derecho;

	public Nodo() {
		// TODO Auto-generated constructor stub
	}

	public Nodo(T dato, Nodo<T> izquierdo, Nodo<T> derecho) {
		this.dato = dato;
		this.izquierdo = izquierdo;
		this.derecho = derecho;
	}

	public T getDato() {
		return dato;
	}

	public Nodo<T> getIzquierdo() {
		return izquierdo;
	}

	public void setIzquierdo(Nodo<T> n) {
		this.izquierdo = n;
	}

	public Nodo<T> getDerecho() {
		return derecho;
	}

	public void setDerecho(Nodo<T> n) {
		this.derecho = n;
	}
	

}
