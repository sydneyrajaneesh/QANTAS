//This class handles the initialization components and all the common attributes used throughout the test execution

package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class Base {
//All the common reusable components are defined here
	protected static Properties confprop;
	public String baseURL;
	public String newEndpoint;
	public String httpProxyName;
	public String httpsProxyName;
	public String httpPort;
	public String httpsPort;
	RequestSpecification APIRequest;

	
	
	public Base() {
		Properties confprop = new Properties();

		// Mapping of components with the variable that are used in implementation
		try {
			confprop.load(new FileInputStream(new File("./src/test/resources/config.properties")));
			baseURL = confprop.getProperty("URL");
			newEndpoint = confprop.getProperty("testPath");
			httpProxyName = confprop.getProperty("httpProxy");
			httpsProxyName = confprop.getProperty("httpsProxy");
			httpPort = confprop.getProperty("httpPort");
			httpsPort = confprop.getProperty("httpsPort");

			if (httpProxyName != "") {
				System.setProperty("http.proxyHost", httpProxyName);
				System.setProperty("http.proxyPort", httpPort);
				System.setProperty("https.proxyHost", httpsProxyName);
				System.setProperty("https.proxyPort", httpsPort);
			}

			RestAssured.baseURI = baseURL;
			this.APIRequest = RestAssured.given();
			APIRequest.header("Content-Type", "application/json");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}





