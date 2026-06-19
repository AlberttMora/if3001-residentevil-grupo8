package com.resident.mvc.models;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Notas {
	private  HashMap<String,Nota>mapa;

	public Notas() {
		mapa = new HashMap<>();
	}
	public void inicializar() {
		
	}
	
	public Nota getNota(String id) {
		return mapa.get(id);
	}
	public void marcarEncontrada(String id) {
		if (mapa.containsKey(id)) {
			
			mapa.get(id).setEncontrada(true);
		}
		
	}
	
	public Queue<Nota> getNotasOcultas(){
		return new LinkedList<>();
	}
	public boolean todasEncontradas() {
		for (Nota nota : mapa.values()) {
			if (!nota.isEncontrada()) {
				return false;
			}
			
		}
		return true;
		
		
	}
	
	public int getTotal() {
		return mapa.size();
	}
	
	
	public int getTotalEncontradas() {
		int cont=0;
		for (Nota nota : mapa.values()) {
			if (nota.isEncontrada()) {
				cont++;
				
			}
			
		}
		return cont;
	}
	
	
	
	

	
}
