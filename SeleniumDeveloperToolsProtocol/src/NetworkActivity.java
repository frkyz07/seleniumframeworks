import java.util.Optional;

import org.asynchttpclient.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v103.network.Network;
import org.openqa.selenium.devtools.v103.network.model.Request;

public class NetworkActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\frkyz\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(), Optional.empty(),Optional.empty()));
		
		devTools.addListener(Network.requestWillBeSent(), request->
		{
			Request req = request.getRequest();
		//	System.out.println(req.getUrl());
		});
		
		devTools.addListener(Network.responseReceived(), response ->
		{
			org.openqa.selenium.devtools.v103.network.model.Response res =  response.getResponse();
			//System.out.println(res.getUri());
		//	System.out.println(res.getStatusCode());
			String statuscode = Integer.toString(res.getStatus());
			if(statuscode.startsWith("4")) {
				System.out.println(res.getUrl()+"is failing with status code");
			}
		});
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		
		
	}

}
