package com.fer.librosViejos.client.pages.home;

import com.fer.t1.client.View;
import com.google.gwt.user.client.ui.FlowPanel;
import com.fer.librosViejos.client.widget.NavBar;

public class HomeView extends View<HomeHandler> {
	public HomeView() {
		
		FlowPanel flowPanel = new FlowPanel();
		initWidget(flowPanel);
		
		NavBar navBar = new NavBar();
		flowPanel.add(navBar);
	}

}
