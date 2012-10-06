package com.fer.t1.client.widgets.fb;


public class FBComment extends FBWidget{

	private String url;
	private int numPosts;
	private int pixelWidth;
	
	public FBComment(String url, int numPosts, int pixelWidth) {
		
		super("<fb:comments href=\""+url+"\" num_posts=\""+numPosts+"\" " +
				"width=\""+pixelWidth+"\"></fb:comments>");
		setStyleName("fbComment");
		
		this.url = url;
		this.numPosts = numPosts;
		this.pixelWidth = pixelWidth;
	}
	
	public void update(String newUrl)
	{
		url = newUrl;
		setHTML("<fb:comments href=\""+url+"\" num_posts=\""+numPosts+"\" " +
				"width=\""+pixelWidth+"\"></fb:comments>");
		parseFBXML();
	}
	
}
