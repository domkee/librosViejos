package com.fer.t1.client.widgets.fb;

public class FBInviteDialog {

	
	public static native void openDialog(String inviteMessage)
	/*-{
			$wnd.FB.ui({ method: 'apprequests', 
       		message: ''+inviteMessage});
	
	}-*/;
}
