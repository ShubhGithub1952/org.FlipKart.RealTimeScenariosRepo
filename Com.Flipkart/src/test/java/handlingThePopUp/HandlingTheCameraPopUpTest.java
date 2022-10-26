package handlingThePopUp;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author SHUBH
 *	Handling the Camera PopUp
 */
public class HandlingTheCameraPopUpTest {
	static WebDriver driver;
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Integer> contentsettings = new HashMap<String, Integer>();
		HashMap<String, Object> profile = new HashMap<String, Object>();
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		contentsettings.put("media_stream", 2);
		profile.put("managed_default_content_settings", contentsettings);
		prefs.put("profile", profile);
		options.setExperimentalOption("prefs", prefs);
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://webcamtests.com/");
		driver.findElement(By.id("webcam-launcher")).click();
		Thread.sleep(5000);
		driver.quit();
	}
}
