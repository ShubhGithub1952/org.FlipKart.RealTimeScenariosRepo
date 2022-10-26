package myntraProduct;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author SHUBH
 * handle the Pop-Up of Notification and fetch the Details of Product on Console in Sorting array
 */
public class FetchTheMyntraProductandSort {
	static WebDriver driver;
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		//options.addArguments("disable-geolocation");
		//options.addArguments("disable-media-stream");
		
		driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("https://www.myntra.com/");
		WebElement menOptions = driver.findElement(By.xpath("//div[@class='desktop-navLink']/a[@href='/shop/men']"));
		WebElement jacketOptions = driver.findElement(By.xpath("//a[text()='Topwear']/ancestor::ul[@class='desktop-navBlock']//a[text()='Jackets']"));
		Actions action = new Actions(driver);
		action.moveToElement(menOptions).moveToElement(jacketOptions).build().perform();
//		wait.until(ExpectedConditions.elementToBeClickable(jacketOptions));
		jacketOptions.click();
		String title = driver.getTitle();
		System.out.println(title);
//		wait.until(ExpectedConditions.titleContains("Jackets for Men - Buy Jackets for Men Online in India | Myntra"));
//		Thread.sleep(3000);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_ESCAPE);
//		robot.keyRelease(KeyEvent.VK_ESCAPE);
		driver.quit();
		
	}
}
