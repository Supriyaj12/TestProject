package Pack12;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.SendMessangerPage;

public class VerifySendMessangerPage {
	
	private WebDriver driver;
	private SendMessangerPage homePage;
	private LoginPage loginPage;
	
	
	@Parameters("browser")
	@BeforeTest
	public void openBrowser(String browserName)
	{
		System.out.println(browserName);
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\chromedriver.exe");
			 driver = new ChromeDriver();
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\Documents\\geckodriver.exe");
			 driver = new FirefoxDriver();
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}
	@BeforeClass
	public void createPOMObjects()
	{
		loginPage = new LoginPage(driver);
	    homePage = new SendMessangerPage(driver);
	}
	
	@BeforeMethod
	public void openMessagePage()
	{
		System.out.println("Before Method");
    	driver.get("https://www.facebook.com/");
    	
       	loginPage.sendUserName();
    	loginPage.sendPassword();
    	loginPage.clickLoginButton();
    	
     	homePage.clickMessanger();
    	homePage.sendMsg();
    	homePage.sendTypeMsg();
    }
 
  
	  @Test
	  public void verifySendButton() {
		//  homePage.sendTypeMsg();
		  homePage.send();
		  
	  }
	  
	  @AfterClass
		public void clraeObjects()
		{
			loginPage = null;
		    homePage = null;
		}
		@AfterTest()
		public void closeBrowser()
		{
			System.out.println("After Class");
			driver.close();
			driver=null;
			System.gc();
		}

}
