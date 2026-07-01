package com.resident.mvc.assets;

import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.ImageIcon;


public class Assets {

	private static final String IMG = "/resources/img/";
	private static final String SND = "/resources/sounds/";
	private static final Map<String, ImageIcon> ICON_CACHE = new ConcurrentHashMap<>();
	private static final Map<String, URL> SOUND_CACHE = new ConcurrentHashMap<>();

	// Fondos
	private static final String BG_INICIO = IMG + "bg_inicio.png";
	private static final String BG_INICIO_2 = IMG + "bg_segundo_inicio.png";
	private static final String BG_INICIO_3 = IMG + "bg_tercer_inicio.png";
	private static final String BG_INICIO_4 = IMG + "bg_cuarto_inicio.png";
	private static final String BG_QUESTION = IMG + "bg_question.png";
	private static final String BG_WIN = IMG + "bg_win.png";
	private static final String BG_OVER = IMG + "bg_over.png";
	private static final String BG_OVER_2 = IMG + "bg_over_2.png";
	private static final String NIEBLA = IMG + "niebla.png";

	// Overlays / logos
	private static final String LOGO = IMG + "logo.png";
	private static final String TEXT_WIN = IMG + "text_win.png";
	private static final String TEXT_OVER = IMG + "text_over.png";

	// Botones con dos estados
	private static final String BTN_PLAY_1 = IMG + "btn_play_1.png";
	private static final String BTN_PLAY_2 = IMG + "btn_play_2.png";
	private static final String BTN_SALIR_1 = IMG + "btn_salir_1.png";
	private static final String BTN_SALIR_2 = IMG + "btn_salir_2.png";
	private static final String BTN_NEXT_1 = IMG + "btn_next_1.png";
	private static final String BTN_NEXT_2 = IMG + "btn_next_2.png";
	private static final String BTN_MORE_1 = IMG + "btn_more_1.png";
	private static final String BTN_MORE_2 = IMG + "btn_more_2.png";

	// Puertas
	private static final String BTN_DOOR_IZQ = IMG + "btn_door_izq.png";
	private static final String BTN_DOOR_DER = IMG + "btn_door_der.png";
	private static final String IMG_DOOR_IZQ = IMG + "img_door_izq.png";
	private static final String IMG_DOOR_DER = IMG + "img_door_der.png";

	// Slenderman
	private static final String SLENDER_IZQ = IMG + "specimen_izq.png";
	private static final String SLENDER_DER = IMG + "specimen_der.png";

	// Sonidos
	private static final String SND_INICIO = SND + "theme.wav";
	private static final String SND_JUEGO = SND + "game.wav";
	private static final String SND_FINAL = SND + "over.wav";
	private static final String SND_SLENDER = SND + "slender.wav";
	private static final String SND_PUERTA = SND + "door.wav";

	// --- Im�genes ---
	public static ImageIcon getBgInicio() {
		return img(BG_INICIO);
	}
	public static ImageIcon getBgInicio2() {
	    return img(BG_INICIO_2);
	}

	public static ImageIcon getBgInicio3() {
	    return img(BG_INICIO_3);
	}

	public static ImageIcon getBgInicio4() {
	    return img(BG_INICIO_4);
	}

	public static ImageIcon getBgQuestion() {
		return img(BG_QUESTION);
	}

	public static ImageIcon getBgWin() {
		return img(BG_WIN);
	}

	public static ImageIcon getBgOver() {
		return img(BG_OVER);
	}

	public static ImageIcon getBgOver2() {
		return img(BG_OVER_2);
	}

	public static ImageIcon getNiebla() {
		return img(NIEBLA);
	}

	public static ImageIcon getLogo() {
		return img(LOGO);
	}

	public static ImageIcon getTextWin() {
		return img(TEXT_WIN);
	}

	public static ImageIcon getTextOver() {
		return img(TEXT_OVER);
	}

	public static ImageIcon getBtnPlay1() {
		return img(BTN_PLAY_1);
	}

	public static ImageIcon getBtnPlay2() {
		return img(BTN_PLAY_2);
	}

	public static ImageIcon getBtnSalir1() {
		return img(BTN_SALIR_1);
	}

	public static ImageIcon getBtnSalir2() {
		return img(BTN_SALIR_2);
	}

	public static ImageIcon getBtnNext1() {
		return img(BTN_NEXT_1);
	}

	public static ImageIcon getBtnNext2() {
		return img(BTN_NEXT_2);
	}

	public static ImageIcon getBtnMore1() {
		return img(BTN_MORE_1);
	}

	public static ImageIcon getBtnMore2() {
		return img(BTN_MORE_2);
	}

	public static ImageIcon getBtnDoorIzq() {
		return img(BTN_DOOR_IZQ);
	}

	public static ImageIcon getBtnDoorDer() {
		return img(BTN_DOOR_DER);
	}

	public static ImageIcon getImgDoorIzq() {
		return img(IMG_DOOR_IZQ);
	}

	public static ImageIcon getImgDoorDer() {
		return img(IMG_DOOR_DER);
	}

	public static ImageIcon getSpecimenIzq() {
		return img(SLENDER_IZQ);
	}

	public static ImageIcon getSpecimenDer() {
		return img(SLENDER_DER);
	}

	public static ImageIcon getNote(int n) {
		if (n < 1 || n > 6)
			throw new IllegalArgumentException("Nota invalida: " + n);
		return img(IMG + "note." + n + ".png");
	}

	public static URL getSndInicio() {
		return snd(SND_INICIO);
	}

	public static URL getSndJuego() {
		return snd(SND_JUEGO);
	}

	public static URL getSndFinal() {
		return snd(SND_FINAL);
	}

	public static URL getSndSlender() {
		return snd(SND_SLENDER);
	}

	public static URL getSndPuerta() {
		return snd(SND_PUERTA);
	}

	private static ImageIcon img(String ruta) {
		return ICON_CACHE.computeIfAbsent(ruta, key -> {
			URL url = resolver(key);
			if (url == null)
				throw new RuntimeException("Recurso no encontrado: " + key);
			return new ImageIcon(url);
		});
	}

	private static URL snd(String ruta) {
		return SOUND_CACHE.computeIfAbsent(ruta, key -> {
			URL url = resolver(key);
			if (url == null)
				throw new RuntimeException("Sonido no encontrado: " + key);
			return url;
		});
	}

	private static URL resolver(String ruta) {
		URL url = Assets.class.getResource(ruta);
		if (url == null && ruta.startsWith("/resources/")) {
			url = Assets.class.getResource(ruta.replaceFirst("^/resources", ""));
		}
		return url;
	}

	private Assets() {
	}
}