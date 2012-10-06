package com.fer.t1.client.widgets.fb;

import com.google.gwt.core.client.JavaScriptException;
import com.google.gwt.user.client.ui.HTML;

public class FBWidget extends HTML{

	public FBWidget(String string)
	{
		super(string);
	}
	
	@Override
	protected void onLoad() {
		try {
			parseFBXML();
		} catch (JavaScriptException e) {
			System.err.println("FB Not Loaded Yet, widget will not load!");
		}
	}

	protected native void parseFBXML()
	/*-{
		$wnd.parseFB();
	}-*/;
}
