package core;

import cucumber.api.DataTable;

public interface IRequest {

	DataTable getRequestObject();

	void setRequestObject(DataTable regObj);
}


