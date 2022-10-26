package handlingThePopUp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollDownWebPageTest {
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.google.com/");
		WebElement searchTextField = driver.findElement(By.xpath("//input[@title=\"Search\"]"));
		searchTextField.sendKeys("googledoodle");
		searchTextField.submit();
		driver.findElement(By.xpath("//cite[text()='https://www.google.com']")).click();
		
		for (; ; ) {
			try {
				driver.findElement(By.xpath("//a[@title=\"Quino's 90th Birthday\"]")).click();
				
				
			} catch (Exception e) {
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,600);");
			}
		}
	}
}
