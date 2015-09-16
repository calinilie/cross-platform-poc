package org.shiftedapps.helloworld.bll;

public interface IRestClient {

	public void get(String url, IResponseHandler responseHandler);
	
}
