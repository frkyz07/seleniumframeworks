import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class jdbconnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String host = "localhost";
		String port = "4040";
		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/demo", "root", "Faruk.1313");
		
		Statement s = con.createStatement();
		ResultSet result = s.executeQuery("select * from credentials where scenario='shoppingcard'");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\frkyz\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com");
		
		while(result.next())
		{
			
			driver.findElement(By.id("username")).sendKeys(result.getString("username"));
			driver.findElement(By.id("password")).sendKeys(result.getString("password"));
			driver.findElement(By.id("Login")).click();
		}
	}

}
