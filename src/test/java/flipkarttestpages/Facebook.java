package flipkarttestpages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import flipkarttestutility.Testdatautil;

public class Facebook {
	WebDriver driver;
	Testdatautil testutil;
	@BeforeMethod

	public void setup()
	{
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\GehlotK\\Desktop\\Selenium set up\\gecko driver\\geckodriver.exe");
	 driver = new FirefoxDriver();
	driver.get("https://www.facebook.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@DataProvider 
	public Object[][] getlogindata() throws Exception
	{
		Object data[][] = testutil.getdata("Sheet1");
		return data;
	}
	@Test (dataProvider ="getlogindata" )
	public void testdata(String username,String password)
	{
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
	}

}
