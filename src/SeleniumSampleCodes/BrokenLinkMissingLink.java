package anujaK.SeleniumCodes;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinkMissingLink {

	static WebDriver driver;
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/Coditas-Admin/Documents/Nov24/IDE/missingLInk.html");
	}
	@Test
	public void checkIfMissingOrBrokenLink() {
		List<WebElement> listOfLinks = driver.findElements(By.tagName("a"));
		for(WebElement e :listOfLinks) {
			String urlLink = e.getAttribute("href");
			if(urlLink==null || urlLink.isEmpty()) {
				System.out.println(e.getText()+" : is a missing link"+"\n");
			}else {
				try {
					URL url = new URL(urlLink);
					HttpURLConnection connection =  (HttpURLConnection)url.openConnection();
					if(connection.getResponseCode()>=400) {
						System.out.println(e.getText()+" : is a broken link with response code "+ connection.getResponseCode()+"\n");	
					} else {
						System.out.println(e.getText()+" : is a valid link with response code "+ connection.getResponseCode() +"\n");	
					}
				} catch (IOException e1) {
					e1.printStackTrace();
					driver.quit();
				}
			}
		}
		driver.quit();	}
}	
