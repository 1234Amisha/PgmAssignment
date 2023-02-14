package assign;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentFlipkart {

	
		public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			driver.get("https://www.flipkart.com/");
			driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
	        driver.findElement(By.name("q")).sendKeys("ipad");
	        driver.findElement(By.xpath("//div[text()=' mini 6']")).click();
	        driver.findElement(By.xpath("//div[text()='APPLE ipad Mini (2019) 64 GB ROM 7.9 inch with Wi-Fi+4G (Gold)']")).click();
	  
	        Set<String> ele= driver.getWindowHandles();
			Iterator<String> itr = ele.iterator();
			String par=itr.next();
			String child = itr.next();
			driver.switchTo().window(child);
			Actions a=new Actions(driver);
	        WebElement cart= driver.findElement(By.xpath("//button[text()='Add to cart']"));
	        a.moveToElement(cart).click().perform();
	      
	        driver.findElement(By.xpath("//span[text()='Place Order']")).click();
	        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("1234567890");
	        driver.quit();

	}

}
