package com.resident.mvc.models;

public class Puerta {
	private String id;
	private String tipo;
	private Nota nota;

	public Puerta() {
		// TODO Auto-generated constructor stub
	}

	public Puerta(String id, String tipo, Nota nota) {
		this.id = id;
		this.tipo = tipo;
		this.nota = nota;
	}

	public String getId() {
		return id;
	}

	public String getTipo() {
		return tipo;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota n) {
		this.nota = n;
	}
	

}
