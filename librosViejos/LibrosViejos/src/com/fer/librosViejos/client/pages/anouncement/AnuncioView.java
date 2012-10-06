package com.fer.librosViejos.client.pages.anouncement;

import com.fer.t1.client.View;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.FlowPanel;
import com.fer.librosViejos.client.widget.NavBar;

public class AnuncioView extends View<AnuncioHandler> implements ClickHandler {
	
	public AnuncioView() {
		
		FlowPanel flowPanel = new FlowPanel();
		initWidget(flowPanel);
		
		NavBar navBar = new NavBar();
		flowPanel.add(navBar);
		
		Label lblHolaBernie = new Label("hola bernie");
		lblHolaBernie.addClickHandler(this);
		flowPanel.add(lblHolaBernie);
	}

	@Override
	public void onClick(ClickEvent event) {
		eventHandler.onBernieClick();
	}

}
