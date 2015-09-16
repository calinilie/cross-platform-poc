package org.shiftedapps.helloworld.web.client;

import com.google.gwt.core.client.JsArrayString;

public class MessageStore {
	
	public JsArrayString getData(){
		registerCallbacks();
		JsArrayString retVal1 = JsArrayString.createArray().cast();
		retVal1.push("foo");
		retVal1.push("bar");
		retVal1.push("buu");
		return retVal1;
	}
	
	public native void exportGetData() /*-{
		var scope = this;
		$wnd.getMessages = $entry(function(){
			return scope.@org.shiftedapps.helloworld.web.client.MessageStore::getData()();
		})
	}-*/;
	
	public native void registerCallbacks() /*-{
		var a = 1;
		$wnd.increase = $entry(function(){
			return ++a;
		})
	}-*/;
	
}
