package Amazon;

import java.time.Duration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Basicsofamazon {
    private static WebDriver driver;
    private static String url="https://www.amazon.in/";
    private static String browser="chrome";


private static void invokebrowser() {
	// ChromeOptions options=new ChromeOptions();
	// options.addArguments("--disable-notification");
	switch (browser) {
	case "chrome":
		System.out.println("user option is:"+browser);
		driver=new ChromeDriver();
		
		break;
	case "firefox":
		System.out.println("user option is:"+browser);
		driver= new FirefoxDriver();
		

	default:
		System.out.println("user option is:"+browser);
		driver=new EdgeDriver();
		break;
	}
}
private static void pageinfo() {
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get(url);
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
}
private static void webinfo() {
	String  title=driver.getTitle();
	System.out.println(driver.getCurrentUrl());
	System.out.println(driver.getWindowHandle());
	System.out.println(driver.getTitle());
	String Actualtitle = driver.getTitle();
	String Expectedtitle="https://www.amazon.in/";
	//Assert.assertEquals(Actualtitle, Expectedtitle);
	SoftAssert softassert=new SoftAssert();
	softassert.assertEquals(Actualtitle, title);
	softassert.assertAll();
	
	
	
}

static void homepage() {
	List<WebElement> findElements = driver.findElements(By.tagName("a"));
    
	
	System.out.println("links in the amazon home page is:"+ findElements.size());
	
}
static void signin() {
	WebElement sigin,oin;
	sigin=driver.findElement(By.id("nav-link-accountList"));
	Actions act=new Actions(driver);
	act.moveToElement(sigin).perform();
	oin=driver.findElement(By.xpath("(//span[text()='Sign in'])[1]"));
	oin.click();
	
	
	//sigin.click();
	
}

static void giftidea() {
	WebElement gift,otext;
	gift=driver.findElement(By.xpath("//a[normalize-space()='Gift Ideas']"));
	gift.click();
	otext=driver.findElement(By.xpath("//h1[text()='Find the perfect gift']"));
	
	String text1 = otext.getText();
	if (text1.length()>=10) {
		System.out.println("hello text is above 10");
		
	}else {
		System.out.println("below 10");
	}


	
	
}
public static void main(String[] args) {
invokebrowser();
pageinfo();
webinfo();
homepage();
giftidea();
//signin();
}

	

}
