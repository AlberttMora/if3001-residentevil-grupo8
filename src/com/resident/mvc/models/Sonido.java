package com.resident.mvc.models;
public enum Sonido {

    DENTRO("/resources/sounds/DentroDelJuego.wav"),
    INICIO("/resources/sounds/PantallaDeInicio.wav"),
    FINAL("/resources/sounds/PantallaFinal.wav"),
    SLENDER("/resources/sounds/GritoSlender.wav"),
    PUERTA("/resources/sounds/SonidoPuerta.wav");

    private final String ruta;

    Sonido(String ruta) {
        this.ruta = ruta;
    }

    public String getRuta() {
        return ruta;
    }
}