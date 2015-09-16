package org.shiftedapps.helloworld.bll;

import org.junit.Assert;
import org.junit.Test;
import org.shiftedapps.helloworld.bll.models.MessageList;
import org.shiftedapps.helloworld.messages.IMessageListReceivedListener;
import org.shiftedapps.helloworld.messages.MessageActions;

import dagger.ObjectGraph;

public class MessagesIntegrationTest {
	
	@Test
	public void getMesssagesSize() throws InterruptedException{
		ObjectGraph objectGraph = ObjectGraph.create(new TestModule());
		MessageActions actions = objectGraph.get(MessageActions.class);
		Dispatcher dispatcher = objectGraph.get(Dispatcher.class);
		dispatcher.registerMessageListReceivedListener(new IMessageListReceivedListener() {
			
			public void onMessagesReceived(MessageList messageList) {
				System.out.println(">>>>>>>>>>>>>>>>>>>" + messageList.getMessages().size());
				Assert.assertEquals(4, messageList.getMessages().size());	
			}
		});
		
		actions.GetAllMessages();
		
		Thread.sleep(1500);
		
		//Assert.assertSame(4, underTest.getAllMessages().getMessages().size());
		//Assert.assertSame(1l, underTest.getAllMessages().getMessages().get(0).getId());

	}
}
