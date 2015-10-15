package org.shiftedapps.helloworld.bll;

import javax.inject.Singleton;

import org.shiftedapps.helloworld.bll.repositories.MessageRepository;
import org.shiftedapps.helloworld.bll.serialization.JsonSerializerImpl;
import org.shiftedapps.helloworld.messages.MessageActions;

import dagger.Module;
import dagger.Provides;

@Module
public class TestModule {

	@Provides IJsonSerializer provideJsonSerializer(){
		return new JsonSerializerImpl();
	}
	
	@Provides IRestClient provideRestClient(){
		return new RestClientTest();
	}
	
	@Provides MessageRepository provideMessageRepository(IJsonSerializer jsonSerializer, IRestClient restClient){
		return new MessageRepository(jsonSerializer, restClient);
	}
	
	@Provides @Singleton MessageActions provideMessageActions(MessageRepository msgRepo){
		return new MessageActions(msgRepo);
	}
	
	@Provides @Singleton Dispatcher provideDispatcher(MessageActions messageActions){
		return new Dispatcher(messageActions);
	}
}
