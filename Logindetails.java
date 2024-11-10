package Usingpagefactory;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import io.opentelemetry.api.logs.Logger;

public class Logindetails {
     @Test
	public static void login() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
		
		Thread.sleep(2000);
		
		//we initate driver to whole loginobject class.
		PageFactory.initElements(driver,Loginobjects.class);
		
		
		Loginobjects.username.sendKeys("student");
		Loginobjects.password.sendKeys("Password123");
		Loginobjects.submit.click();
				
		
		
		
	}
	
}
