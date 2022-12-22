import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class BassicAuthNew {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pramo\\OneDrive\\Desktop\\Selenium\\Drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://admin:admin@the-internet.herokuapp.com/");

		driver.findElement(By.linkText("Basic Auth")).click();

	}

}
