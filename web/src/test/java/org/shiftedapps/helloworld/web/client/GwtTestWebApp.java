package org.shiftedapps.helloworld.web.client;

import org.shiftedapps.helloworld.bll.repositories.MessageRepository;
import org.shiftedapps.helloworld.web.models.JsonSerializer;

import com.google.gwt.junit.client.GWTTestCase;

/**
 * GWT JUnit <b>integration</b> tests must extend GWTTestCase.
 * Using <code>"GwtTest*"</code> naming pattern exclude them from running with
 * surefire during the test phase.
 * 
 * If you run the tests using the Maven command line, you will have to 
 * navigate with your browser to a specific url given by Maven. 
 * See http://mojo.codehaus.org/gwt-maven-plugin/user-guide/testing.html 
 * for details.
 */
public class GwtTestWebApp extends GWTTestCase {

  public String getModuleName() {
    return "org.shiftedapps.helloworld.web.WebAppJUnit";
  }

  public void integrationTest() {
	//assertTrue(new MessageRepository(new JsonSerializer()).getMessage().getId() == 1);  
  }
}
