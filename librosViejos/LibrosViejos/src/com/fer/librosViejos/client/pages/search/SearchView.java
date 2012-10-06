package com.fer.librosViejos.client.pages.search;

import java.util.Collection;

import com.fer.librosViejos.client.model.Anuncio;
import com.fer.librosViejos.client.pages.search.widget.SearchResult;
import com.fer.librosViejos.client.widget.NavBar;
import com.fer.t1.client.View;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;

public class SearchView extends View<SearchHandler> {
	
	private FlowPanel panelSearchResults;
	
	public SearchView() {
		
		FlowPanel flowPanel = new FlowPanel();
		initWidget(flowPanel);
		
		NavBar navBar = new NavBar();
		flowPanel.add(navBar);
		
		FlowPanel flowPanel_1 = new FlowPanel();
		flowPanel.add(flowPanel_1);
		
		Label lblNewLabel = new Label("Buscar Libros");
		lblNewLabel.setStyleName("titleSearch");
		flowPanel_1.add(lblNewLabel);
		
		Label lblDescr = new Label("Busca libros por nombre autor o descripccion");
		lblDescr.setStyleName("paddingBottom");
		flowPanel_1.add(lblDescr);
		
		panelSearchResults = new FlowPanel();
		flowPanel.add(panelSearchResults);
	}


	public void displaySearchResults(Collection<Anuncio> result) {
		panelSearchResults.clear();
		for (Anuncio book : result) {
			panelSearchResults.add(new SearchResult(book));
		}
	}


}
