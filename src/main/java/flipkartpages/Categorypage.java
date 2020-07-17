package flipkartpages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import flipkarttestbase.Flipkarttestbase;
import flipkarttestutility.Testutil;

public class Categorypage extends Flipkarttestbase {
	Actions a;
	public static int i;
	public static int j;
	public static int k;
	public static String searchtxt;
	public static String expectedtxt;
	
	
	
	@FindBy(xpath="//div[@class='_1xHtJz xufquN' and text()='Popularity']")
	WebElement popularity;
	@FindBy(xpath="//div[@class='_1xHtJz' and text()='Price -- Low to High']")
	WebElement pricelowtohigh;
	@FindBy(xpath="//div[@class='_1xHtJz xufquN' and text()='Price -- Low to High']")
	WebElement pricelowtohighselected;
	@FindBy(xpath="//div[@class='_3QFE_k _3bwhLT']")
	WebElement slider;
	@FindBy(xpath="//div[@class='_3G9WVX oVjMho']//div[@class='_3aQU3C']")
	WebElement sliderhandle;
	@FindBy(xpath="//div[@class='_1qKb_B']//select[@class='fPjUPw']")
	WebElement mindropdown;
	@FindBy(xpath="//div[text()='₹30000-₹50000+']")
	WebElement pricefilter;
	@FindBy (xpath="//div[text()='Voltas 1.5 Ton 3 Star Split Inverter AC  - White']")
	WebElement productclick;
	@FindBy(xpath="//div[@class='_3wU53n']")
	List<WebElement> products;
	
	@FindBy(xpath="//a[@class='_2Xp0TH']")
	List<WebElement> pagination;
	@FindBy(xpath="//span[text()='Next']")
	WebElement nextbutton;
	@FindBy(xpath="//div[@class='_3wU53n']")
	List<WebElement> product1;
	@FindBy(xpath="//span[@class='eGD5BM']")
	WebElement searchtext;
	
	
	public Categorypage()
	{
		PageFactory.initElements(driver, this);
		a = new Actions(driver);
		
	}
	
	public boolean popularityisselected()
	{
		
		return popularity.isDisplayed();
	}
	public String  title()
	{
		return driver.getTitle();
	}
	public boolean pricelowtohigh()
	{
		pricelowtohigh.click();
		return pricelowtohighselected.isDisplayed();
		
	}
	public boolean slider() throws InterruptedException
	{
		int size = slider.getSize().width;
		a.clickAndHold(sliderhandle).moveByOffset(size/2, 0).release().build().perform();
		driver.manage().timeouts().implicitlyWait(Testutil.implicitwait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Testutil.implicitwait, TimeUnit.SECONDS);
		Thread.sleep(4000);
		
		return pricefilter.isDisplayed();
	}
	public Productpage productclick() throws InterruptedException
	{
		 productclick.click();
		Set <String> s =driver.getWindowHandles();
			Iterator<String> it =s.iterator();
			String firsttab = it.next();
			String secondtab = it.next();
			driver.switchTo().window(secondtab);
			Thread.sleep(5000);
			System.out.println(driver.getTitle());
			return new Productpage();
	}
	public void pagination()
	{
		List<WebElement> productlist =  products;
		for ( i=0;i<productlist.size();i++)
		{
			productlist.get(i);
		}
		List<WebElement> paginationlist = pagination;
		for (j=0;j<paginationlist.size();j++)
			if (paginationlist.size()>0)
			{
				nextbutton.click();
				driver.manage().timeouts().pageLoadTimeout(Testutil.implicitwait, TimeUnit.SECONDS);
				List<WebElement> productlist1 = product1;
				for(k=0;k<productlist1.size();k++)
				{
					productlist.get(k);
				}
				i= i+k;
				
			}
		System.out.println(i);
		 searchtxt = searchtext.getText();
		 expectedtxt = "(Showing 193 – " +i+ " products of " +i+ " products)";
	}
	
	

}
