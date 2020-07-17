package flipkarttestpages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flipkartpagination {
	public static int i;
	public static int k;
	public static int j;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\GehlotK\\Desktop\\Selenium set up\\gecko driver\\geckodriver.exe");
		 WebDriver driver = new FirefoxDriver();
		driver.get("https://www.flipkart.com/air-conditioners/pr?sid=j9e,abm,c54&p[]=facets.fulfilled_by%255B%255D%3DFlipkart%2BAssured&p[]=facets.technology%255B%255D%3DInverter&p[]=facets.serviceability%5B%5D%3Dtrue&otracker=categorytree&otracker=nmenu_sub_TVs%20%26%20Appliances_0_Inverter%20AC");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement next = driver.findElement(By.xpath("//span[text()='Next']"));
		List <WebElement> list = driver.findElements(By.xpath("//div[@class='_3wU53n']"));
		for ( i =0;i<list.size();i++)
		{
			list.get(i);
			//if (next.isDisplayed())
			//{
			next.click();
			Thread.sleep(5000);
			//}
			//else
			//{
				break;
			//}
			
			
		}
		
		/*List <WebElement> paginationlist = driver.findElements(By.xpath("//a[@class='_2Xp0TH']"));
		System.out.println(paginationlist.size());
		for (j=0;j<paginationlist.size();j++)
		if (paginationlist.size()>0)
		{
			next.click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Thread.sleep(3000);
			List <WebElement> productlist = driver.findElements(By.xpath("//img[@class='_3togXc']"));
			for ( k=0;k<productlist.size();k++)
			{
				list.get(k);
			}
			i=i+k;
		}*/

	

		
	System.out.println(i);
}
}
