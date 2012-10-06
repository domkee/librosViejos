package com.fer.librosViejos.client.pages.home.anuncio;

import com.fer.librosViejos.client.widget.NavBar;
import com.fer.t1.client.View;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.DoubleBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.FlexTable;

public class CrearAnuncioView extends View<CrearAnuncioHandler> implements ClickHandler{
	
	private Label lblEnviar;
	private DoubleBox txtPrecio;
	private TextArea txtDescripcion;
	private TextBox txtNombre;
	
	public CrearAnuncioView() {
		
		FlowPanel flowPanel = new FlowPanel();
		initWidget(flowPanel);
		
		NavBar navBar = new NavBar();
		flowPanel.add(navBar);
		
		FlexTable flexTable = new FlexTable();
		flowPanel.add(flexTable);
		
		Label lblquieresVenderUn = new Label("\u00BFQuieres Vender un Libro?");
		flexTable.setWidget(0, 0, lblquieresVenderUn);
		flexTable.getCellFormatter().setWidth(0, 0, "33%");
		lblquieresVenderUn.setStyleName("titleSearch");
		
		FlowPanel flowPanel_1 = new FlowPanel();
		flexTable.setWidget(0, 1, flowPanel_1);
		flexTable.getCellFormatter().setWidth(0, 1, "33%");
		flowPanel_1.setSize("100%", "100%");
		
		Label lblDescr = new Label("Crea anuncios para vender tus libros usados");
		flexTable.setWidget(1, 0, lblDescr);
		lblDescr.setStyleName("paddingBottom");
		
		Label lblNombreDelLibro = new Label("Nombre del Libro");
		flexTable.setWidget(2, 0, lblNombreDelLibro);
		
		txtNombre = new TextBox();
		flexTable.setWidget(2, 1, txtNombre);
		flexTable.getCellFormatter().setWidth(2, 1, "33%");
		txtNombre.setStyleName("textBox");
		
		Label lblDescripcin = new Label("Descripci\u00F3n");
		flexTable.setWidget(3, 0, lblDescripcin);
		
		txtDescripcion = new TextArea();
		flexTable.setWidget(3, 1, txtDescripcion);
		txtDescripcion.setStyleName("textBox");
		
		Label lblDescribeEnPocas = new Label("Describe en pocas palabras el estado del libro");
		lblDescribeEnPocas.setStyleName("italic");
		flexTable.setWidget(4, 0, lblDescribeEnPocas);
		flexTable.getFlexCellFormatter().setRowSpan(3, 1, 2);
		
		Label lblPrecio = new Label("Precio");
		flexTable.setWidget(5, 0, lblPrecio);
		
		txtPrecio = new DoubleBox();
		flexTable.setWidget(5, 1, txtPrecio);
		txtPrecio.setStyleName("textBox");
		
		lblEnviar = new Label("Enviar");
		flexTable.setWidget(6, 0, lblEnviar);
		lblEnviar.setStyleName("btnSearch");
		flexTable.getFlexCellFormatter().setColSpan(6, 0, 2);
		flexTable.getFlexCellFormatter().setRowSpan(0, 1, 7);
		flexTable.getFlexCellFormatter().setColSpan(0, 0, 2);
		lblEnviar.addClickHandler(this);
		FlexTableHelper.fixRowSpan(flexTable);
	}

	@Override
	public void onClick(ClickEvent event) {
		Object source = event.getSource();
		if (source.equals(lblEnviar))
		{
			String nombre = txtNombre.getValue();
			String descripcion = txtDescripcion.getValue();
			double precio = txtPrecio.getValue();
			eventHandler.onCreateAnuncio(nombre,descripcion,precio);
		}
	}

	public void notifyBookCration() {
		Window.alert("Anuncio creado");
	}

	
	
}
