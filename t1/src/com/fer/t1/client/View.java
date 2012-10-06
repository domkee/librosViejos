package com.fer.t1.client;

import com.google.gwt.user.client.ui.Composite;

public class View<T extends EventHandler> extends Composite {

	protected T eventHandler;
	
	public void setEventHandler(T handler)
	{
		this.eventHandler = handler;
	}
	
	public void setPage()
	{
		
	}
	
	public void onError(String message)
	{
		System.out.println("Error!"+message);
	}
	
}
