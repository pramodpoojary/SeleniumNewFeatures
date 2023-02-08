package MyExp;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PeTDiseaseAlert {

	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pramo\\OneDrive\\Desktop\\Selenium\\Drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://petdiseasealerts.org/forecast-map#/");
		driver.manage().window().maximize();
		Actions ac = new Actions(driver);
		JavascriptExecutor JS = (JavascriptExecutor) driver;
		String stateString = "arizona";
		ac.scrollByAmount(100, 100);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'map-instance')]")));
		List<WebElement> states = driver
				.findElements(By.xpath("//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @class='region']"));
		for (WebElement state : states) {
			System.out.println(state.getAttribute("id"));
			if (state.getAttribute("id").contains(stateString)) {
				ac.moveToElement(state).build().perform();
				break;
			}
		}

		driver.close();
	}

}
