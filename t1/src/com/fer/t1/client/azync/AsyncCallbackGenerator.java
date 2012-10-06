package com.fer.t1.client.azync;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class AsyncCallbackGenerator{
	
	/**
	 * @param <T> the CallFinishHandler's type
	 * @param handler a CallFinishHandler
	 * @return Returns an AsyncCallback based on a CallFinishHandler 
	 */
	public static <T> AsyncCallback<T> getAsyncCallback(final CallFinishHandler<T> handler)
	{
		return new AsyncCallback<T>() {
			@Override
			public void onFailure(Throwable caught) 
			{
				caught.printStackTrace();
			}
			public void onSuccess(T result)
			{
				handler.onFinish(result);	
			};
		};
	}

}
