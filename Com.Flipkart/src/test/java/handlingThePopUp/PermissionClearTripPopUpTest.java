package handlingThePopUp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PermissionClearTripPopUpTest {
	static WebDriver driver;
	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.cleartrip.com/");
		driver.findElement(By.cssSelector("svg[class=' c-pointer c-neutral-900']")).click();
	}
}
