package Pageobjectmodel;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class Formobjects {
	
	
	public static WebElement firstname(WebDriver driver) {
		return driver.findElement(By.id("firstName"));
		}
   public static WebElement lastname(WebDriver driver) {
	   return driver.findElement(By.id("lastName"));
	
   }
   
   public static WebElement gender(WebDriver driver) {
	   
	   return driver.findElement(By.id("gender-radio-1"));
   }
   
   public static WebElement number(WebDriver driver) {
	   return driver.findElement(By.id("userNumber"));
   }
   
   public static WebElement dob(WebDriver driver) {
	   return driver.findElement(By.id("dateOfBirthInput"));
   }
   
   public static WebElement subject(WebDriver driver) {
	   return driver.findElement(By.className("subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3"));
   }
   
   public static WebElement hobbies(WebDriver driver) {
	   return driver.findElement(By.xpath("(//label[@class=\"custom-control-label\"])[1]"));
   }
   
   public static WebElement pictures(WebDriver driver) {
	   return driver.findElement(By.id("uploadPicture"));
   }
   public static WebElement current(WebDriver driver) {
	   return driver.findElement(By.id("currentAddress"));
   }
   public static List<WebElement>  state(WebDriver driver) {
	   return driver.findElements(By.id("state"));
	//return null;
   }
   public static List<WebElement> city(WebDriver driver) {
	 return driver.findElements(By.id("city"));
	//return null;
   }
   public static WebElement submit(WebDriver driver) {
	    return driver.findElement(By.id("submit"));
   }
}
