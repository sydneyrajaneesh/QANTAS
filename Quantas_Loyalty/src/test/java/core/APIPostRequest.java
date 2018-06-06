/*This is one of the most important class of the core layer that handles the request and responses.
This is the space for input and out put validation of services*/

package core;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import org.json.simple.JSONObject;
import domain.ResponseFailure;
import domain.ResponseSuccess;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class APIPostRequest extends Base {
	public IResponse submit(IRequest request) {
		JSONObject requestParams = new JSONObject();
//Here we are handling the Json body to be provided as input dynamically
		List<Map<String, String>> userInput = request.getRequestObject().asMaps(String.class, String.class);

		for (Map<String, String> row : userInput) {
			for (Entry<String, String> entry : row.entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue();
				requestParams.put(key.toString(), value);
			}
		}

// Here we are storing the reponse and hence validating on the JSON responses
		APIRequest.body(requestParams.toJSONString());
		Response api_response = APIRequest.post();
		int statuscode = api_response.getStatusCode();
		JsonPath jsonpath = new JsonPath(api_response.body().asString());
		System.out.println(jsonpath);
		if (statuscode == 200) {
			// populate the success response object

			ResponseSuccess responseSuccess = new ResponseSuccess();
			responseSuccess.username = (Objects.isNull(jsonpath.get("username")) == true ? ""
					: jsonpath.get("username").toString());
			responseSuccess.password = (Objects.isNull(jsonpath.get("password")) == true ? ""
					: jsonpath.get("password").toString());
			responseSuccess.Message = (Objects.isNull(jsonpath.get("Message")) == true ? ""
					: jsonpath.get("Message").toString());
			responseSuccess.SuccessCode = (Objects.isNull(jsonpath.get("SuccessCode")) == true ? ""
					: jsonpath.get("SuccessCode").toString());
			responseSuccess.setStatusCode(statuscode);
			return responseSuccess;

		} else if(statuscode==201) {

						ResponseSuccess responseSuccess = new ResponseSuccess();
						responseSuccess.username = (Objects.isNull(jsonpath.get("username")) == true ? ""
								: jsonpath.get("username").toString());
						responseSuccess.password = (Objects.isNull(jsonpath.get("password")) == true ? ""
								: jsonpath.get("password").toString());
						responseSuccess.Message = (Objects.isNull(jsonpath.get("Message")) == true ? ""
								: jsonpath.get("Message").toString());
						responseSuccess.SuccessCode = (Objects.isNull(jsonpath.get("SuccessCode")) == true ? ""
								: jsonpath.get("SuccessCode").toString());
						responseSuccess.setStatusCode(statuscode);
						return responseSuccess;
			
		}
		else
		{
			

			ResponseFailure responseFailure = new ResponseFailure();
			responseFailure.Code = (Objects.isNull(jsonpath.get("Code")) == true ? ""
					: jsonpath.get("Code").toString());
			responseFailure.Code = (Objects.isNull(jsonpath.get("Message")) == true ? ""
					: jsonpath.get("Message").toString());
			responseFailure.Code = (Objects.isNull(jsonpath.get("FaultID")) == true ? ""
					: jsonpath.get("FaultID").toString());
			responseFailure.Code = (Objects.isNull(jsonpath.get("fault")) == true ? ""
					: jsonpath.get("fault").toString());
			responseFailure.setStatusCode(statuscode);
			return responseFailure;
		}

	}

}
