package utilis;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	public static void captureScreenshot() throws IOException
	{
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Documents\\chromedriver.exe\\" );
		  WebDriver driver = new ChromeDriver();
	      driver.get("https://www.facebook.com/");
			
			TakesScreenshot take = (TakesScreenshot)driver;
			File sourse = take.getScreenshotAs(OutputType.FILE);
			File destination = new File("C:\\Users\\Admin\\Documents\\Screenshot" +timestamp() + ".jpeg");
			FileHandler.copy(sourse, destination);
	}
		
		   public static String timestamp()
		   {
			   return new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new Date());
		   }
		
	}


