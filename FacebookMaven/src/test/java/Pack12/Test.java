package Pack12;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.SendMessangerPage;
import Pages.LoginPage;
import Pages.MessengerPage;
import Pages.RoomPage;

public class Test {
	
	public static void main(String[] args) throws InterruptedException {
		
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Documents\\chromedriver.exe");
			 
		  WebDriver driver = new ChromeDriver();
		  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.get("https://www.facebook.com/");
		  
		  LoginPage loginPage = new LoginPage(driver);
	//	  loginPage.openMessenger();
		  loginPage.sendUserName();
		  loginPage.sendPassword();
		  loginPage.clickLoginButton();
		 
		  
		  SendMessangerPage homePage = new SendMessangerPage(driver);
		  homePage.clickMessanger();
		  homePage.sendMsg();
		  Thread.sleep(3000);
		  homePage.sendTypeMsg();
		  homePage.send();
		  
//		  MessengerPage messengerPage = new MessengerPage(driver);
//		  messengerPage.openRooms();
//		  Thread.sleep(3000);
		  
//		  RoomPage roomPage = new RoomPage(driver);
//		  roomPage.contactToHelpCenter();
		  
//		  System.out.println(driver.getCurrentUrl());
//		  System.out.println(driver.getTitle());
		  
	//	  roomPage.goBackToMEssanger();
	// 	  System.out.println(driver.getCurrentUrl());
	//	  System.out.println(driver.getTitle());
	}

}
