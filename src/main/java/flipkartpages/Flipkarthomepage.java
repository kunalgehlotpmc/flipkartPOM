package flipkartpages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


import flipkarttestbase.Flipkarttestbase;

public class Flipkarthomepage extends Flipkarttestbase {
	
	Flipkarthomepage homepage;
	Actions a;
	WebDriverWait wait;
	public static String url;
	
	@FindBy(xpath="//button[@class='_2AkmmA _29YdH8']")
	WebElement closebutton;
	@FindBy(xpath="//ul//li//div//a")
	List<WebElement> searchsuggestion;
	@FindBy(xpath="//ul//li//div//a//div//span")
	WebElement searchbutton;
	@FindBy(xpath="//input[@type='text']")
	WebElement search;
	@FindBy(xpath="//a[@class='_3Ep39l']")
	WebElement login;
	@FindBy(xpath="//span[text()='Cart']")
	WebElement cart;
	@FindBy(xpath="//span[text()='TVs & Appliances']")
	WebElement category;
	@FindBy(xpath="//a[@title='Inverter AC' and text()='Inverter AC']")
	WebElement subcategory;
	@FindBy (xpath="//input[@type='text' and @class='_2zrpKA _1dBPDZ']")
	WebElement username;
	@FindBy(xpath="//input[@type='password' ]")
	WebElement password;
	@FindBy(xpath="//button[@class='_2AkmmA _1LctnI _7UHT_c']")
	WebElement loginbutton;
	@FindBy(xpath="//div[text()='My Account']")
	WebElement Myaccount;
	
	public Flipkarthomepage()
	{
		PageFactory.initElements(driver, this);
		a = new Actions(driver);
		
		
		
	}
	
	public boolean closebutton()
	{
		return closebutton.isDisplayed();
	}
	public Flipkarthomepage clickclosebutton()
	{
		closebutton.click();
		return new Flipkarthomepage();
	}
	public Productsearchpage searchsuggestionclick() throws InterruptedException
	{
		search.sendKeys(pr.getProperty("searchkey"));
		Thread.sleep(3000);
		
		List <WebElement> list =  searchsuggestion;
		for (int i=0;i<list.size();i++)
		{
			if (list.get(i).getText().contains("low price 4g mobile phone android"))
			{
				list.get(i).click();
				
			}
		}
		
		
		return new Productsearchpage();
			
		
	}
	public boolean search()
	{
		return search.isDisplayed();
	}
	public boolean login()
	{
		return login.isDisplayed();
	}
	public boolean loginbuttonclick() throws InterruptedException
	{
		closebutton.click();
		Thread.sleep(2000);
		login.click();
		Thread.sleep(1000);
		username.sendKeys(pr.getProperty("username"));
		password.sendKeys(pr.getProperty("password"));
		loginbutton.click();
		return Myaccount.isDisplayed();
	}
	public boolean cartbutton()
	{
		return cart.isDisplayed();
	}
	public Categorypage categoryselection() throws InterruptedException
	{
		a.moveToElement(category).build().perform();
		Thread.sleep(3000);
		subcategory.click();
		return new Categorypage();
		


		
	}

}



