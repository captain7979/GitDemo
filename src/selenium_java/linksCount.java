package selenium_java;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class linksCount {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.driver.chrome", "D:\\workspace\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://qaclickacademy.com/practice.php");
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		WebElement miniDriver=driver.findElement(By.id("gf-BIG"));
		System.out.println(miniDriver.findElements(By.tagName("a")).size());
		
		WebElement coloumnDriver=driver.findElement(By.xpath("//tbody/tr/td[1]/ul"));
		System.out.println(coloumnDriver.findElements(By.tagName("a")).size());
		
		int colSize=coloumnDriver.findElements(By.tagName("a")).size();
		for(int i=1;i<colSize;i++) {
			String clickonTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			coloumnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickonTab);
			Thread.sleep(5000);
		}
		
		Set<String>ab=driver.getWindowHandles();
		Iterator<String>it=ab.iterator();
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}

		
	}

}
