package ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RediffHomepage {

	WebDriver driver;

	public RediffHomepage(WebDriver driver) {
		this.driver = driver;
	}

	By search = By.xpath("//div//input[@id='srchword']");
	By submit = By.xpath("//div//input[@aria-label='Search']");
	
	public WebElement Search() {
		return driver.findElement(search);
	}
	public WebElement Submit() {
		return driver.findElement(submit);
	}
}
