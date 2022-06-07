package ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffLoginPagePF {

	WebDriver driver;

	public void RediffLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*By username = By.xpath("//div//input[@id='login1']");
	By password = By.xpath("//div//input[@name='passwd']");
	By signin = By.xpath("//div//input[@type='submit']");
	By home = By.xpath("//div//a[text()='rediff.com']");*/
	
	@FindBy(xpath="//div//input[@id='login1']")
	WebElement username;
	
	@FindBy(xpath="//div//input[@name='passwd']")
	WebElement password;
	
	@FindBy(xpath="//div//input[@type='submit']")
	WebElement signin;
	
	@FindBy(xpath="//div//a[text()='rediff.com']")
	WebElement home;
	
	
	

	public WebElement EmailId() {
		return username;
	}

	public WebElement Password() {
		return password;
	}

	public WebElement Signin() {
		return signin;
	}

	public WebElement Home() {
		return home;
	}
}
