/*****
 * 
 * --This class has all the web Elements details to interact with Google Drive
 * --Along with the web element initialization there has been defined function for specific actions 
 * 
 */
package GoogleDriverPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.BaseClass.BrowserInit;

public class GoogleDriveFile extends BrowserInit {

	WebDriverWait wait = new WebDriverWait(driver, 3000);
	@FindBy(xpath = "//input[@type=\"email\"]")
	WebElement EmailId;

	@FindBy(xpath = "//div[@class=\"VfPpkd-RLmnJb\"]")
	WebElement Submit;

	@FindBy(xpath = "//input[@type=\"password\"]")
	WebElement password;
	@FindBy(xpath = "//div[@id=\"passwordNext\"]")
	WebElement SignIn;

	@FindBy(xpath = "//div[@aria-label=\"PRANESH_SINHA_resume_updated.pdf\"]")
	WebElement FileName;
	@FindBy(xpath = "//div[@aria-label=\"Preview\"]")
	WebElement preview;

	@FindBy(xpath = "//div[@aria-label=\"Download\"]")
	WebElement download;

	@FindBy(xpath = "//div//iframe[@role=\\\"presentation\\\" ]")
	WebElement iframe;

	@FindBy(xpath = "//button[text()=\"Dismiss\"]")
	WebElement dismiss;

	// GoogleDriveFile is used here for initializing the elements
	public GoogleDriveFile()

	{
		PageFactory.initElements(driver, this);
	}

	// googleDriveLogin logins into the google drive with user name and password
	public void googleDriveLogin(String username, String pass) {
		EmailId.sendKeys(username);
		Submit.click();
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys(pass);
		SignIn.click();
	}

	// preview finds the file and show user preview

	public void preview() {
		wait.until(ExpectedConditions.visibilityOf(dismiss));
		driver.switchTo().frame(iframe);
		dismiss.click();
		driver.switchTo().parentFrame();
		wait.until(ExpectedConditions.visibilityOf(FileName));
		try {

			FileName.click();
			preview.click();
		} catch (Exception NoSuchElementException) {
			System.out.println("Incorrect file Name selected");
		}

	}

	// downloadFile downloads the required file
	public void downloadFile() {

		wait.until(ExpectedConditions.visibilityOf(download));
		download.click();
	}
}
