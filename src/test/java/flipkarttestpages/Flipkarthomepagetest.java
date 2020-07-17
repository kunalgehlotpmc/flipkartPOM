package flipkarttestpages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import flipkartpages.Categorypage;
import flipkartpages.Flipkarthomepage;
import flipkartpages.Productsearchpage;
import flipkarttestbase.Flipkarttestbase;

public class Flipkarthomepagetest extends Flipkarttestbase {
	Flipkarthomepage homepage;
	Productsearchpage productsearchpage;
	Categorypage categorypage;
	
	
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		homepage = new Flipkarthomepage();
	}
	@Test
	public void displayclosebutton()
	{
		boolean b = homepage.closebutton();
		Assert.assertTrue(b);
	}
	@Test
	public void clickclosebutton()
	{
		homepage = homepage.clickclosebutton();
	}
	@Test
	public void searchsuggestionclick() throws InterruptedException
	{
		homepage.clickclosebutton();
		productsearchpage = homepage.searchsuggestionclick();
		String title = driver.getTitle();
		Assert.assertEquals(title, "Low Price 4g Mobile Phone Android - Buy Products Online at Best Price in India - All Categories | Flipkart.com","title doesnot matcgh");
		
	}
	@Test
	
		public void loginbutton()
		{
			boolean b = homepage.login();
			Assert.assertTrue(b);
		}
	@Test
	public void userloggedin() throws InterruptedException
	{
		boolean b = homepage.loginbuttonclick();
		Assert.assertTrue(b);
	}
	@Test
	public void cartbutton()
	{
		boolean b = homepage.cartbutton();
		Assert.assertTrue(b);
	}
	@Test(priority=1)
	
		public void category() throws InterruptedException
		{
		homepage.clickclosebutton();
		Thread.sleep(3000);
			categorypage = homepage.categoryselection();
			
			
		}
	
	
	@AfterMethod
	public void quit()
	{
		driver.quit();
	}

}
