package flipkarttestpages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import flipkartpages.Checkout;
import flipkartpages.Categorypage;
import flipkartpages.Flipkarthomepage;
import flipkartpages.Productpage;
import flipkarttestbase.Flipkarttestbase;
import flipkarttestutility.Testutil;

public class Producttestpage extends Flipkarttestbase {
	Flipkarthomepage homepage;
	Categorypage categorypage;
	Productpage productpage;
	Checkout checkout;
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException
	{
		initialization();
		homepage = new Flipkarthomepage();
		categorypage = new Categorypage();
		productpage = new Productpage();
		checkout = new Checkout();
		homepage.loginbuttonclick();
		categorypage = homepage.categoryselection();
		productpage = categorypage.productclick();
		
	}
	@Test
	public void productnamedisplayed()
	{
		boolean b = productpage.productnamedisplayed();
		Assert.assertTrue(b);
	}
	@Test
	public void prodimg()

	{
		driver.manage().timeouts().implicitlyWait(Testutil.implicitwait, TimeUnit.SECONDS);
		boolean b = productpage.productimgdisplayed();
		Assert.assertTrue(b);
	}
	@Test
	public void prodrating()
	{
		boolean b = productpage.productratingdisplayed();
		Assert.assertTrue(b);
	}
	@Test
	public void prodprice()
	{
		Assert.assertEquals(productpage.actprodprice, productpage.expprodprice,"price is not matching");
	}
	@Test
	public void addtocart() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Testutil.implicitwait, TimeUnit.SECONDS);
		boolean b = productpage.clickonaddtocart();
		Assert.assertTrue(b);
	}
	@Test
	public void clickbuynow()
	{
		checkout = productpage.clickbuynow();
	}
	@AfterMethod
	public void quit()
	{
		driver.quit();
	}

}
