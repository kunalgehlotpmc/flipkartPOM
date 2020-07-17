package flipkarttestpages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import flipkartpages.Categorypage;
import flipkartpages.Flipkarthomepage;
import flipkartpages.Productpage;
import flipkarttestbase.Flipkarttestbase;
import flipkarttestutility.Testutil;

public class Categorypagetest extends Flipkarttestbase {
	
	Flipkarthomepage homepage;
	Categorypage categorypage;
	WebDriverWait wait;
	Productpage productpage;
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException
	{
		initialization();
		homepage = new Flipkarthomepage();
		categorypage = new Categorypage();
		productpage = new Productpage();
	 homepage.loginbuttonclick();
		categorypage = homepage.categoryselection();
		driver.manage().timeouts().implicitlyWait(Testutil.implicitwait, TimeUnit.SECONDS);
		 
		
	}
	@Test
	public void popularity()
	{
		boolean b = categorypage.popularityisselected();
		Assert.assertTrue(b);
	}
	@Test
	public void gettitle() throws InterruptedException
	{
		Thread.sleep(4000);
		String title = categorypage.title();
		System.out.println(title);
		Assert.assertEquals(title,"AC | Buy Air Conditioner Online at Best Offers & Deals in India | Flipkart.com","Title doesnot match");
	}
	@Test
	public void lowtohighclick()
	{
		boolean b = categorypage.pricelowtohigh();
		Assert.assertTrue(b);
	}
	@Test
	public void slider() throws InterruptedException
	{
		boolean b =  categorypage.slider();
		Assert.assertTrue(b);
		
		
		
	}
	@Test(priority=1)
	public void clickproduct() throws InterruptedException
	{
		productpage = categorypage.productclick();
		
	}
	@Test
	public void productcount()
	{
		categorypage.pagination();
		Assert.assertEquals(categorypage.searchtxt, categorypage.expectedtxt);
	}
	
	@AfterMethod
	public void quit()
	{
		driver.quit();
	}

}
