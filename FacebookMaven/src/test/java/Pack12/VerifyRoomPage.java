package Pack12;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.LoginPage;
import Pages.MessengerPage;
import Pages.RoomPage;

public class VerifyRoomPage {
	
	private WebDriver driver;
	private LoginPage loginPage;
	private MessengerPage messengerPage;
	private RoomPage roomPage;
	private SoftAssert soft;
	
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
	public void createPOMObject()
	{
		loginPage = new LoginPage(driver);
	    messengerPage = new MessengerPage(driver);
    	roomPage = new RoomPage(driver);

	}
	
	@BeforeMethod
	public void openRoomPage()
	{
		System.out.println("Before Method");
    	driver.get("https://www.facebook.com/");
	
    	loginPage.openMessenger();
        messengerPage.openRooms();
        soft = new SoftAssert();
    }
	
	@Test
	public void verifyContactToHelpCenterButton()
	{
		System.out.println("Test");
		roomPage.contactToHelpCenter();
		
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
//		SoftAssert soft = new SoftAssert();
		soft.assertEquals(url, "https://www.messenger.com/help","URL of helpCenterPage");
		soft.assertEquals(title, "Messenger Help Centre","TITLE of helpCenterPage");

		soft.assertAll();
	}  
	
	@Test
	public void verifyReturnToMessengerButton()
	{
		System.out.println("Test 2");
		roomPage.goBackToMEssanger();
		
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();

	//	SoftAssert soft = new SoftAssert();

		soft.assertEquals(url, "https://www.messenger.com/","URL of returnMessanger");
		soft.assertEquals(title, "Messenger","TITLE of returnMessanger");
		soft.assertAll();
	}
	
	@AfterMethod
	public void logoutFromApplication()
	{
		System.out.println("After Method");
		System.out.println("LOGOUT");
	}
	
	@AfterClass
	public void clraeObjects()
	{
		loginPage = null;
	    messengerPage = null;
    	roomPage = null;
	}
	@AfterTest()
	public void closeBrowser()
	{
		System.out.println("After Class");
		driver.close();
		driver=null;
		System.gc();  //garbage collecter
	}
}
