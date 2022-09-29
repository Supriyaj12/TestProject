package Pack12;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAnnotaion {
	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("Before Class");
	}
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before Method");
	}	
	@Test(priority=3)
	  public void test1() 
	  {
		System.out.println("Test 1");
	  }
	
	@Test(priority=2,enabled =false )//flase does not execute
	public void test2()
	{
		System.out.println("Test 2");
	}
	@Test(invocationCount=3,priority = 4)
	public void test3()
	{
		System.out.println("Test 3");
	//	Assert.fail(); //test3 will be fail
		
	}
	@Test(priority=1,timeOut = 3000)
	public void test4() throws InterruptedException
	{
		System.out.println("Test 4");
		Thread.sleep(4000);
		System.out.println("Hii");
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method");
	}
	@AfterClass
	public void afterClass()
	{
		System.out.println("After class");
	}
	
	

}
