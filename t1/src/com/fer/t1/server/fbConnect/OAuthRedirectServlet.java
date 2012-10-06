package com.fer.t1.server.fbConnect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class OAuthRedirectServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5398579750460245114L;
	public final static String chromeExtension = "chromeExtension";
	
	public final static String PERM_EMAIL = "email";
	public final static String PERM_BIRTH = "user_birthday";

	public void doGet(HttpServletRequest req, HttpServletResponse resp, String permisionList)
		throws ServletException, IOException {

		if (req.getParameter("uid")!=null)
		{
			doDebugLogin(req,resp, req.getParameter("uid"));
		}
		else
		{
			resp.sendRedirect("https://www.facebook.com/dialog/oauth?"+

					"client_id="+FB.appId+
					"&redirect_uri="+FB.redirect_uri+
					"&scope="+permisionList+
					"&state="+FB.generateString());
		}
	}
		
	
	/**
	 * In case you are debugging or testing your fbApp in localhost send a request with a param uid=XXX
	 * and this code will be executed instead
	 * @param req
	 * @param resp
	 * @param uid
	 */
	public abstract void doDebugLogin(HttpServletRequest req, HttpServletResponse resp, String uid);
	
	
}
