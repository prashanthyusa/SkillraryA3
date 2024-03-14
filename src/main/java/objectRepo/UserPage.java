package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage {

	//Declaration
		@FindBy(xpath = "//h1[normalize-space(text())='Users']")
		private WebElement pageHeader;
		
		@FindBy(xpath = "//a[text()=' New']")
		private WebElement newButton;
		
		@FindBy(xpath = "//div[contains(@class,'alert-success')]")
		private WebElement successAlert;
		
		//Initialization
		public  UserPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//Utilization
		public String getPageHeader() {
			return pageHeader.getText();
		}
		public void clickNewButton() {
			newButton.click();
		}
		public String getSuccessAlertMesssage() {
			return successAlert.getText();
		}

	}

