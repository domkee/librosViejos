package com.fer.t1.server.fbConnect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class RedirectUriServlet{



	/**
	 * 
	 */
	private static final long serialVersionUID = -3027095645724664716L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String errorReason = req.getParameter("error_reason");
		String state = req.getParameter("state");

		
		if (errorReason == null && state != null && FB.checkState(state))
		{
			
			String code = req.getParameter("code");
		
			System.out.println("Code: "+code);
			URL url = new URL("https://graph.facebook.com/oauth/access_token?"+
				"client_id="+FB.appId+
				"&redirect_uri="+FB.redirect_uri+
				"&client_secret="+FB.appSecret+
				"&code="+code);
			InputStream is = url.openConnection().getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			String line = br.readLine();
			String accessToken = line.split("&")[0].split("=")[1];
			
			onAccessToken(accessToken, resp);
			
		}
		else
		{

		}
		
		
		
	}
	/**
	 * This method is executed after the access token has been retrieved so you can start accessing the FB API
	 * @param token
	 * @throws IOException 
	 */
	public abstract void onAccessToken(String token,HttpServletResponse resp) throws IOException;
}
