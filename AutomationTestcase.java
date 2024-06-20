package automationpractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AutomationTestcase {
	static WebDriver driver;
	static String browser="chrome";

	//https://automationexercise.com/test_cases
	static String url="https://automationexercise.com/";

	//import extendreports dependency in pom.xml file

	public static ExtentSparkReporter ospark;
	public static ExtentReports oreport;
	public static ExtentTest otest;
	public static String  sreport="./reports/automationpractice.html";



	public static void reportsetter() {
		ospark = new ExtentSparkReporter(sreport);
		oreport = new ExtentReports();
		oreport.attachReporter(ospark);

	}

	public static void testcase1() {
		otest=oreport.createTest("Invoke browser and do the testcase1");
		otest.assignAuthor("praising");
		otest.assignCategory("smoke testing");

		driver=new ChromeDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebElement homepage,login,newuser,oname,oemail,osignupbtn,account_info;


		homepage=driver.findElement(By.xpath("//a[@style=\"color: orange;\"]"));
		boolean displayed = homepage.isDisplayed();
		//if else validation
		if (displayed==true) {
			System.out.println("Home page is displayed");

		} else {
			System.out.println("Home page is  not displayed");

		}

		login=driver.findElement(By.xpath(" //a[@href=\"/login\"]"));
		login.click();

		newuser=driver.findElement(By.xpath("//h2[text()=\"New User Signup!\"]"));
		boolean displayed2 = newuser.isDisplayed();

		if(displayed2==true) {
			System.out.println("new user option is displayed");
		}else {
			System.out.println("not visible");
		}

		oname=driver.findElement(By.xpath("//input[@name=\"name\"]"));
		oname.sendKeys("praising");
		oemail=driver.findElement(By.xpath("(//input[@name=\"email\"])[2]"));
		oemail.sendKeys("praisigm1@gmail.com");
		osignupbtn=driver.findElement(By.xpath("//button[text()=\"Signup\"]"));
		osignupbtn.click();

		System.out.println("signup is succesful");

		//Verify that 'ENTER ACCOUNT INFORMATION' is visible
		account_info=driver.findElement(By.xpath("//b[text()=\"Enter Account Information\"]"));
		boolean accountinfo = account_info.isDisplayed();
		if (accountinfo==true) {
			System.out.println("'ENTER ACCOUNT INFORMATION' is visible");

		}else {
			System.out.println("'ENTER ACCOUNT INFORMATION' is NOT visible");
		}

		WebElement title,password,days,months,years;
		title=driver.findElement(By.id("id_gender1"));
		title.click();
		password=driver.findElement(By.id("password"));
		password.sendKeys("praise123");

		days=driver.findElement(By.id("days"));
		Select oselect=new Select(days);
		oselect.selectByValue("11");

		months=driver.findElement(By.id("months"));
		Select o1select=new Select(months);
		o1select.selectByVisibleText("November");

		years=driver.findElement(By.id("years"));
		Select o2select=new Select(years);
		o2select.selectByIndex(22);
		//driver.manage().window().minimize();

		WebElement firstname,lastname,company,address,address2,country,state,city,zipcode,mobnum,submit;

		firstname=driver.findElement(By.id("first_name"));

		lastname=driver.findElement(By.id("last_name"));

		company=driver.findElement(By.id("company"));
		address2=driver.findElement(By.id("address1"));

		address=driver.findElement(By.id("address2"));

		country=driver.findElement(By.id("country"));
		Select select3=new Select(country);
		select3.selectByVisibleText("India");
		state=driver.findElement(By.id("state"));

		city=driver.findElement(By.id("city"));

		zipcode=driver.findElement(By.id("zipcode"));

		mobnum=driver.findElement(By.id("mobile_number"));
		
		submit=driver.findElement(By.xpath("//button[text()=\"Create Account\"]"));
		


		firstname.sendKeys("praise");
		lastname.sendKeys("praising");
		company.sendKeys("praison tech");
		address2.sendKeys("panaikulam");
		address.sendKeys("peikulam");
		state.sendKeys("Tamilnadu");
		city.sendKeys("Tuti");
		zipcode.sendKeys("628613");
		mobnum.sendKeys("9458681234");
		submit.click();

	}
	
	public static void testcase2() {
		driver=new ChromeDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath(" //a[@href=\"/login\"]")).click();
		
		
		WebElement email,password,login;
		email=driver.findElement(By.name("email"));
		email.sendKeys("praisingm1@gmail.com");
		password=driver.findElement(By.name("password"));
		password.sendKeys("praise123");
		
		login=driver.findElement(By.xpath("//button[text()=\"Login\"]"));
		login.click();
		
		WebElement verify = driver.findElement(By.xpath("//b[text()=\"praising\"]"));
		String loginame = verify.getText();
		System.out.println("loged in name is:"+loginame);
		String name1="praising";
		SoftAssert assert1=new SoftAssert();
		assert1.assertEquals(loginame, name1);
		assert1.assertAll();
		
		WebElement deleteacc,confirmation;
		deleteacc=driver.findElement(By.xpath("//a[text()=\" Delete Account\"]"));
		deleteacc.click();
		confirmation=driver.findElement(By.xpath("//h2[@class=\"title text-center\"]/b"));
		String accdele = confirmation.getText();
		if (accdele=="ACCOUNT DELETED!") {
			System.out.println("Account deleted successfully");
			
		} else {
			System.out.println("Account is not deleted there is some problem");

		}
		
	
	}
	public static void closebrowser() {
		//whenever we use extendreport it should be ended with .flush
		oreport.flush();
		driver.quit();
	}
	public static void main(String[] args) {
		reportsetter();
		testcase2();
		//testcase1();
		//closebrowser();
	}

}
