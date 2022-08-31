package selenium_java;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class addtoCartPractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		String[] itemNeeded = { "Brocolli", "Tomato", "Brinjal", "Potato", "Onion" };
		List al = Arrays.asList(itemNeeded);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();
		List<WebElement> itemName = driver.findElements(By.cssSelector("h4.product-name"));
		int j = 0;
		for (int i = 0; i < itemName.size(); i++) {
			String[] item = itemName.get(i).getText().split("-");
			String formatteditem = item[0].trim();
			if (al.contains(formatteditem)) {

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				j++;
				if (j == itemNeeded.length) {
					break;
				}

			}
		}
		driver.findElement(By.cssSelector("a.cart-icon")).click();
		driver.findElement(By.xpath("//div[@class='action-block']/button")).click();
		driver.findElement(By.cssSelector("input.promocode")).sendKeys("rahulshettyacademy");
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		//JavascriptExecutor js=(JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,250)", "");
		//Thread.sleep(9000);
		
		driver.findElement(By.xpath("//button[normalize-space()='Place Order']")).click();
		
		Select ab=new Select(driver.findElement(By.tagName("select")));
		ab.selectByValue("India");
		
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Proceed']")).click();
		
		

	}

}
