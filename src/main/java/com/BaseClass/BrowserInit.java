/*********
 * ---BrowserInit class is defined basically to initialize the Web-Driver
 *
 */

package com.BaseClass;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserInit {
	public static WebDriver driver;
	public static Properties prop;

	public BrowserInit() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);

		String url = "https://drive.google.com/drive/u/1/my-drive";
		driver.get(url);

	}

	public static String getEnvID() {
		Map<String, String> env = System.getenv();
		return env.get("G_Driveid");
	}

	public static String getEnvPass() {
		Map<String, String> env = System.getenv();
		return env.get("G_DrivePass");
	}

}
