package getAllProduct;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import GenericUtility.ExcelUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ICCRankingRatingPrintTest {
	
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains(null));
		driver.get("https://www.icc-cricket.com/homepage");
		WebElement rankingLinkText = driver.findElement(By.xpath("//div[@class='main-navigation__header u-hide-desktop']//button[contains(text(),'Rankings')]"));
		Actions action = new Actions(driver);
		action.moveToElement(rankingLinkText).perform();
		driver.findElement(By.xpath("//button[contains(text(),\"Men's\")]/..//a[@href='/rankings/mens/team-rankings']")).click();
		//List<WebElement> teamsName = driver.findElements(By.xpath("//span[@class='u-hide-phablet']"));
		ExcelUtility eLib = new ExcelUtility();	 		
	}
}
