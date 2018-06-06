/*The implementation for the test cases are handled in this class. 
This communicates with the response object to verify the status code and validate the JSON output.
Datatable is used to handle the input dynamically*/


package servicelayer;

import org.junit.Assert;
import core.APIPostRequest;
import core.IResponse;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import domain.RequestObject;

public class LoginService {

	APIPostRequest postrequest;
	IResponse responseObject;
	IResponse ResponseSuccess;

	@Given("^Login URL And valid user name And password$")
	public void Login_URL_valid_user_name_And_password() {
		this.postrequest = new APIPostRequest();
	}

	@When("^a user calls the Login URL using post method$")
	public void user_calls_Login_URL_using_post_method(DataTable credentials) {
		RequestObject reqObject = new RequestObject();
		reqObject.setRequestObject(credentials);
		this.responseObject = this.postrequest.submit(reqObject);
	}

	@Then("^status code is (\\d+) and validate the response message$")
	public void validate_status_code(int StatusCode) {
		Assert.assertEquals(this.responseObject.getStatusCode(), StatusCode);
	}

}
