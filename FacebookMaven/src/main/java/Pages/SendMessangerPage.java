package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendMessangerPage {
	
		
		@FindBy (xpath = "(//div[@aria-label='Messenger'])[1]") private WebElement messanger;
		
		@FindBy (xpath = "//span[text()='Shital Godase']") private WebElement sendMsgToShital;
		
		@FindBy (xpath = "//div[@aria-label='Message']")private WebElement sendTypeMsg;
		
		@FindBy (xpath = "//div[@aria-label='Press Enter to send']")private WebElement send;
		
		
		public SendMessangerPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		public void clickMessanger()
		{
			messanger.click();
		}
		public void sendMsg()
		{
			sendMsgToShital.click();
		}
		public void sendTypeMsg()
		{
			sendTypeMsg.sendKeys("How Are You");
		}
		public void send()
		{
			send.click();
		}  

}

