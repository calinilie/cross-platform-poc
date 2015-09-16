package org.shiftedapps.helloworld.messages;

import org.shiftedapps.helloworld.bll.models.Message;

public interface IMessageReceivedListener {

	public void onMessageReceived(Message m);
	
}
