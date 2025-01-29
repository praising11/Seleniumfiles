
package Selenium_Grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.beust.jcommander.Parameter;

public class ExtendReport_with_seleniumgrid {
	
	ExtentReports rep=new ExtentReports();
	ExtentSparkReporter reports=new ExtentSparkReporter("target/grid.html");
	
	
	public WebDriver driver;
	public DesiredCapabilities cap=new DesiredCapabilities();
	
	@Parameters({"browser"})
	@BeforeTest
	public void Browser_lanuch(String browser) throws MalformedURLException {
		reports.config().setTheme(Theme.DARK);
		reports.config().setDocumentTitle("Selenium_grid");
		rep.attachReporter(reports);
		
		if (browser.equals("chrome")) {
			
			cap.setPlatform(Platform.ANY);
			cap.setBrowserName("chrome");
			
			ChromeOptions option=new ChromeOptions();
			option.merge(cap);
		}else if(browser.equals("firefox")) {
			cap.setPlatform(Platform.ANY);
			cap.setBrowserName("firefox");
			
			FirefoxOptions option=new FirefoxOptions();
			option.merge(cap);
			
			
		}
			driver=new RemoteWebDriver(new URL("http://192.168.1.5:4444"),cap);
			driver.get("https://www.ebay.com/");
	
	}
	@AfterTest
	public void close() {
		
		rep.flush();
		driver.quit();
	}
	@Test
	public void testcase01() {
		ExtentTest test=rep.createTest("verify the url").assignAuthor("praising")
				.assignCategory("smoke test case").assignDevice("windows");
		test.info("Navigate to  Given url");
		
		String pagetitle=driver.getTitle();
		test.info("capturing page title");
		if (pagetitle.equalsIgnoreCase("Electronics, Cars, Fashion, Collectibles & More | eBay")) {
			test.pass("user navigate to correct page");
			
		} else {
			test.fail("user naviagated to different page");

		}
	}
	
	
}

