import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class GeoLocationOverrride {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\frkyz\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		Map<String,Object> locations = new HashMap();
		locations.put("latitude", 40);
		locations.put("longitude", 3);
		locations.put("accuracy", 1);
	
		
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", locations);
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("wikipedia",Keys.ENTER);
		driver.findElements(By.xpath("//div/a/h3[@class='LC20lb MBeuO DKV0Md']")).get(0).click();
		String title = driver.findElement(By.className("mw-headline")).getText();	
		System.out.println(title);
		

	}

}
