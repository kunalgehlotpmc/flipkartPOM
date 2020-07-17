package flipkarttestpages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import flipkarttestutility.Testdatautil;
import flipkarttestutility.facebookregistrationtestdata;

public class Flipkartregistration {
	WebDriver driver;
	
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
	public Object[][] getdata() throws Exception
	{
		Object[][] data = facebookregistrationtestdata.getregistrationdata("Sheet2");
		return data;
	}
	@Test(dataProvider="getdata")
	
		public void registration(String firstname, String surname,String mobilenumber,String newpassword,String day,String month,String year,String gender) throws InterruptedException
		
		{
		
		
		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstname);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(surname);
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(mobilenumber);
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(newpassword);
		Select day2 = new Select(driver.findElement(By.xpath("//select[@name='birthday_day']")));
		day2.selectByVisibleText(day);
		Select month1 = new Select(driver.findElement(By.xpath("//select[@name='birthday_month']")));
		month1.selectByVisibleText(month);
		driver.findElement(By.xpath("//label[text()='"+gender+"']")).click();
		
		Thread.sleep(2000);
		Select year2 = new Select(driver.findElement(By.xpath("//select[@id='year']")));
		year2.selectByVisibleText(year);
		
		
		
		
		
		
			
		}
	@AfterMethod
	
		public void quit()
		{
			driver.quit();
		}
	}
	



