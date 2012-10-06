package com.fer.t1.client;

import java.util.List;

import com.google.gwt.user.client.History;

public class PageManager {

	private static List<HistoryManager> managers;
	
	public static void goTo(String url, String... params )
	{
		
		boolean urlExists = false;
		for (HistoryManager temp : managers) {
			if (temp.url.equals(url))
			{
				urlExists = true;
				History.newItem(url);
			}
		}
		if (!urlExists)
		{
			throw new IllegalArgumentException("The URL "+url+" does not exist. Please verify URL sintax or" +
					" register the new URL");
		}
	}
	
}
