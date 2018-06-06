package pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import core.FunctionalWrappers;

public class JoinFF extends FunctionalWrappers {

	public JoinFF(RemoteWebDriver driver) {
		this.driver = driver;
		if (!verifyTitle("Frequent Flyer - Welcome")) {
			System.out.println("This is not Frequent Flyer - Welcome page");
		}
	}

	public JoinFF xxx(String cname) {
		enterById(" ", cname);
		return this;
	}

	public JoinFF yyy(String fname) {
		enterById(" ", fname);
		return this;
	}

	public JoinFF xxx1(String lname) {
		enterById(" ", lname);
		return this;
	}

}
