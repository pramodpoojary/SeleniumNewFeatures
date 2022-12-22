package AutoIt;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutoItDemo {

	public static void main(String[] args) throws InterruptedException, IOException {
		String downloadPath = System.getProperty("user.dir");
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		options.setExperimentalOption("prefs", chromePrefs);
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pramo\\OneDrive\\Desktop\\Selenium\\Drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.pdf2go.com/word-to-pdf");
		driver.findElement(By.xpath("//i[contains(text(),'Choose File')]/..")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\pramo\\OneDrive\\Desktop\\Selenium\\AutoIt\\FileUpload.exe");

		driver.findElement(By.xpath("//strong[contains(text(),'Start')]")).click();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Download')]")));
//
//		driver.findElement(By.xpath("//span[contains(text(),'Download')]/..")).click();
		Thread.sleep(10);
		File f = new File(downloadPath + "\\Pramod Poojary Resume.pdf");
		if (f.exists()) {
			System.out.println("File exists");

			f.delete();
		} else {
			System.out.println("File doesn't exist");
		}

	}

}