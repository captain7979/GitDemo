package selenium_java;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class handleWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\workspace\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		
	    Set<String>window=	driver.getWindowHandles();
	    Iterator<String>it=window.iterator();
	    String pid=it.next();
	    String cid=it.next();
	    
	    driver.switchTo().window(cid);
	    String msg=driver.findElement(By.cssSelector(".im-para.red")).getText();
	   // System.out.println(msg);
	    //driver.findElement(By.cssSelector(".im-para.red")).getText();
	    String mail=driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
	    System.out.println(mail);
	    driver.switchTo().window(pid);
	    driver.findElement(By.id("username")).sendKeys(mail);

	}

}
