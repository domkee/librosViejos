package com.fer.t1.client;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootPanel;

public class PageStarter {

	private static String mainPanelID;
	
	private static Map<String,View<?>> viewMap = new HashMap<String, View<?>>();
	private static Map<Class<? extends HistoryManager>,String> urlMap = new HashMap<Class<? extends HistoryManager>, String>();
	
	public static void start(String mainPanelID)
	{
		PageStarter.mainPanelID = mainPanelID;
	}
	
	public static <T extends View<?>> void  drawPage(String url)
	{
		View<?> v = viewMap.get(url);
		RootPanel.get(mainPanelID).clear();
		RootPanel.get(mainPanelID).add(v);
		v.eventHandler.onPageSet();
	}
	
	/**
	 * 
	 * @param <HistoryManage> the 
	 * @param <Presentr>
	 * @param <Viewn>
	 * @param hM
	 * @param pres
	 * @param v
	 * @param pageURL
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	@SuppressWarnings("unchecked")
	public static <T extends EventHandler> void startPage(HistoryManager hManager, 
			Presenter<T> presenter, View<T> view, String url  )
	{
		try {
			hManager.init(url, view, (T)presenter);
			presenter.init(view,url);
			viewMap.put(url, view);
			urlMap.put(hManager.getClass(), url);
			view.setEventHandler((T) presenter);
		} catch (Exception e) {
			System.err.println("Make sure your Presenter implements the Views EventHandler interface");
			e.printStackTrace();
		}
		History.addValueChangeHandler(hManager);
		
	}

	public static String getURL(Class<? extends HistoryManager> historyManager) {
		return urlMap.get(historyManager);
	}
	
	
}
