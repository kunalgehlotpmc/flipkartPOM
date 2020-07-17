package flipkarttestpages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import flipkarttestutility.Amazonregistrationdata;

public class Amazonregistration {
	public static WebDriver driver;
	public static Amazonregistrationdata testutil;
	@BeforeMethod
	public void setup()
	{
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\GehlotK\\Desktop\\Selenium set up\\gecko driver\\geckodriver.exe");
	 driver = new FirefoxDriver();
	driver.get("https://www.amazon.in/ap/register?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3F_encoding%3DUTF8%26ref_%3Dnav_newcust&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

}
	@DataProvider
	
		public Object[][] testdata() throws Exception
		{
		Object [][]data = Amazonregistrationdata.testdata("Sheet3");
		return data;
		
	}
	@Test(dataProvider="testdata")
	public void registertest(String name,String mobilenumber,String email,String password) throws Exception
	
	{
	driver.findElement(By.xpath("//input[@name='customerName' and @id='ap_customer_name']")).sendKeys(name);
	driver.findElement(By.xpath("//input[@type='tel']")).sendKeys(mobilenumber);
	driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
	Thread.sleep(2000);
		
	}
	@AfterMethod
	
		public void quit()
		{
		driver.quit();
	}
}

