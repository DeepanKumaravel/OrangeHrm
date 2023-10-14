package testCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonFunctions.CommonFunctions;
import pageObjects.User_Role_Page_Objects;

public class Test_User_Role extends CommonFunctions{
	
	Logger logger = Logger.getLogger(Test_Pending_Leave_Request.class);
	
	@Test
	public void checkUserRole() {
		
		PageFactory.initElements(driver, User_Role_Page_Objects.class);
		logger.info("Navigating to user page");
		User_Role_Page_Objects.adminlink.click();
		selectUserName();
		clickSubmit();
		
	}
	
	public void selectUserName() {
		
		User_Role_Page_Objects.username.sendKeys(properties.getProperty("username"));
		
	}
	
	public void clickSubmit() {
		
		User_Role_Page_Objects.searchBtn.click();
		
		String actualRole =User_Role_Page_Objects.userRoleValue.getText();
	    String actualStatus = User_Role_Page_Objects.userStatusValue.getText();
	    logger.info("Verifying the results");
	    Assert.assertEquals(actualRole, "Admin");
	    Assert.assertEquals(actualStatus, "Enabled");
	    logger.info("End of Test_User_Role test case");
	  
	    
	
	}

}
