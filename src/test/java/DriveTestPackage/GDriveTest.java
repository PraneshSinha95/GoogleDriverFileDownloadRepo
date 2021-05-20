/*
 * --This is the main class through which all functions are getting triggered and tested
 * --running with the help of TESTNG
 * 
 */
package DriveTestPackage;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import com.BaseClass.BrowserInit;
import GoogleDriverPackage.GoogleDriveFile;

public class GDriveTest extends BrowserInit {
	BrowserInit BrowserInit;
	GoogleDriveFile GoogleDriveFile = new GoogleDriveFile();;

	@Test(priority = 1)
	public void testGoogleDriveLogin() {

		try {
			System.out.println(getEnvID());
			System.out.println(getEnvPass());

			GoogleDriveFile.googleDriveLogin(getEnvID(), getEnvPass());
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(driver.getTitle(), "Google Drive: Sign-in");
	}

	@Test(priority = 2)
	public void testPreview() {
		try {
			GoogleDriveFile.preview();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void testDownload() {
		try {
			GoogleDriveFile.downloadFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
