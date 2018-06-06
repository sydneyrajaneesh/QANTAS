package services;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import core.FunctionalWrappers;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.JoinFF;

public class Registration_FFlyer extends FunctionalWrappers {

	public String browserName;
	public JavascriptExecutor js;

	@Before(order = 1)
	public void beforeTest() {
		loadObjects();
	}

	@Before(order = 2)
	public void set_data() {
		browserName = "chrome";
	}

	@Before(order = 3)
	public void beforeMethod() {

		invokeApp(browserName);
		js = (JavascriptExecutor) driver;
	}

	@Given("^Qantas frequent flyer registration url$")
	public void qantas_frequent_flyer_registration_url() {
		new JoinFF(driver);
	}

	@When("^the form is ready for entering details$")
	public void the_form_is_ready_for_entering_details() {

		if (driver.findElements(By.xpath(Title)).size() != 0) {
			System.out.println("Form ready");
		} else {

			System.out.println("form not ready");
		}
	}

	@Then("^user enters the personal details$")
	public void user_enters_the_personal_details(DataTable personal) {
		js.executeScript("window.scrollBy(0,500)");
		selectIndexById(Title, "1");

		for (Map<String, String> data : personal.asMaps(String.class, String.class)) {
			enterByXpath(FirstName, data.get("First_Name"));
			enterByXpath(LastName, data.get("Last_Name"));
			enterByXpath(MobileNumber, data.get("Mobile_Number"));
		}

	}

	@Then("^user enters the address details$")
	public void user_enters_the_address_details(DataTable address) {

		for (Map<String, String> data : address.asMaps(String.class, String.class)) {
			enterByXpath(AddressLine1, data.get("Address_Line1"));
			enterByXpath(AddressLine2, data.get("Address_Line2"));
			enterByXpath(Suburb, data.get("Suburb"));
			selectIndexById(State, data.get("State"));
			enterByXpath(PostalCode, data.get("PostalCode"));

		}
	}

	@Then("^user enters the email and consent$")
	public void user_enters_the_email_and_consent(DataTable emails) {
		for (Map<String, String> data : emails.asMaps(String.class, String.class)) {
			enterByXpath(Email, data.get("Email"));
			enterByXpath(Email_Confirmation, data.get("Email_Confirmation"));
		}

	}

	@Then("^the user enters the security information$")
	public void the_user_enters_the_security_information(DataTable security) {
		for (Map<String, String> data : security.asMaps(String.class, String.class)) {
			selectIndexById(Date, data.get("Date"));
			selectIndexById(Month, data.get("Month"));
			selectIndexById(Year, data.get("Year"));
			enterByXpath(Mothers_Maiden_name, data.get("Mothers_Maiden_name"));
			enterByXpath(create_pin, data.get("create_pin"));
			enterByXpath(confirm_pin, data.get("confirm_pin"));
		}

	}

	@Then("^the user accepts the terms and conditions$")
	public void the_user_accepts_the_terms_and_conditions() {
		js.executeScript("window.scrollBy(0,1000)");
		System.out.println("Intentionally not clicking to avoid any submission");

	}

	@After(order = 0)
	public void afterTest() {
		unloadObjects();
	}

	@After(order = 1)
	public void afterMethod() {
		quitBrowser();

	}

}
