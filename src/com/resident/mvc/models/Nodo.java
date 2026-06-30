package com.resident.mvc.models;

public class Nodo<T> {

	private T dato;
	private Nodo<T> izquierdo;
	private Nodo<T> derecho;

	public Nodo() {
	}

	public Nodo(T dato) {
		this.dato = dato;
		this.izquierdo = null;
		this.derecho = null;
	}

	public Nodo(T dato, Nodo<T> izquierdo, Nodo<T> derecho) {
		this.dato = dato;
		this.izquierdo = izquierdo;
		this.derecho = derecho;
	}

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public Nodo<T> getIzquierdo() {
		return izquierdo;
	}

	public void setIzquierdo(Nodo<T> izquierdo) {
		this.izquierdo = izquierdo;
	}

	public Nodo<T> getDerecho() {
		return derecho;
	}

	public void setDerecho(Nodo<T> derecho) {
		this.derecho = derecho;
	}

}