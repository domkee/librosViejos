package com.fer.librosViejos.client;

import com.fer.librosViejos.client.pages.anouncement.AnuncioHistory;
import com.fer.librosViejos.client.pages.anouncement.AnuncioPresenter;
import com.fer.librosViejos.client.pages.anouncement.AnuncioView;
import com.fer.librosViejos.client.pages.home.HomeHistory;
import com.fer.librosViejos.client.pages.home.HomePresenter;
import com.fer.librosViejos.client.pages.home.HomeView;
import com.fer.librosViejos.client.pages.home.anuncio.CrearAnuncioHistory;
import com.fer.librosViejos.client.pages.home.anuncio.CrearAnuncioPresenter;
import com.fer.librosViejos.client.pages.home.anuncio.CrearAnuncioView;
import com.fer.librosViejos.client.pages.search.SearchHistoryManager;
import com.fer.librosViejos.client.pages.search.SearchPresenter;
import com.fer.librosViejos.client.pages.search.SearchView;
import com.fer.t1.client.PageStarter;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.History;

public class LibrosViejos implements EntryPoint{

	@Override
	public void onModuleLoad() {
		
		PageStarter.start("mainPanel");
		PageStarter.startPage(
				new HomeHistory(), 
				new HomePresenter(), 
				new HomeView(), 
				"home");
		PageStarter.startPage(
				new SearchHistoryManager(),
				new SearchPresenter(), 
				new SearchView(), 
				"search");
		
		PageStarter.startPage(
				new CrearAnuncioHistory(),
				new CrearAnuncioPresenter(),
				new CrearAnuncioView(),
				"crearAnuncio");
		
		PageStarter.startPage(
				new AnuncioHistory(),
				new AnuncioPresenter(),
				new AnuncioView(),
				"anuncio");
		
		History.fireCurrentHistoryState();
	}


}
