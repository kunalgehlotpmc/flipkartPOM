package flipkartpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import flipkarttestbase.Flipkarttestbase;
import flipkarttestutility.Testutil;

public class Productpage extends Flipkarttestbase {
	public static String actprodprice;
	public static String expprodprice;
	
	@FindBy(xpath="//span[@class='_35KyD6']")
	WebElement productname;
	@FindBy(xpath="//div[@class='_3BTv9X _3iN4zu']//img[@alt='Voltas 1.5 Ton 3 Star Split Inverter AC  - White']")
	WebElement productimg;
	@FindBy(xpath="//span[@id='productRating_LSTACNFHHUXNFGV6KRGRZMCIB_ACNFHHUXNFGV6KRG_']//div[@class='hGSR34']//img[@class='_2lQ_WZ']")
	WebElement productrating;
	@FindBy(xpath="//div[@class='_1vC4OE _3qQ9m1']")
	WebElement price;
	@FindBy(xpath="//div[@class='_2dcihZ']")
	WebElement productincart;
	@FindBy(xpath="//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")
	WebElement addtocart;
	@FindBy(xpath="//button[text()='BUY NOW']")
	WebElement buynow;
	public Productpage()
	{
		PageFactory.initElements(driver, this);
	}
	public boolean productnamedisplayed()
	{
		return  productname.isDisplayed();
	}
	public boolean productimgdisplayed()
	{
		return productimg.isDisplayed();
	}
	public boolean productratingdisplayed()
	{
		return productrating.isDisplayed();
	}
	public void productprice()
	{
		 actprodprice = price.getText();
		 expprodprice = Testutil.productprice;
	}
	public boolean clickonaddtocart() throws InterruptedException
	{
		addtocart.click();
		Thread.sleep(2000);
		driver.navigate().back();
		return productincart.isDisplayed();
	}
	public Checkout clickbuynow()
	{
		buynow.click();
		return new Checkout();
	}

}
