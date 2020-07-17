package flipkartpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import flipkarttestbase.Flipkarttestbase;

public class Checkout extends Flipkarttestbase {
	
	@FindBy(xpath="//div[@class='_1_m52b' and text()='Login']")
	WebElement logindisplay;
	@FindBy(xpath="//span[text()='+917999084600']")
	WebElement username;
	@FindBy(xpath="//div[text()='Delivery Address']")
	WebElement delivery;
	@FindBy(xpath="//span[text()='Don bosco school road, asadpura alirajpur, Alirajpur, Alirajpur, Madhya Pradesh']")
	WebElement address;
	@FindBy(xpath="//div[text()='Voltas 1.5 Ton 3 Star Split Inverter AC  - White']")
	WebElement product;
	@FindBy(xpath="//div[@class='_3aZm8l']//div[@class='bzD9az']")
	WebElement deliverydate;
	@FindBy(xpath="//button[@class='wNrY5O' and text()='+']")
	WebElement increasequantity;
	@FindBy(xpath="//input[@type='text' and @value='2']")
	WebElement quantitytext;
	@FindBy(xpath="//button[text()='CONTINUE']")
	WebElement continuebutton;
	
	public  Checkout()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifylogin()
	{
		return logindisplay.isDisplayed();
	}
	public boolean verifyusername()
	{
		return username.isDisplayed();
	}
	public boolean verifydelivery()
	{
		return delivery.isDisplayed();
	}
	public boolean verifyaddress()
	{
		return address.isDisplayed();
	}
	public boolean verifyproduct()
	{
		return product.isDisplayed();
	}
	public boolean verifydeliverydate()
	{
		return deliverydate.isDisplayed();
	}
	public boolean increasequantity()
	{
		increasequantity.click();
		return quantitytext.isDisplayed();
	}
	

	public String verifytitle()
	{
		return driver.getTitle();
	}
	public Paymentpage clickcontinuebutton()
	{
		continuebutton.click();
		return new Paymentpage();
	}

}
