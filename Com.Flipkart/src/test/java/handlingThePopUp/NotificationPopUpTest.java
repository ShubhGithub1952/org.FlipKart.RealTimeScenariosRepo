package handlingThePopUp;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author SHUBH
 *  Handling the Notification Pop-Up on the Notification Application
 */
public class NotificationPopUpTest {
	static WebDriver driver;
	public static void main(String[] args) throws Throwable {
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Integer> contentsettings = new HashMap<String, Integer>();
		HashMap<String, Object> profile = new HashMap<String, Object>();
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		contentsettings.put("notifications", 1);
		profile.put("managed_default_content_settings", contentsettings);
		prefs.put("profile", profile);
		options.setExperimentalOption("prefs", prefs);
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://web-push-book.gauntface.com/demos/notification-examples/");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		//Thread.sleep(2000);
		//driver.close();
	}
}
