package com.fer.t1.client.azync;

import com.google.gwt.user.client.rpc.AsyncCallback;

public abstract class DefaultErrorHandler<T> implements AsyncCallback<T> {


	public DefaultErrorHandler() {}

	
	@Override
	public void onFailure(Throwable caught) {
		caught.printStackTrace();
	}
	
}
