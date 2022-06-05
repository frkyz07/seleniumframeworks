package rahulshattyacademy.mavenproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class ExtentReportDemo {
	
	ExtentReports extent;
	ExtentSparkReporter reporter;
	
	@Test
	public void initialDemo()
	{
		ExtentTest test = extent.createTest("initialDemo");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\frkyz\\OneDrive\\Belgeler\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		driver.close();
		extent.flush();
	}
	
	@BeforeTest
	public void config()
	{
		// ExtenReports, ExtentSparkReporter
		String path = System.getProperty("user.dir")+"//reports//index.html";
		reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Faruk Ayaz");
				
	}

	

}
