package org.shiftedapps.helloworld.bll;

import javax.inject.Singleton;

import org.shiftedapps.helloworld.messages.MessageActions;

import dagger.Component;

@Singleton @Component(modules = TestModule.class)
public interface TestDiComponent {

	Dispatcher dispatcher();
	
	MessageActions messageActions();
	
}
