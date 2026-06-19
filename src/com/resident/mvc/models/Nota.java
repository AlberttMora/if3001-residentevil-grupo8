package com.resident.mvc.models;

public class Nota {
	private String id;
	private String imagen;
	private boolean encontrada;

	public Nota() {
		// TODO Auto-generated constructor stub
	}

	public Nota(String id, String imagen, boolean encontrada) {
		this.id = id;
		this.imagen = imagen;
		this.encontrada = encontrada;
	}

	public String getId() {
		return id;
	}

	public String getImagen() {
		return imagen;
	}

	public boolean isEncontrada() {
		return encontrada;
	}

	public void setEncontrada(boolean v) {
		this.encontrada = v;
	}
	

}
