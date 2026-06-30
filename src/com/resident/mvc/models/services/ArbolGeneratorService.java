package com.resident.mvc.models.services;

import com.resident.mvc.models.ArbolBinario;
import com.resident.mvc.models.ContenidoPuerta;
import com.resident.mvc.models.Nota;
import com.resident.mvc.models.Puerta;

import java.util.Queue;
import java.util.Random;

/**
 * Única responsabilidad: generar un ArbolBinario listo para jugar. Garantiza
 * que cada nota oculta quede asignada a exactamente una puerta de tipo NOTA.
 * Las puertas SLENDERMAN y NADA se insertan aleatoriamente entre medio.
 */
public class ArbolGeneratorService {

	private final Random random = new Random();

	public void generar(ArbolBinario arbol, Queue<Nota> notasOcultas) {
		arbol.vaciar();
		arbol.insertar(new Puerta(50, ContenidoPuerta.NADA));

		while (!notasOcultas.isEmpty()) {
			int numero = random.nextInt(100) + 1;
			ContenidoPuerta tipo = ContenidoPuerta.values()[random.nextInt(3)];
			Puerta puerta = new Puerta(numero, tipo);
			if (tipo == ContenidoPuerta.NOTA) {
				puerta.setNota(notasOcultas.poll());
			}
			arbol.insertar(puerta);
		}

		arbol.reiniciar();
	}
}