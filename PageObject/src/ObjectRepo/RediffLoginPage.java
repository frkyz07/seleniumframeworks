package ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RediffLoginPage {

	WebDriver driver;

	public RediffLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By username = By.xpath("//div//input[@id='login1']");
	By password = By.xpath("//div//input[@name='passwd']");
	By signin = By.xpath("//div//input[@type='submit']");
	By home = By.xpath("//div//a[text()='rediff.com']");

	public WebElement EmailId() {
		return driver.findElement(username);
	}

	public WebElement Password() {
		return driver.findElement(password);
	}

	public WebElement Signin() {
		return driver.findElement(signin);
	}

	public WebElement Home() {
		return driver.findElement(home);
	}

}
