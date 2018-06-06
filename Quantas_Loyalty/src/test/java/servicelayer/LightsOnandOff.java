package servicelayer;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import core.APIPostRequest;
import core.Base;
import core.IResponse;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LightsOnandOff {
	
	
	
	private WebDriver driver;
	 public String userID;
	APIPostRequest postrequest;
	RequestSpecification request;
	IResponse responseObject;

	
	public String baseURL = "https://qa-challenges-lightbulb.atlassian.io/api/allmethods";
	

	
	@Given("^an lightbulb challenge url$")
	public void lightbulb_challenge_url() throws InterruptedException
	{
		String exePath = "./resources/driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://qa-challenges-lightbulb.atlassian.io/");
		String newURL=driver.getCurrentUrl();
		//System.out.println(newURL);
		String[] arrSplit = newURL.split("userId=");
		userID = arrSplit[1];
	}
	
	@When("^a user calls the switch on post method(.*)$")
	public void switch_off_post_method(String user) throws InterruptedException
	{
		
		RestAssured.baseURI = baseURL;
		 request = RestAssured.given();
	//	JSONObject requestParams = new JSONObject();
		request.header("Content-Type", "application/json");
		request.header("userId", userID);
		Response response = request.post("/On");
		

	}
	
	
	@Then("^the lightbulb should throw light rays$")
	public void lightbulb_throws_lightrays() throws InterruptedException
	{
		Response response = request.post("/On");
		Thread.sleep(5000);	
	}
	
	@Then("^a user calls the switch off post method(.*)$")
	public void switch_on_post_method(String user)
	{
		Response response = request.post("/off");
	}
	

}
