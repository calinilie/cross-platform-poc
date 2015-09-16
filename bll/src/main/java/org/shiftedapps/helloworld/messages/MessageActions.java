package org.shiftedapps.helloworld.messages;

import org.shiftedapps.helloworld.bll.Dispatcher;
import org.shiftedapps.helloworld.bll.repositories.MessageRepository;

public class MessageActions {

	private Dispatcher dispatcher;

	public MessageActions(MessageRepository messageRepository){
		this.messageRepository = messageRepository;
	}
	
	public void registerDispatcher(Dispatcher dispatcher) {
		this.dispatcher = dispatcher;
	}

	public MessageRepository messageRepository;

	public void GetAllMessages() {
		messageRepository.getAllMessages(this.dispatcher);
	}

	public void GetMessage(long messageId) {
		messageRepository.getMessage(messageId, this.dispatcher);
	}
}
