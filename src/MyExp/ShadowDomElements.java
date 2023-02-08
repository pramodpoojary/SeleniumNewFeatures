package MyExp;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDomElements {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pramo\\OneDrive\\Desktop\\Selenium\\Drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://sandbox-sponsors.pointsville.com/");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement username = (WebElement) jse.executeScript(
				"return document.querySelector('amplify-authenticator > amplify-sign-in').shadowRoot.querySelector('amplify-form-section > amplify-auth-fields').shadowRoot.querySelector('div > amplify-username-field').shadowRoot.querySelector('amplify-form-field').shadowRoot.querySelector('input')");
		WebElement password = (WebElement) jse.executeScript(
				"return document.querySelector(\"amplify-authenticator > amplify-sign-in\").shadowRoot.querySelector(\"amplify-form-section > amplify-auth-fields\").shadowRoot.querySelector(\"div > amplify-password-field\").shadowRoot.querySelector(\"amplify-form-field\").shadowRoot.querySelector(\"#password\")");
		WebElement resetPwdLink = (WebElement) jse.executeScript(
				"return document.querySelector(\"amplify-authenticator > amplify-sign-in\").shadowRoot.querySelector(\"amplify-form-section > amplify-auth-fields\").shadowRoot.querySelector(\"div > amplify-password-field\").shadowRoot.querySelector(\"amplify-form-field\").shadowRoot.querySelector(\"#password-hint > div > amplify-button\")");

		String js = "arguments[0].setAttribute('value', 'NaveenAutomationLabs')";
		((JavascriptExecutor) driver).executeScript(js, username);
		((JavascriptExecutor) driver).executeScript(js, password);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", resetPwdLink);

	}

}
