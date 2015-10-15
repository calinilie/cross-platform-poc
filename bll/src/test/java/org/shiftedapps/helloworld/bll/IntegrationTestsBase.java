package org.shiftedapps.helloworld.bll;


public abstract class IntegrationTestsBase {

	private boolean asyncCallReady;
	private int waitingFor;
	private int maxWaitingTime = 2000;
	
	protected Dispatcher dispatcher;
	protected TestDiComponent comp;
	
	protected void setup(){
		asyncCallReady = false;
		waitingFor = 0;
		
		/*objectGraph = ObjectGraph.create(new TestModule());
		dispatcher = objectGraph.get(Dispatcher.class);*/
		
		comp = DaggerTestDiComponent.create();
		dispatcher = comp.dispatcher();
	}
	
	protected void done() {
		asyncCallReady = true;
	}

	protected void waitForTest() throws InterruptedException {

		while (!asyncCallReady) {
			Thread.sleep(10);
			waitingFor += 10;
			if (waitingFor > maxWaitingTime)
				throw new RuntimeException(String.format("test execution took longer than %s ms", maxWaitingTime));
		}
	}
}
