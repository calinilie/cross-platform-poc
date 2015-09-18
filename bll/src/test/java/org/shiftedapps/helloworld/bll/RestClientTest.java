package org.shiftedapps.helloworld.bll;

public class RestClientTest implements IRestClient {

	public void get(String url, final IResponseHandler responseHandler) {
		Runnable task = new Runnable() {

			public void run() {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				responseHandler.onSuccess(messageListJson);
			}
		};

		new Thread(task).start();
	}

	private final String messageListJson = "{\"messages\": [{\"receivedTimestamp\":\"Sunday, July 27, 2014 4:11 PM\",\"message\":\"Pariatur aliqua incididunt irure non velit qui irure. Consequat sit commodo ea id esse nulla cupidatat culpa ad sint dolor eu tempor mollit. Ullamco duis irure aliquip eu. Voluptate proident commodo exercitation in. Fugiat Lorem nulla sit sunt consequat.\",\"author\":\"Annie Carpenter\",\"id\":\"1\"},{\"receivedTimestamp\":\"Wednesday, June 25, 2014 8:57 AM\",\"message\":\"Pariatur nisi consequat adipisicing do quis proident nulla cillum laboris anim magna ullamco aute nostrud. Dolor qui irure cupidatat ex pariatur esse ut. Consequat consectetur aliqua sint Lorem qui ut ex id ea labore est cupidatat elit occaecat. Qui anim aute veniam Lorem nulla fugiat dolor dolor excepteur. Elit id Lorem occaecat voluptate et consequat deserunt.\",\"author\":\"Debra Witt\",\"id\":\"2\"},{\"receivedTimestamp\":\"Thursday, August 6, 2015 6:16 PM\",\"message\":\"Aliqua nisi magna qui culpa et anim tempor laboris culpa ex ipsum ea culpa. Ipsum tempor laboris aute eiusmod nulla cillum. Pariatur minim eiusmod voluptate laboris esse nisi non adipisicing deserunt officia. Velit ea nisi qui ea est deserunt magna adipisicing occaecat adipisicing ex tempor esse. Ea proident irure nulla duis irure veniam. Sunt deserunt irure exercitation culpa elit Lorem exercitation aliqua voluptate laborum.\",\"author\":\"Beverly Scott\",\"id\":\"3\"},{\"receivedTimestamp\":\"Saturday, May 23, 2015 2:23 PM\",\"message\":\"Sit quis aute do ullamco. Minim enim labore pariatur enim dolor deserunt. Ea cillum est exercitation ullamco. Labore nostrud et eiusmod aute laboris. Ut tempor culpa esse labore velit deserunt elit irure. Eu sunt culpa tempor consequat eu non et dolor fugiat dolore ex deserunt.\",\"author\":\"Shelley Meadows\",\"id\":\"4\"}]}";
}
