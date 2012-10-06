package com.fer.t1.client.widgets;

import com.fer.t1.client.HistoryManager;
import com.fer.t1.client.PageStarter;
import com.google.gwt.user.client.ui.HTML;

public class Link extends HTML {
	
	public Link(Class<? extends HistoryManager> historyManager, String html) {
		super(getString(historyManager, html,""));
	}
	
	public Link(Class<? extends HistoryManager> historyManager, String html, String queryString) {
		super(getString(historyManager, html,queryString));
	}
	
	private static String getString(Class<? extends HistoryManager> historyManager, String html, String queryString)
	{
		return "<a href=\"#"+PageStarter.getURL(historyManager)+queryString+"\" > "+html+ "</a> ";
	}
	
}
