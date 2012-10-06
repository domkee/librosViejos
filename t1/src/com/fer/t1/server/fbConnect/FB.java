package com.fer.t1.server.fbConnect;

public class FB {

	public static String appId = "";
	public static String appSecret = "";
	public static String redirect_uri = "";
	public static String root = "";
	
	public static String generateString()
	{
		return "5U78H6Y7";
	}

	public static boolean checkState(String state) {
		if (state.equals("5U78H6Y7"))
		{
			return true;
		}
		return false;
	};
	
	public static void init(String appId,String appSectret,String redirect_uri,String root)
	{
		FB.appId = appId;
		FB.appSecret = appSectret;
		FB.redirect_uri = redirect_uri;
		FB.root = root;
	}
}
