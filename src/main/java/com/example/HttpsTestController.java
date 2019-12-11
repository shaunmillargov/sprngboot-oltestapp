package com.example;

import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpsTestController {

	@RequestMapping(value = "/test1", method = RequestMethod.GET, produces = "application/json")
    public String index() {
		
		String httpsURL = "https://httpbin.org/get";
		//String httpsURL = "https://142.34.67.11/EWS/services.wsdl";
		
        URL myUrl;
        
		try {
			
			myUrl = new URL(httpsURL);
	        HttpsURLConnection conn = (HttpsURLConnection)myUrl.openConnection();
	        conn.getInputStream();
	        
	        return Integer.toString(conn.getResponseCode());
			
		} catch (IOException e) {
			//e.printStackTrace();
			return e.getMessage();
		}
    }

}
