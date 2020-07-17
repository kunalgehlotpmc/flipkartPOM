package flipkarttestpages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import flipkartpages.Categorypage;
import flipkartpages.Checkout;
import flipkartpages.Flipkarthomepage;
import flipkartpages.Paymentpage;
import flipkartpages.Productpage;
import flipkarttestbase.Flipkarttestbase;
import flipkarttestutility.Testutil;

public class Checkouttestpage extends Flipkarttestbase {
	Flipkarthomepage homepage;
	Categorypage categorypage;
	Productpage productpage;
	Checkout checkout;
	Paymentpage paymentpage;
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException
	{
		initialization();
		homepage = new Flipkarthomepage();
		categorypage = new Categorypage();
		productpage = new Productpage();
		checkout = new Checkout();
		paymentpage = new Paymentpage();
		homepage.loginbuttonclick();
		categorypage = homepage.categoryselection();
		productpage = categorypage.productclick();
		checkout = productpage.clickbuynow();
		driver.manage().timeouts().implicitlyWait(Testutil.implicitwait, TimeUnit.SECONDS);
	}
	@Test
	public void loginverify()
	{
		boolean b = checkout.verifylogin();
		Assert.assertTrue(b);
	}
	@Test
	public void usernameverify()
	{
		boolean b = checkout.verifyusername();
		Assert.assertTrue(b);
	}
	@Test
	public void verifydelivery()
	{
		boolean b = checkout.verifydelivery();
		Assert.assertTrue(b);
	}
	@Test
	public void verifyaddress()
	{
		boolean b = checkout.verifyaddress();
		Assert.assertTrue(b);
		
	}
	@Test
	public void verifyproduct()
	{
		boolean b = checkout.verifyaddress();
		Assert.assertTrue(b);
		
	}
	@Test
	public void verifydeliverydate()
	{
		boolean b = checkout.verifydeliverydate();
		Assert.assertTrue(b);
	}
	@Test
	public void increasequantity()
	{
		boolean b = checkout.increasequantity();
		Assert.assertTrue(b);
	}
	@Test
	public void clickcontinue()
	{
		paymentpage = checkout.clickcontinuebutton();
	}
	@AfterMethod
	public void quit()
	{
		driver.quit();
	}
	
	

}
