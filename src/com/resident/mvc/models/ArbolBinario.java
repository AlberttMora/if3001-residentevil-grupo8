package com.resident.mvc.models;

import java.util.Queue;

public class ArbolBinario<Puerta> {
	private Nodo<Puerta> raiz;
	private Nodo<Puerta> nodoActual;

	public ArbolBinario() {
		// TODO Auto-generated constructor stub
	}
	
	public void generarArbol(Queue<Nota> cola){
		
	}
	
	public Puerta getIzquierda() {
		if (nodoActual!=null&&nodoActual.getIzquierdo()!=null) {
			return nodoActual.getIzquierdo().getDato();
			
			
		}
		return null;
		
	}
	
	public Puerta getDerecha() {
		if (nodoActual!=null&&nodoActual.getDerecho()!=null) {
			return nodoActual.getDerecho().getDato();
			
			
		}
		return null;
		
	}
	public void avanzar(int lado) {
		if (nodoActual==null)
			return;
		if(lado == 0 && nodoActual.getIzquierdo()!=null) {
			nodoActual=nodoActual.getIzquierdo();
			
		} else if(lado == 1&& nodoActual.getDerecho()!=null) {
			nodoActual=nodoActual.getDerecho();
		}
			
		
	}
	
	public boolean esHoja() {
		if (nodoActual==null) 
			return true;
		return nodoActual.getIzquierdo()==null&&nodoActual.getDerecho()==null;
		
		
		
	}
	
	public void reiniciar() {
		this.nodoActual=this.raiz; 
	}

}
