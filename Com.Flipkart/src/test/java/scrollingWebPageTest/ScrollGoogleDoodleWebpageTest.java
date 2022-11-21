package scrollingWebPageTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollGoogleDoodleWebpageTest {
	static WebDriver driver;
	@Test
	public void scrollWebPage() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/doodles");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		
		for (; ;) {
			try {
				driver.findElement(By.xpath("//a[@title='India Independence Day 2022']")).click();
				break;
			} catch (Exception e) {
				jse.executeScript("window.scrollBy(0,1000)");
			}
		}
		
	}
}
