package anujaK.SeleniumCodes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReadFile {

	public static void main(String[] args) {
		String url;
		String browser;
		String path;

		String filePath = "C:\\Users\\Coditas-Admin\\Documents\\Nov24\\IDE\\Nov24SELENIUM\\src\\anujaK\\SeleniumCodes\\config.properties";
		Properties prop = new Properties();
		File file = new File(filePath);
		try {
			FileInputStream inputStream = new FileInputStream(file);
			prop.load(inputStream);
			url = prop.getProperty("url");
			browser = prop.getProperty("browser");
			System.out.println(url + "-----" + browser);
			// System.out.println(prop.getClass());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
