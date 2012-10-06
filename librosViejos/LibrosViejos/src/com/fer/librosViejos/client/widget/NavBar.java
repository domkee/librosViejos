package com.fer.librosViejos.client.widget;

import com.fer.t1.client.widgets.fb.FBInviteDialog;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class NavBar extends Composite implements ClickHandler, ValueChangeHandler<String> {
	

	String searchURL = "search";//PageStarter.getURL(SearchHistoryManager.class);
	TextBox txtSearch;
	Image lblNewLabel;
	Label lblInvitarAmigos;
	
	public NavBar() {
	
		String homeURL = "home";//PageStarter.getURL(HomeHistory.class);
		String createAnuncioURL = "crearAnuncio";//PageStarter.getURL(CrearAnuncioHistory.class);
		
		FlowPanel flowPanel = new FlowPanel();
		initWidget(flowPanel);
		setStyleName("navBar");
		
		NavbarLink hprlnkHome = new NavbarLink("Home",homeURL,true);
		hprlnkHome.setStyleName("navBarLinkLeft");
		flowPanel.add(hprlnkHome);
		
		NavbarLink hprlnkCrearAnuncio = new NavbarLink("Crear Anuncio",  createAnuncioURL,true);
		hprlnkCrearAnuncio.setStyleName("navBarLinkLeft");
		flowPanel.add(hprlnkCrearAnuncio);
		
		txtSearch = new TextBox();
		txtSearch.addValueChangeHandler(this);
		txtSearch.setStyleName("txtSearch");
		flowPanel.add(txtSearch);
		
		lblNewLabel = new Image("images/lupa.png");
		lblNewLabel.addClickHandler(this);
		lblNewLabel.setStyleName("navBarSearch");
		flowPanel.add(lblNewLabel);
		
		lblInvitarAmigos = new Label("Invitar Amigos");
		lblInvitarAmigos.addClickHandler(this);
		lblInvitarAmigos.setStyleName("navBarLinkRight");
		flowPanel.add(lblInvitarAmigos);
	}

	private void onSearch()
	{
		String query = txtSearch.getValue();
		if (query.length() > 1)
		{
			History.newItem(searchURL+"/q="+query);
		}
	}
	
	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		onSearch();
	}

	@Override
	public void onClick(ClickEvent event) {
		
		Object source = event.getSource();
		if (source.equals(lblNewLabel))
		{
			onSearch();
		}
		else if(source.equals(lblInvitarAmigos))
		{
			FBInviteDialog.openDialog("Invita a tus amigos a vender sus libros usados");
		}
	}

	
	
}
