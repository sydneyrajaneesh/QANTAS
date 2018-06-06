package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class FunctionalWrappers implements Wrappers {

	public RemoteWebDriver driver;
	protected static Properties confprop;
	protected static Properties objprop;
	public JavascriptExecutor js;

	public String sUrl, primaryWindowHandle, sHubUrl, sHubPort, Title, FirstName, LastName, MobileNumber, AddressLine1,
			AddressLine2, Suburb, State, PostalCode, Email, Email_Confirmation, Date, Month, Year, Mothers_Maiden_name,
			create_pin, confirm_pin, terms;

	public FunctionalWrappers() {
		Properties confprop = new Properties();
		try {
			confprop.load(new FileInputStream(new File("./src/main/java/configs/config.properties")));
			sHubUrl = confprop.getProperty("HUB");
			sHubPort = confprop.getProperty("PORT");
			sUrl = confprop.getProperty("URL");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public FunctionalWrappers(RemoteWebDriver driver) {
		this.driver = driver;
	}

	public FunctionalWrappers(JavascriptExecutor js) {

		this.js = js;

	}

	public void loadObjects() {
		Properties objprop = new Properties();
		try {
			objprop.load(new FileInputStream(new File("./src/main/java/configs/object.properties")));

			Title = objprop.getProperty("Title");
			FirstName = objprop.getProperty("FirstName");
			LastName = objprop.getProperty("LastName");
			MobileNumber = objprop.getProperty("MobileNumber");
			AddressLine1 = objprop.getProperty("AddressLine1");
			AddressLine2 = objprop.getProperty("AddressLine2");
			Suburb = objprop.getProperty("Suburb");
			State = objprop.getProperty("State");
			PostalCode = objprop.getProperty("PostalCode");
			Email = objprop.getProperty("Email");
			Email_Confirmation = objprop.getProperty("Email_Confirmation");
			Date = objprop.getProperty("Date");
			Month = objprop.getProperty("Month");
			Year = objprop.getProperty("Year");
			Mothers_Maiden_name = objprop.getProperty("Mothers_Maiden_name");
			create_pin = objprop.getProperty("create_pin");
			confirm_pin = objprop.getProperty("confirm_pin");
			terms = objprop.getProperty("terms");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void unloadObjects() {
		confprop = null;
		objprop = null;
	}

	/**
	 * This method will launch the browser in local machine and maximise the
	 * browser and set the wait for 30 seconds and load the url
	 * 
	 * @author Rajaneesh Balakrishnan
	 * @param url
	 *            - The url with http or https
	 * 
	 */
	public void invokeApp(String browser) {
		invokeApp(browser, false);
	}

	/**
	 * This method will launch the browser in grid node (if remote) and maximise
	 * the browser and set the wait for 30 seconds and load the url
	 * 
	 * @author Rajaneesh Balakrishnan
	 * @param url
	 *            - The url with http or https
	 * 
	 */
	public void invokeApp(String browser, boolean bRemote) {
		try {

			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setBrowserName(browser);
			dc.setPlatform(Platform.WINDOWS);

			// this is for grid run
			if (bRemote)
				driver = new RemoteWebDriver(new URL("http://" + sHubUrl + ":" + sHubPort + "/wd/hub"), dc);
			else { // this is for local run
				if (browser.equalsIgnoreCase("chrome")) {
					System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
					driver = new ChromeDriver();
				} else {
					System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
					driver = new FirefoxDriver();
				}
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.get(sUrl);

			primaryWindowHandle = driver.getWindowHandle();
			System.out.println("The browser:" + browser + " launched successfully");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("The browser:" + browser + " could not be launched");
		}
	}

	public void passjsexecutor() {
		js = (JavascriptExecutor) driver;

	}

	/**
	 * This method will enter the value to the text field using id attribute to
	 * locate
	 * 
	 * @param idValue
	 *            - id of the webelement
	 * @param data
	 *            - The data to be sent to the webelement
	 * @author Rajaneesh Balakrishnan
	 * @throws IOException
	 * @throws COSVisitorException
	 */
	public void enterById(String idValue, String data) {
		try {
			driver.findElement(By.id(idValue)).clear();
			driver.findElement(By.id(idValue)).sendKeys(data);
			System.out.println("The data: " + data + " entered successfully in field :" + idValue);
		} catch (NoSuchElementException e) {
			System.out.println("The data: " + data + " could not be entered in the field :" + idValue);
		} catch (Exception e) {
			System.out.println("Unknown exception occured while entering " + data + " in the field :" + idValue);
		}
	}

	/**
	 * This method will enter the value to the text field using name attribute
	 * to locate
	 * 
	 * @param nameValue
	 *            - name of the webelement
	 * @param data
	 *            - The data to be sent to the webelement
	 * @author Rajaneesh Balakrishnan
	 * @throws IOException
	 * @throws COSVisitorException
	 */
	public void enterByName(String nameValue, String data) {
		try {
			driver.findElement(By.name(nameValue)).clear();
			driver.findElement(By.name(nameValue)).sendKeys(data);
			System.out.println("The data: " + data + " entered successfully in field :" + nameValue);

		} catch (NoSuchElementException e) {
			System.out.println("The data: " + data + " could not be entered in the field :" + nameValue);
		} catch (Exception e) {
			System.out.println("Unknown exception occured while entering " + data + " in the field :" + nameValue);
		}

	}

	/**
	 * This method will enter the value to the text field using name attribute
	 * to locate
	 * 
	 * @param xpathValue
	 *            - xpathValue of the webelement
	 * @param data
	 *            - The data to be sent to the webelement
	 * @author Rajaneesh Balakrishnan
	 * @throws IOException
	 * @throws COSVisitorException
	 */
	public void enterByXpath(String xpathValue, String data) {
		try {
			driver.findElement(By.xpath(xpathValue)).clear();
			driver.findElement(By.xpath(xpathValue)).sendKeys(data);
			System.out.println("The data: " + data + " entered successfully in field :" + xpathValue);

		} catch (NoSuchElementException e) {
			System.out.println("The data: " + data + " could not be entered in the field :" + xpathValue);
		} catch (Exception e) {
			System.out.println("Unknown exception occured while entering " + data + " in the field :" + xpathValue);
		}

	}

	/**
	 * This method will verify the title of the browser
	 * 
	 * @param title
	 *            - The expected title of the browser
	 * @author Rajaneesh Balakrishnan
	 */
	public boolean verifyTitle(String title) {
		boolean bReturn = false;
		try {
			if (driver.getTitle().equalsIgnoreCase(title)) {
				System.out.println("The title of the page matches with the value :" + title);
				bReturn = true;
			} else
				System.out.println(
						"The title of the page:" + driver.getTitle() + " did not match with the value :" + title);

		} catch (Exception e) {
			System.out.println("Unknown exception occured while verifying the title");
		}
		return bReturn;
	}

	/**
	 * This method will verify the given text matches in the element text
	 * 
	 * @param xpath
	 *            - The locator of the object in xpath
	 * @param text
	 *            - The text to be verified
	 * @author Rajaneesh Balakrishnan
	 */
	public void verifyTextByXpath(String xpath, String text) {
		try {
			String sText = driver.findElementByXPath(xpath).getText();
			if (sText.equalsIgnoreCase(text)) {
				System.out.println("The text: " + sText + " matches with the value :" + text);
			} else {
				System.out.println("The text: " + sText + " did not match with the value :" + text);
			}
		} catch (Exception e) {
			System.out.println("Unknown exception occured while verifying the title");
		}
	}

	/**
	 * This method will verify the given text is available in the element text
	 * 
	 * @param xpath
	 *            - The locator of the object in xpath
	 * @param text
	 *            - The text to be verified
	 * @author Rajaneesh Balakrishnan
	 */
	public void verifyTextContainsByXpath(String xpath, String text) {
		try {
			String sText = driver.findElementByXPath(xpath).getText();
			if (sText.contains(text)) {
				System.out.println("The text: " + sText + " contains the value :" + text);
			} else {
				System.out.println("The text: " + sText + " did not contain the value :" + text);
			}
		} catch (Exception e) {
			System.out.println("Unknown exception occured while verifying the title");
		}
	}

	/**
	 * This method will verify the given text is available in the element text
	 * 
	 * @param id
	 *            - The locator of the object in id
	 * @param text
	 *            - The text to be verified
	 * @author Rajaneesh Balakrishnan
	 */
	public void verifyTextById(String id, String text) {
		try {
			String sText = driver.findElementById(id).getText();
			if (sText.equalsIgnoreCase(text)) {
				System.out.println("The text: " + sText + " matches with the value :" + text);
			} else {
				System.out.println("The text: " + sText + " did not match with the value :" + text);
			}
		} catch (Exception e) {
			System.out.println("Unknown exception occured while verifying the title");
		}
	}

	/**
	 * This method will verify the given text is available in the element text
	 * 
	 * @param id
	 *            - The locator of the object in id
	 * @param text
	 *            - The text to be verified
	 * @author Rajaneesh Balakrishnan
	 */
	public void verifyTextContainsById(String id, String text) {
		try {
			String sText = driver.findElementById(id).getText();
			if (sText.contains(text)) {
				System.out.println("The text: " + sText + " contains the value :" + text);
			} else {
				System.out.println("The text: " + sText + " did not contain the value :" + text);
			}
		} catch (Exception e) {
			System.out.println("Unknown exception occured while verifying the title");
		}
	}

	/**
	 * This method will close all the browsers
	 * 
	 * @author Rajaneesh Balakrishnan
	 */
	public void quitBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println("The browser:" + driver.getCapabilities().getBrowserName() + " could not be closed.");
		}

	}

	/**
	 * This method will click the element using id as locator
	 * 
	 * @param id
	 *            The id (locator) of the element to be clicked
	 * @author Rajaneesh Balakrishnan
	 */
	public void clickById(String id) {
		try {
			driver.findElement(By.id(id)).click();
			System.out.println("The element with id: " + id + " is clicked.");

		} catch (Exception e) {
			System.out.println("The element with id: " + id + " could not be clicked.");
		}
	}

	/**
	 * This method will click the element using id as locator
	 * 
	 * @param id
	 *            The id (locator) of the element to be clicked
	 * @author Rajaneesh Balakrishnan
	 */
	public void clickByClassName(String classVal) {
		try {
			driver.findElement(By.className(classVal)).click();
			System.out.println("The element with class Name: " + classVal + " is clicked.");
		} catch (Exception e) {
			System.out.println("The element with class Name: " + classVal + " could not be clicked.");
		}
	}

	/**
	 * This method will click the element using name as locator
	 * 
	 * @param name
	 *            The name (locator) of the element to be clicked
	 * @author Rajaneesh Balakrishnan
	 */
	public void clickByName(String name) {
		try {
			driver.findElement(By.name(name)).click();
			System.out.println("The element with name: " + name + " is clicked.");
		} catch (Exception e) {
			System.out.println("The element with name: " + name + " could not be clicked.");
		}
	}

	/**
	 * This method will click the element using link name as locator
	 * 
	 * @param name
	 *            The link name (locator) of the element to be clicked
	 * @author Rajaneesh Balakrishnan
	 */
	public void clickByLink(String name) {
		try {
			driver.findElement(By.linkText(name)).click();
			System.out.println("The element with link name: " + name + " is clicked.");
		} catch (Exception e) {
			System.out.println("The element with link name: " + name + " could not be clicked.");
		}
	}

	/**
	 * This method will click the element using xpath as locator
	 * 
	 * @param xpathVal
	 *            The xpath (locator) of the element to be clicked
	 * @author Rajaneesh Balakrishnan
	 */
	public void clickByXpath(String xpathVal) {
		try {
			driver.findElement(By.xpath(xpathVal)).click();
			System.out.println("The element : " + xpathVal + " is clicked.");
		} catch (Exception e) {
			System.out.println("The element with xpath: " + xpathVal + " could not be clicked.");
		}
	}

	/**
	 * This method will mouse over on the element using xpath as locator
	 * 
	 * @param xpathVal
	 *            The xpath (locator) of the element to be moused over
	 * @author Rajaneesh Balakrishnan
	 */
	public void mouseOverByXpath(String xpathVal) {
		try {
			new Actions(driver).moveToElement(driver.findElement(By.xpath(xpathVal))).build().perform();
			System.out.println("The mouse over by xpath : " + xpathVal + " is performed.");
		} catch (Exception e) {
			System.out.println("The mouse over by xpath : " + xpathVal + " could not be performed.");
		}
	}

	/**
	 * This method will mouse over on the element using link name as locator
	 * 
	 * @param xpathVal
	 *            The link name (locator) of the element to be moused over
	 * @author Rajaneesh Balakrishnan
	 */
	public void mouseOverByLinkText(String linkName) {
		try {
			new Actions(driver).moveToElement(driver.findElement(By.linkText(linkName))).build().perform();
			System.out.println("The mouse over by link : " + linkName + " is performed.");
		} catch (Exception e) {
			System.out.println("The mouse over by link : " + linkName + " could not be performed.");
		}
	}

	/**
	 * This method will return the text of the element using xpath as locator
	 * 
	 * @param xpathVal
	 *            The xpath (locator) of the element
	 * @author Rajaneesh Balakrishnan
	 */
	public String getTextByXpath(String xpathVal) {
		String bReturn = "";
		try {
			return driver.findElement(By.xpath(xpathVal)).getText();
		} catch (Exception e) {
			System.out.println("The element with xpath: " + xpathVal + " could not be found.");
		}
		return bReturn;
	}

	/**
	 * This method will return the text of the element using id as locator
	 * 
	 * @param xpathVal
	 *            The id (locator) of the element
	 * @author Rajaneesh Balakrishnan
	 */
	public String getTextById(String idVal) {
		String bReturn = "";
		try {
			return driver.findElementById(idVal).getText();
		} catch (Exception e) {
			System.out.println("The element with id: " + idVal + " could not be found.");
		}
		return bReturn;
	}

	/**
	 * This method will select the drop down value using id as locator
	 * 
	 * @param id
	 *            The id (locator) of the drop down element
	 * @param value
	 *            The value to be selected (visibletext) from the dropdown
	 * @author Rajaneesh Balakrishnan
	 */
	public void selectVisibileTextById(String id, String value) {
		try {
			new Select(driver.findElement(By.id(id))).selectByVisibleText(value);
			;
			System.out.println("The element with id: " + id + " is selected with value :" + value);
		} catch (Exception e) {
			System.out.println("The value: " + value + " could not be selected.");
		}
	}

	/**
	 * This method will select the drop down value using xpath as locator
	 * 
	 * @param xpath
	 *            The xpath (locator) of the drop down element
	 * @param value
	 *            The value to be selected (visibletext) from the dropdown
	 * @author Rajaneesh Balakrishnan
	 */

	public void selectVisibileTextByXPath(String xpath, String value) {
		try {
			new Select(driver.findElement(By.xpath(xpath))).selectByVisibleText(value);
			;
			System.out.println("The element with xpath: " + xpath + " is selected with value :" + value);
		} catch (Exception e) {
			System.out.println("The value: " + value + " could not be selected.");
		}
	}

	/**
	 * This method will select the drop down value using id as locator
	 * 
	 * @param id
	 *            The index id (locator) of the drop down element
	 * @param value
	 *            The value to be selected (visibletext) from the dropdown
	 * @author Rajaneesh Balakrishnan
	 */

	public void selectIndexById(String id, String value) {
		try {
			new Select(driver.findElement(By.xpath(id))).selectByIndex(Integer.parseInt(value));
			;
			System.out.println("The element with id: " + id + " is selected with index :" + value);
		} catch (Exception e) {
			System.out.println("The index: " + value + " could not be selected.");
		}
	}

	public void selectIndexByName(String name, String value) {
		try {
			new Select(driver.findElement(By.xpath(name))).selectByValue(value);
			System.out.println("The element with name: " + name + " is selected with value :" + value);
		} catch (Exception e) {
			System.out.println("The index: " + value + " could not be selected.");
		}
		// TODO Auto-generated method stub

	}

	public void switchToParentWindow() {
		try {
			Set<String> winHandles = driver.getWindowHandles();
			for (String wHandle : winHandles) {
				driver.switchTo().window(wHandle);
				break;
			}
		} catch (Exception e) {
			System.out.println("The window could not be switched to the first window.");
		}
	}

	public void switchToLastWindow() {
		try {
			Set<String> winHandles = driver.getWindowHandles();
			for (String wHandle : winHandles) {
				driver.switchTo().window(wHandle);
			}
		} catch (Exception e) {
			System.out.println("The window could not be switched to the last window.");
		}
	}

	public long takeSnap() {
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE),
					new File("./reports/images/" + number + ".jpg"));
		} catch (WebDriverException e) {
			System.out.println("The browser has been closed.");
		} catch (IOException e) {
			System.out.println("The snapshot could not be taken");
		}
		return number;
	}

}
