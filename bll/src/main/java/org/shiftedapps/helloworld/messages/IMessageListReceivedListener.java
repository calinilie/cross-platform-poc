package org.shiftedapps.helloworld.messages;

import org.shiftedapps.helloworld.bll.models.MessageList;

public interface IMessageListReceivedListener {

	public void onMessagesReceived(MessageList messageList);

}
