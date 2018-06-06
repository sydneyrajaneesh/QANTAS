package domain;

import core.IResponse;

public class ResponseObject implements IResponse {

	int statusCode = -1;

//Store and return response variables
	public int getStatusCode() {
		return statusCode;
	};

	public void setStatusCode(int statusCd) {
		this.statusCode = statusCd;
	}

}



