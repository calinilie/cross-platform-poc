package org.shiftedapps.helloworld.bll;

public interface IJsonSerializer {

	public <T> T fromJson(String json, Class<T> type);
	
	public String toJson(Object object);
	
}
