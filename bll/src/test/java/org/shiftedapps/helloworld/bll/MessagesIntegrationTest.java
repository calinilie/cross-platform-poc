package org.shiftedapps.helloworld.bll;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.shiftedapps.helloworld.bll.models.Message;
import org.shiftedapps.helloworld.bll.models.MessageList;
import org.shiftedapps.helloworld.messages.IMessageListReceivedListener;
import org.shiftedapps.helloworld.messages.IMessageReceivedListener;
import org.shiftedapps.helloworld.messages.MessageActions;

public class MessagesIntegrationTest extends IntegrationTestsBase {

	private MessageActions actions;

	@Before
	public void setup() {
		super.setup();
		actions = objectGraph.get(MessageActions.class);
	}

	@Test
	public void getMesssagesSize() throws InterruptedException {
		super.dispatcher.registerMessageListReceivedListener(new IMessageListReceivedListener() {

			public void onMessagesReceived(MessageList messageList) {
				List<Message> messages = messageList.getMessages();
				for (Message m : messages) {
					Assert.assertTrue(m.getId() != 0);
					Assert.assertTrue(m.getMessage()!= null && !m.getMessage().isEmpty());
				}
				Assert.assertEquals(4, messages.size());
				done();
			}
		});
		actions.GetAllMessages();
		waitForTest();
	}

	@Test
	public void getMessage() throws InterruptedException {
		super.dispatcher.registerMessageReceivedListener(new IMessageReceivedListener() {
			
			public void onMessageReceived(Message m) {
				Assert.assertEquals(1, m.getId());
				Assert.assertTrue(m.getMessage() != null && !m.getMessage().isEmpty());
				Assert.assertTrue(m.getAuthor() != null && !m.getAuthor().isEmpty());
				Assert.assertTrue(m.getReceivedTimestamp() != null && !m.getReceivedTimestamp().isEmpty());
				done();
			}
		});
		actions.GetMessage(1);
		waitForTest();
	}
}
