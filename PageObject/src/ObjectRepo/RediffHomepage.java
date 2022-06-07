package ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RediffHomepage {

	WebDriver driver;

	public RediffHomepage(WebDriver driver) {
		this.driver = driver;
		
	}

	/*By search = By.xpath("//div//input[@id='srchword']");
	By submit = By.xpath("//div//input[@aria-label='Search']");*/
	
	@FindBy(xpath="//div//input[@id='srchword']")
	WebElement search;
	
	@FindBy(xpath="//div//input[@aria-label='Search']")
	WebElement submit;
	
	
	public WebElement Search() {
		return search;
	}
	public WebElement Submit() {
		return submit;
	}
}
