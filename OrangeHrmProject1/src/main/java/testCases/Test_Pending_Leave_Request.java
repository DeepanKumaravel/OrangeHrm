package testCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonFunctions.CommonFunctions;
import pageObjects.Dashboard_Page_Objects;
import pageObjects.Login_Page_Objects;

public class Test_Pending_Leave_Request extends CommonFunctions {
	String actualMessage=null;
	static Logger logger = Logger.getLogger(Test_Pending_Leave_Request.class);
	public void login() {
		logger.info("Logging into the application");
    	PageFactory.initElements(driver, Login_Page_Objects.class);
		Login_Page_Objects.userName.sendKeys(properties.getProperty("username"));
		Login_Page_Objects.password.sendKeys(properties.getProperty("password"));
		Login_Page_Objects.submitButton.click();
		
    }
    
    public void getOnLeave() {
    	
    	PageFactory.initElements(driver, Dashboard_Page_Objects.class );
		actualMessage = Dashboard_Page_Objects.pendingLeaveRequest.getText();
    }
    
	@Test
	public void verifyOnLeaveToday() {
		login();
		logger.info("Getting today leave data");
		getOnLeave();
		logger.info("Verification");
	    Assert.assertEquals(actualMessage, "No Employees are on Leave Today" );
	}
}
