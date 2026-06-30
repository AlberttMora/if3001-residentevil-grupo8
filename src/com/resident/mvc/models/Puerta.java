package com.resident.mvc.models;

public class Puerta {

	private final int numero;
	private final ContenidoPuerta tipo;
	private Nota nota;

	public Puerta(int numero, ContenidoPuerta tipo) {
		this.numero = numero;
		this.tipo = tipo;
		this.nota = null;
	}

	public int getNumero() {
		return numero;
	}

	public ContenidoPuerta getTipo() {
		return tipo;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Puerta[" + numero + ", " + tipo + "]";
	}
}