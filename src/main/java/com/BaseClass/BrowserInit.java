/*********
 * ---BrowserInit class is defined basically to initialize the Web-Driver
 *
 */

package com.BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.codec.binary.Base64;
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
	
	public static String decodeStringUname(String username)
	{
		byte[] decodeString=Base64.decodeBase64(username);
		return (new String(decodeString));
	}
	
	public static String decodeStringPwd(String password)
	{
		byte[] decodeString=Base64.decodeBase64(password);
		return (new String(decodeString));
	}


}
