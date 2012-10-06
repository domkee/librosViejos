package com.fer.t1.client.widgets.fb;

public class FBLike extends FBWidget {

	public FBLike(String url) {
		super(getCode(url));
		setStyleName("center500");
	}

	private static String getCode(String url) {
		return "<fb:like href=\""+url+"\" send=\"true\" width=\"500\" show_faces=\"false\" font=\"MyriadPro\"></fb:like> ";
	}

	public void update(String url) {
		setHTML(getCode(url));
	}

	
}
