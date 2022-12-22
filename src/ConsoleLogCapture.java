import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class ConsoleLogCapture {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pramo\\OneDrive\\Desktop\\Selenium\\Drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		// Listeners -OnTestFailures
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(),'Browse Products')]")).click();

		driver.findElement(By.xpath("//a[contains(text(),'Selenium')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Add to Cart')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");
		LogEntries logEntry = driver.manage().logs().get(LogType.BROWSER);// get log entry object
		List<LogEntry> logs = logEntry.getAll();// get all method return all logs in list
		for (LogEntry e : logs) { // iterating and printing all message

			System.out.println(e.getMessage());//log4j 

		}

	}
}
