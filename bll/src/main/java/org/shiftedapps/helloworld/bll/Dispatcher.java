package org.shiftedapps.helloworld.bll;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.shiftedapps.helloworld.bll.models.Message;
import org.shiftedapps.helloworld.bll.models.MessageList;
import org.shiftedapps.helloworld.messages.IMessageListReceivedListener;
import org.shiftedapps.helloworld.messages.IMessageReceivedListener;
import org.shiftedapps.helloworld.messages.IMessageNotFoundListener;
import org.shiftedapps.helloworld.messages.MessageActions;

public class Dispatcher {

	@Inject
	public Dispatcher(MessageActions messageActions){
		this.messageListReceivedListener = new HashMap<Integer, IMessageListReceivedListener>();
		this.messageReceivedListener = new HashMap<Integer, IMessageReceivedListener>();
		this.messageNotFoundListeners = new HashMap<Integer, IMessageNotFoundListener>();
		
		messageActions.registerDispatcher(this);
	}
	
	private HashMap<Integer, IMessageListReceivedListener> messageListReceivedListener;
	private HashMap<Integer, IMessageReceivedListener> messageReceivedListener;
	private HashMap<Integer, IMessageNotFoundListener> messageNotFoundListeners;
	
	public int registerMessageListReceivedListener(IMessageListReceivedListener listener) {
		this.messageListReceivedListener.put(listener.hashCode(), listener);
		return listener.hashCode();
	}
	
	public void notifyMessageListReceived(MessageList messageList) {
		for (Map.Entry<Integer, IMessageListReceivedListener> entry : this.messageListReceivedListener.entrySet())
			entry.getValue().onMessagesReceived(messageList);
	}
	
	
	public int registerMessageReceivedListener(IMessageReceivedListener messageReceivedListener){
		this.messageReceivedListener.put(messageReceivedListener.hashCode(), messageReceivedListener);
		return messageReceivedListener.hashCode();
	}
	
	public void notifyMessageReceived(Message message){
		for (Map.Entry<Integer, IMessageReceivedListener> messageReceivedListener : this.messageReceivedListener.entrySet()){
			messageReceivedListener.getValue().onMessageReceived(message);
		}
	}
	
	
	public int registerMessageNotFoundListener(IMessageNotFoundListener listener){
		this.messageNotFoundListeners.put(listener.hashCode(), listener);
		return listener.hashCode();
	}
	
	public void notifyMessageNotFound(long messageId){
		for (Map.Entry<Integer, IMessageNotFoundListener> messageNotFoundlistener : this.messageNotFoundListeners.entrySet()){
			messageNotFoundlistener.getValue().onMessageNotFound(messageId);
		}
	}

}
