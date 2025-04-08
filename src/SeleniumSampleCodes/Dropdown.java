package anujaK.SeleniumCodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Dropdown {
	static WebDriver driver ;
	
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/Coditas-Admin/Documents/Nov24/IDE/practice.html");
		driver.manage().window().maximize();
	}
	
	@Test
	public void script() {
		WebElement dropDownLoctor = driver.findElement(By.xpath("//select[@id=\"code multi select\"]"));
		Select select =new Select(dropDownLoctor);
		select.selectByIndex(0);
		WebElement selectedValue = select.getFirstSelectedOption();
		String value = selectedValue.getText();
		System.out.println(value);
	}
	
}
