package Usingpagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginobjects {

	@FindBy(id="username")
	public static WebElement username;
	
	@FindBy(id="password")
	public static WebElement password;
	
	@FindBy(id="submit")
	public static WebElement submit;
}
