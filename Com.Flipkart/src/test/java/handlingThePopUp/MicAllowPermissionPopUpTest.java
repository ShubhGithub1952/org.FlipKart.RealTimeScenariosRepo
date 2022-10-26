package handlingThePopUp;
/**
 * 
 * @author SHUBH
 *	Handling the Mic Options Of the Application
 */

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MicAllowPermissionPopUpTest {
	static WebDriver driver;
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();	
		HashMap<String, Integer> contentsettings = new HashMap<String, Integer>();
		HashMap<String, Object> profile = new HashMap<String, Object>();
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		contentsettings.put("media_stream", 1);
		profile.put("managed_default_content_settings", contentsettings);
		prefs.put("profile", profile);
		options.setExperimentalOption("prefs", prefs);
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://mictests.com/");
		driver.findElement(By.id("mic-launcher")).click();
		
	}
}
