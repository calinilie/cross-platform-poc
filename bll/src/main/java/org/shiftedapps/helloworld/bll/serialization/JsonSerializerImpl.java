package org.shiftedapps.helloworld.bll.serialization;

import org.shiftedapps.helloworld.bll.IJsonSerializer;

import com.google.gson.Gson;

public class JsonSerializerImpl implements IJsonSerializer {

	public <T> T fromJson(String json, Class<T> type) {
		return new Gson().fromJson(json, type);
	}

	public String toJson(Object object) {
		return new Gson().toJson(object);
	}

}
