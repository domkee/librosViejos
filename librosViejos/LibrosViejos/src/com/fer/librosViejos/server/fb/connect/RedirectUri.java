package com.fer.librosViejos.server.fb.connect;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import com.fer.librosViejos.server.persistence.IPersistenceControl;
import com.fer.librosViejos.server.persistence.test.MockPersistenceControl;
import com.fer.t1.server.fbConnect.FB;
import com.fer.t1.server.fbConnect.RedirectUriServlet;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.User;

public class RedirectUri extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7789612277442438993L;
	
	
	RedirectUriServlet redirect = new RedirectUriServlet() {
		
		@Override
		public void onAccessToken(String token, HttpServletResponse resp)
				throws IOException {
			
			registerUser(token);
			
			resp.sendRedirect(FB.root+"#home/token="+token);
		}


	};
	
	protected void doGet(javax.servlet.http.HttpServletRequest req, HttpServletResponse resp) throws javax.servlet.ServletException ,IOException 
	{
		redirect.doGet(req, resp);
	};
	
	public static void registerUser(String token) {
		FacebookClient facebookClient = new DefaultFacebookClient(token);
		User user = facebookClient.fetchObject("me", User.class);
		String email = user.getEmail();
		Date birth = user.getBirthdayAsDate();
		String name = user.getFirstName();
		String gender = user.getGender();
		String id = user.getId();
		
		com.fer.librosViejos.client.model.User u = 
			new com.fer.librosViejos.client.model.User();
		u = u.init(id, name, email, birth, gender);
		
		IPersistenceControl pc = new MockPersistenceControl();
		pc.createUser(u);
	}

}
