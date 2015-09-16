package org.shiftedapps.helloworld.bll;

public interface IResponseHandler {

	public void onSuccess(String data);
	
	public void onError(String error);
	
	public void onComplete();
	
}
