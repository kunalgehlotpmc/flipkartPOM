package flipkarttestbase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import flipkarttestutility.Testutil;



public class Flipkarttestbase {
	public static Properties pr;
	public static WebDriver driver;
	public static WebDriverWait wait;

	public static void initialization() throws IOException
	{
		pr = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\GehlotK\\eclipse-workspace\\FlipkartPom\\src\\main\\java\\configproperties\\Config.properties");
		pr.load(file);
		if (pr.getProperty("browser").equals("ff"))
		 {
			 System.setProperty("webdriver.gecko.driver", "C:\\Users\\GehlotK\\Desktop\\Selenium set up\\gecko driver\\geckodriver.exe");
			 driver = new FirefoxDriver();
			  
		 }
		 else
		 {
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\GehlotK\\Desktop\\Selenium set up\\chrome driver\\chromedriver.exe");
			 driver = new ChromeDriver();
			 
		 }
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Testutil.implicitwait, TimeUnit.SECONDS);
		driver.get(pr.getProperty("url"));
		
	}
	
	}

	


