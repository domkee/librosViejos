package com.fer.librosViejos.client.services.anuncios;

import java.util.Collection;
import java.util.List;

import com.fer.librosViejos.client.model.Anuncio;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ServiceAnunciosAsync {

	void createAnuncio(Anuncio book, AsyncCallback<Void> callback);

	void getLibros(String userId, AsyncCallback<List<Anuncio>> callback);

	void searchLibros(String searchTerm, AsyncCallback<Collection<Anuncio>> callback);

}
