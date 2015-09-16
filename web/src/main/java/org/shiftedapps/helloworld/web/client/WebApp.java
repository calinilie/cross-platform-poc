package org.shiftedapps.helloworld.web.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.shiftedapps.helloworld.bll.repositories.MessageRepository;
import org.shiftedapps.helloworld.web.models.JsonSerializer;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

public class WebApp implements EntryPoint {

  public void onModuleLoad() {
	  MessageStore store = new MessageStore();
	  store.exportGetData();
	  
	  //MessageRepository repo = new MessageRepository(new JsonSerializer());
	  //GWT.log(repo.getMessage().getAuthor() + "");
	  
	  Logger logger = Logger.getLogger(WebApp.class.getName());
	  logger.log(Level.SEVERE, "this message should get logged");  
	
  }
}
