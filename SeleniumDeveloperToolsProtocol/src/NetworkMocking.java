import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v103.fetch.Fetch;

public class NetworkMocking {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\frkyz\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		
		devTools.send(Fetch.enable(Optional.empty(),Optional.empty()));
		devTools.addListener(Fetch.requestPaused(), request->
		
		{
			if(request.getRequest().getUrl().contains("shetty"))
			{
				String newUrl = request.getRequest().getUrl().replace("=shetty","=BadGuy");
				System.out.println(newUrl);
				
				HashMap<String,Object> m = new HashMap();
				m.put("url", newUrl);
				m.put("method", request.getRequest().getMethod());
				m.put("request", request.getRequestId());
				m.put("postData",request.getRequest().getPostData());
				m.put("headers", request.getRequest().getHeaders());
				//m.put("interceptResponse", request.getRequest().)
				
				driver.executeCdpCommand("Fetch.continueRequest", m);
				
			}
			else {
				HashMap<String,Object> m = new HashMap();
				m.put("url", request.getRequest().getUrl());
				m.put("method", request.getRequest().getMethod());
				m.put("request", request.getRequestId());
				m.put("postData",request.getRequest().getPostData());
				m.put("headers", request.getRequest().getHeaders());
				driver.executeCdpCommand("Fetch.continueRequest", m);
			}
		});
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.cssSelector("p")).getText());


	}

}
