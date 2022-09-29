package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy (xpath = "//input[@ id='email']") private WebElement userName;
	
	@FindBy (xpath = "//input[@ type='password']") private WebElement password;
	
	@FindBy (xpath = "//button[text()='Log in']") private WebElement loginButton;
	
	@FindBy (xpath = "//a[text()='Create New Account']")private WebElement createNewAccount;
	
	@FindBy (xpath = "//a[text()='Messenger']")private WebElement messengerLink;
	
	
	public LoginPage (WebDriver driver123)  //driver123= driver=new ChromeDriver()
	
	{
		PageFactory.initElements(driver123, this);
	}
	
	public void sendUserName()
	{
		userName.sendKeys("supriyajadhav654@gmail.com");
	}
	
	public void sendPassword()
	{
		password.sendKeys("Aruna$17393$$");
	}
	
	public void clickLoginButton()
	{
		loginButton.click();
	}
	
	public void clickOnCreateNewAcc()
	{
		createNewAccount.click();
	}
	public void openMessenger()
	{
		messengerLink.click();
	}
	
	//OR
	
/*	public void loginFacebook()
	{
		userName.sendKeys("supriyajadhav654@gmail.com");
		password.sendKeys("Supee$17393$");
		loginButton.click();          
		
}		  */

}
