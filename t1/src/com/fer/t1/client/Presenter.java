package com.fer.t1.client;

import com.google.gwt.user.client.History;

public class Presenter<T extends EventHandler>{

	protected View<T> view;
	protected String url;
	
	public void init(View<T> view, String url)
	{
		this.url = url;
		this.view = view;
	}
	
	/**
	 * 
	 * @param params
	 */
	public void silentHistoryEvent(ValuePair... params )
	{
		String queryString = HistoryManager.Constants.QUERY;
		for (int i = 0; i < params.length; i++) {
			ValuePair vp = params[i];
			queryString += vp.name + HistoryManager.Constants.PARAM_EQUAL + vp.value;
			if (i+1 < params.length)
			{
				queryString += HistoryManager.Constants.PARAM_AND;
			}
		}
		History.newItem(url+queryString, false);
	}
	

}
