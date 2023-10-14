package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Page_Objects {
	
	@FindBy(xpath = "//input[@name='username']")
	public static WebElement userName;
	
	@FindBy(xpath = "//input[@type='password']")
	public static WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement submitButton;

}
