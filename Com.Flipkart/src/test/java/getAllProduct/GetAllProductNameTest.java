package getAllProduct;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
	
public class GetAllProductNameTest {
	
	static WebDriver driver ;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.linkText("Mobiles")).click();
		WebElement searchTextField = driver.findElement(By.xpath("//input[@title='Search for products, brands and more']"));
		searchTextField.sendKeys("Mobile");
		searchTextField.sendKeys(Keys.ENTER);
		List<WebElement> allMobileProducts = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		List<WebElement> allMobilePrices = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		
	}
}
