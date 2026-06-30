package com.resident.mvc.models;

public class Nota {

	private final int numero;
	private boolean encontrada;

	public Nota(int numero) {
		this.numero = numero;
		this.encontrada = false;
	}

	public int getNumero() {
		return numero;
	}

	public boolean isEncontrada() {
		return encontrada;
	}

	public void setEncontrada(boolean encontrada) {
		this.encontrada = encontrada;
	}

	@Override
	public String toString() {
		return "Nota[" + numero + ", encontrada=" + encontrada + "]";
	}
}