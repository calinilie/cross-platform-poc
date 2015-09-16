package org.shiftedapps.helloworld.bll.repositories;

import java.util.List;

import javax.inject.Inject;

import org.shiftedapps.helloworld.bll.Dispatcher;
import org.shiftedapps.helloworld.bll.IJsonSerializer;
import org.shiftedapps.helloworld.bll.IResponseHandler;
import org.shiftedapps.helloworld.bll.IRestClient;
import org.shiftedapps.helloworld.bll.models.Message;
import org.shiftedapps.helloworld.bll.models.MessageList;

public class MessageRepository {

	private IJsonSerializer jsonSerializer;
	private IRestClient restClient;

	@Inject
	public MessageRepository(IJsonSerializer jsonSerializer, IRestClient restClient) {
		this.jsonSerializer = jsonSerializer;
		this.restClient = restClient;
	}

	public void getMessage(final long messageId, final Dispatcher dispatcher) {
		restClient.get("", new IResponseHandler() {

			public void onSuccess(String data) {
				MessageList msgList = jsonSerializer.<MessageList> fromJson(data, MessageList.class);
				List<Message> messages = msgList.getMessages();
				for(Message m : messages)
					if (m.getId() == messageId){
						dispatcher.notifyMessageReceived(m);
						return;
					}
				
				dispatcher.notifyMessageNotFound(messageId);

			}

			public void onError(String error) {
				// TODO Auto-generated method stub
			}

			public void onComplete() {
				// TODO Auto-generated method stub
			}
		});
	}

	public void getAllMessages(final Dispatcher dispatcher) {

		restClient.get("", new IResponseHandler() {

			public void onSuccess(String data) {
				MessageList msgList = jsonSerializer.<MessageList> fromJson(data, MessageList.class);
				dispatcher.notifyMessageListReceived(msgList);
			}

			public void onError(String error) {
				// TODO Auto-generated method stub

			}

			public void onComplete() {
				// TODO Auto-generated method stub
			}
		});
	}

	private Message getMessage(long id) {
		return jsonSerializer.<Message> fromJson(message, Message.class);
	}

	private final String message = "{\"receivedTimestamp\":\"Sunday, July 27, 2014 4:11 PM\",\"message\":\"Pariatur aliqua incididunt irure non velit qui irure. Consequat sit commodo ea id esse nulla cupidatat culpa ad sint dolor eu tempor mollit. Ullamco duis irure aliquip eu. Voluptate proident commodo exercitation in. Fugiat Lorem nulla sit sunt consequat.\",\"author\":\"Annie Carpenter\",\"id\":\"1\"}";

	public MessageList getAllMessages1() {
		// TODO Auto-generated method stub
		return null;
	}
}
