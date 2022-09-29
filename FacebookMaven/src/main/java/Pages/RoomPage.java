package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoomPage {
	
	@FindBy (xpath = "//a[text()=' Return to messenger.com ']") private WebElement returnToMessage;
	
	@FindBy (xpath = "//a[text()=' Visit our help center ']")private WebElement helpCenter;
	
	public RoomPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void goBackToMEssanger()
	{
		returnToMessage.click();
	}
	
	public void contactToHelpCenter()
	{
		helpCenter.click();
	}

}
