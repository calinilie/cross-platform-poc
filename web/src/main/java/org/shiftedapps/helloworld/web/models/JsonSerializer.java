package org.shiftedapps.helloworld.web.models;

import org.shiftedapps.helloworld.bll.IJsonSerializer;
import org.shiftedapps.helloworld.bll.models.Message;

import com.google.gwt.core.client.GWT;

public class JsonSerializer implements IJsonSerializer{
	
	@Override
	public String toJson(Object object) {
		return null;
	}

	@Override
	public <T> T fromJson(String json, Class<T> type) {
		if (type == Message.class){
			MessageMapper mapper = GWT.create(MessageMapper.class);
			return (T) mapper.read(json);
		}
		return null;
	}

}
