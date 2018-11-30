
package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class App {

  private static final String URL = "https://www.google.com";
  //private static final String URL ="https://www.cimbclicks.com.my/clicks/#/";
  // private static final String URL = "https://httpbin.org/user-agent";    // Connecting to Site with a Trusted Certificate
  // private static final String URL = "https://self-signed.badssl.com";    // Connecting to Site with an Untrusted Certificate
  
  public static void main(String[] args) throws IOException {
	URLConnection conn = connect(URL);

	if (conn != null) {
      try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
	    String input;

	    while ((input = br.readLine()) != null) {
	      System.out.println(input);
	    } 
	  }
    }
  }

  public static URLConnection connect(String url) {
    URLConnection conn = null;
    
	try {
	  conn = new URL(url).openConnection();
	} catch (MalformedURLException e) {
      e.printStackTrace();
	} catch (IOException e) {
	  e.printStackTrace();
	}

	return conn;
  }
}