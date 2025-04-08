package anujaK.SeleniumCodes;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;

public class BrokenImage {
	static WebDriver driver;
	@BeforeMethod
	public void checkIfBrokenImage() {
		driver.get("https://the-internet.herokuapp.com/broken_images");
		driver.manage().window().maximize();
		List<WebElement> listOFAllImages = driver.findElements(By.tagName("img"));
		int totalImages = listOFAllImages.size();
		for(WebElement e : listOFAllImages) {
			String imgAttribute = e.getAttribute("src");
			if(imgAttribute==null ||imgAttribute.isEmpty() ) {
				System.out.println(imgAttribute + "is a missing image");
			} else {
				try {
					URL url = new URL(imgAttribute);
					HttpURLConnection connection = (HttpURLConnection) url.openConnection();
					if(connection.getResponseCode()!=200) {
						System.out.println(imgAttribute+" : is a broken image with responseCode" +connection.getResponseCode() );
					} else {
						System.out.println(imgAttribute+" : is a valid image");

					}
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		driver.quit();
		
	}
}
