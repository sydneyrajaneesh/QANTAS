package domain;

import core.IRequest;
import cucumber.api.DataTable;

public class RequestObject implements IRequest {

	DataTable requestObject = null;

	public DataTable getRequestObject() {
		return requestObject;
	};

	public void setRequestObject(DataTable regObj) {
		this.requestObject = regObj;
	};

}




