package com.fer.t1.client;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;

/**
 * 
 * @author mono
 * The main class for each page. Each page consists of {HistoryManager, Presenter, View}
 */
public abstract class HistoryManager implements ValueChangeHandler<String> {

	public class Constants
	{
		public static final String QUERY = "/";
		public static final String PARAM_AND = "&";
		public static final String PARAM_EQUAL = "=";
		
	}
	
	protected String url;
	protected View<?> view;
	protected EventHandler handler;
	
	public void init(String url, View<?> view, EventHandler handler)
	{
		this.url = url;
		this.view = view;
		this.handler = handler;
	}
	
	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		
		String rawEventString = event.getValue();
		if (rawEventString.startsWith(url+Constants.QUERY))
		{
			String queryPart = rawEventString.split(Constants.QUERY)[1];
			Map<String,String> params = getParamMap(queryPart);
			onHistoryChange(params);
		}
		else if (rawEventString.startsWith(url))
		{
			onHistoryChange();
		}
		
		
	}
	
	private Map<String, String> getParamMap(String queryPart) {
		
		Map<String,String> paramMap = new HashMap<String, String>();
		
		if (queryPart.contains(Constants.PARAM_AND))
		{
			String[] parts = queryPart.split(Constants.PARAM_AND);
			for (String pair : parts) {
				String name = pair.split(Constants.PARAM_EQUAL)[0];
				String value = pair.split(Constants.PARAM_EQUAL)[1];
				paramMap.put(name,value);
			}
		}
		else
		{
			String pair = queryPart;
			String name = pair.split(Constants.PARAM_EQUAL)[0];
			String value = pair.split(Constants.PARAM_EQUAL)[1];
			paramMap.put(name,value);
		}
		
		return paramMap;
	}

	/**
	 * Equivalent to a servlet's <code>doGet</code>  method. This method is called
	 * whenever the history changes and the Ajax URL starts with this <code>HistoryManager</code>'s 
	 * <code> url + Constants.Query</code>
	 * @param params similar to a servlet's <code>params.get(String)</code>
	 */
	public abstract void onHistoryChange(Map<String,String> params);
	/**
	 * Similar to <code>onHistoryChange(Map<String,String> params)</code> but is called 
	 * when there is no <code>Constants.Query</code>
	 */
	public void onHistoryChange()
	{
		draw();
	}; 
	
	public void draw()
	{
		PageStarter.drawPage(url);
	}
}
