package com.resident.mvc.assets;

import java.net.URL;

import javax.swing.ImageIcon;

public class Assets {

	private static final String IMG = "/resources/img/";
	private static final String SND = "/resources/sounds/";

	// Fondos
	private static final String BG_INICIO = IMG + "bg_inicio.png";
	private static final String BG_SEGUNDO_INICIO = IMG + "bg_segundo_inicio.png";
	private static final String BG_TERCER_INICIO = IMG + "bg_tercer_inicio.png";
	private static final String BG_CUARTO_INICIO = IMG + "bg_cuarto_inicio.png";
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
	private static final String SPECIMEN_IZQ = IMG + "specimen_izq.png";
	private static final String SPECIMEN_DER = IMG + "specimen_der.png";

	// Sonidos
	private static final String SND_INICIO = SND + "theme.wav";
	private static final String SND_JUEGO = SND + "game.wav";
	private static final String SND_FINAL = SND + "over.wav";
	private static final String SND_SLENDER = SND + "slender.wav";
	private static final String SND_PUERTA = SND + "door.wav";
	private static final String SND_GLITCH = SND + "giltch.wav";

	// --- Imagenes ---
	public static ImageIcon getBgInicio() {
    ImageIcon icon = img(BG_INICIO);
    java.awt.Image imagenEscalada = icon.getImage().getScaledInstance(1880, 800, java.awt.Image.SCALE_SMOOTH);
    return new ImageIcon(imagenEscalada);
}

	public static ImageIcon getBgSegundoInicio() {
		return img(BG_SEGUNDO_INICIO);
	}

	public static ImageIcon getBgInicio2() {
		return img(BG_SEGUNDO_INICIO);
	}

	public static ImageIcon getBgTercerInicio() {
		return img(BG_TERCER_INICIO);
	}

	public static ImageIcon getBgInicio3() {
		return img(BG_TERCER_INICIO);
	}

	public static ImageIcon getBgCuartoInicio() {
		return img(BG_CUARTO_INICIO);
	}

	public static ImageIcon getBgInicio4() {
		return img(BG_CUARTO_INICIO);
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
		ImageIcon raw = img(BTN_DOOR_IZQ);
		return new ImageIcon(raw.getImage().getScaledInstance(137, 365, java.awt.Image.SCALE_SMOOTH));
	}

	public static ImageIcon getBtnDoorDer() {
		ImageIcon raw = img(BTN_DOOR_DER);
		return new ImageIcon(raw.getImage().getScaledInstance(143, 357, java.awt.Image.SCALE_SMOOTH));
	}

	public static ImageIcon getImgDoorIzq() {
		ImageIcon raw = flipH(img(IMG_DOOR_IZQ));
		return new ImageIcon(raw.getImage().getScaledInstance(150, 375, java.awt.Image.SCALE_SMOOTH));
	}

	public static ImageIcon getImgDoorDer() {
		ImageIcon raw = flipH(img(IMG_DOOR_DER));
		return new ImageIcon(raw.getImage().getScaledInstance(140, 365, java.awt.Image.SCALE_SMOOTH));
	}

	public static ImageIcon getSpecimenIzq() {
		return img(SPECIMEN_IZQ);
	}

	public static ImageIcon getSpecimenDer() {
		return img(SPECIMEN_DER);
	}

	public static ImageIcon getNote(int n) {
		if (n < 1 || n > 6)
			throw new IllegalArgumentException("Nota invalida: " + n);
		return img(IMG + "note." + n + ".png");
	}

	// --- Sonidos (URL para AudioInputStream en SonidoService) ---
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

	public static URL getSndGlitch() {
		return snd(SND_GLITCH);
	}

	private static ImageIcon flipH(ImageIcon icon) {
		java.awt.image.BufferedImage src = toBufferedImage(icon.getImage());
		java.awt.geom.AffineTransform tx = java.awt.geom.AffineTransform.getScaleInstance(-1, 1);
		tx.translate(-src.getWidth(), 0);
		java.awt.image.AffineTransformOp op = new java.awt.image.AffineTransformOp(
				tx, java.awt.image.AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		return new ImageIcon(op.filter(src, null));
	}

	private static java.awt.image.BufferedImage toBufferedImage(java.awt.Image img) {
		if (img instanceof java.awt.image.BufferedImage)
			return (java.awt.image.BufferedImage) img;
		java.awt.image.BufferedImage b = new java.awt.image.BufferedImage(
				img.getWidth(null), img.getHeight(null), java.awt.image.BufferedImage.TYPE_INT_ARGB);
		java.awt.Graphics2D g2 = b.createGraphics();
		g2.drawImage(img, 0, 0, null);
		g2.dispose();
		return b;
	}

	private static ImageIcon img(String ruta) {
		URL url = Assets.class.getResource(ruta);
		if (url == null)
			throw new RuntimeException("Recurso no encontrado: " + ruta);
		return new ImageIcon(url);
	}

	private static URL snd(String ruta) {
		URL url = Assets.class.getResource(ruta);
		if (url == null)
			throw new RuntimeException("Sonido no encontrado: " + ruta);
		return url;
	}

	private Assets() {
	}
}