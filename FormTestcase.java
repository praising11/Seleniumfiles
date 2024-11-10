package Pageobjectmodel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FormTestcase {
	@Test
	public void form() throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/automation-practice-form");
		Thread.sleep(3000);
		
		Formobjects.firstname(driver).sendKeys("vino");
		Formobjects.lastname(driver).sendKeys("sri");
		Formobjects.gender(driver).click();
		Formobjects.number(driver).sendKeys("6252416");
		//Formobjects.dob(driver).clear();Formobjects.dob(driver).sendKeys("");
		Formobjects.subject(driver).sendKeys("Thoothukudi");
		Formobjects.hobbies(driver).click();
		Formobjects.pictures(driver).sendKeys("\"C:\\Users\\acer\\Pictures\\Screenshots\\Screenshot (8).png\"");
		Formobjects.current(driver).sendKeys("sdcv");
		Formobjects.state(driver).get(0).click();
		Formobjects.city(driver).get(1).click();
		
	}
  
}
