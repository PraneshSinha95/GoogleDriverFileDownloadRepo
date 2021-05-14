/*********
 * ---BrowserInit class is defined basically to initialize the Web-Driver
 *
 */

package com.BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserInit {
	public static WebDriver driver;
	public static Properties prop;

	public BrowserInit() {

		try {
			prop = new Properties();
			FileInputStream reader = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/credentials.properties");
			prop.load(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		String url = "https://drive.google.com/drive/u/1/my-drive";
		driver.get(url);

	}

}
