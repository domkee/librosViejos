package com.fer.t1.client.azync;

/**
 * 
 * @author fer
 * Convenience interface for handling events
 * @param <T>
 */
public interface CallFinishHandler<T> {

	public void onFinish(T params);
}
