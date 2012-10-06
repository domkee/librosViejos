package com.fer.librosViejos.client.pages.home.anuncio;

import com.fer.t1.client.EventHandler;

public interface CrearAnuncioHandler extends EventHandler {

	void onCreateAnuncio(String nombre, String descripcion, double precio);

}
