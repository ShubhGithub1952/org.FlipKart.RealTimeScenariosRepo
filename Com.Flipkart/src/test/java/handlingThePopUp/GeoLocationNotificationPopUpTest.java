package handlingThePopUp;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author SHUBH
 * Handling the Geo-Location Pop-Up
 * 
 */
public class GeoLocationNotificationPopUpTest {
	static WebDriver driver;
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Integer> contentsettings = new HashMap<String, Integer>();
		contentsettings.put("geolocation", 1);
		HashMap<String, Object> profile = new HashMap<String, Object>();	
		profile.put("managed_default_content_settings", contentsettings);
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile", profile);
		options.setExperimentalOption("prefs", prefs);
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://whatmylocation.com/");
	}
}
