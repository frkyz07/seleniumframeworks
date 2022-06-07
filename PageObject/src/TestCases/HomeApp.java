package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import ObjectRepo.RediffHomepage;

public class HomeApp {

	@Test
	public void search() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\frkyz\\OneDrive\\Belgeler\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rediff.com/");
		RediffHomepage rh = new RediffHomepage(driver);
		rh.Search().sendKeys("reddiff");
		rh.Submit().click();

	}

}
