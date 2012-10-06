package com.fer.t1.client;

/**
 * 
 * @author fer
 * Every single Presenter must implement the view's EventHandler
 */
public interface EventHandler {

	/**
	 * This Event is called after the page is drawn, i.e. 
	 * after <code>PageStarter.drawPage(View<?> view)</code>
	 */
	public void onPageSet();
	
}
