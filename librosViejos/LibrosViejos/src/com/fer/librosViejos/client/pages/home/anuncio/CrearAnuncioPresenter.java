package com.fer.librosViejos.client.pages.home.anuncio;

import com.fer.librosViejos.client.model.Anuncio;
import com.fer.librosViejos.client.model.TipoAnuncio;
import com.fer.librosViejos.client.services.anuncios.ServiceAnuncios;
import com.fer.librosViejos.client.services.anuncios.ServiceAnunciosAsync;
import com.fer.t1.client.Presenter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class CrearAnuncioPresenter extends Presenter<CrearAnuncioHandler> implements
		CrearAnuncioHandler {

	ServiceAnunciosAsync serviceBooks = GWT.create(ServiceAnuncios.class);
	
	@Override
	public void onPageSet() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onCreateAnuncio(String nombre, String descripcion, double precio) {
		Anuncio b = new Anuncio().init(nombre, getUserId(), descripcion, precio,TipoAnuncio.libro);
		serviceBooks.createAnuncio(b, new AsyncCallback<Void>() {
			
			@Override
			public void onSuccess(Void result) {
				getView().notifyBookCration();
			}
			
			@Override
			public void onFailure(Throwable caught) {
				getView().onError("Hubo un error al intentar crear el libro seleccionado");
			}
		});
		
	}

	private String getUserId() {
		return "";
	}

	private CrearAnuncioView getView()
	{
		return (CrearAnuncioView) view;
	}
}
