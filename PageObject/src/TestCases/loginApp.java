package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import ObjectRepo.RediffHomepage;
import ObjectRepo.RediffLoginPage;

public class loginApp {

		@Test
		public void Login() 
		{
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\frkyz\\OneDrive\\Belgeler\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
			RediffLoginPage rd = new RediffLoginPage(driver);
			rd.EmailId().sendKeys("faruk@actimi");
			rd.Password().sendKeys("123123");
			//rd.Signin().click();
			rd.Home().click();
			RediffHomepage rh = new RediffHomepage(driver);
			rh.Search().sendKeys("rediif");
			rh.Submit().click();
		
	}

}
