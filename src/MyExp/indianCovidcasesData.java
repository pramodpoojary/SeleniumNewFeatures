package MyExp;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class indianCovidcasesData {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pramo\\OneDrive\\Desktop\\Selenium\\Drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(
				"https://www.google.com/search?q=covid+cases+in+india&sxsrf=AJOqlzU7vr1uOiUWaFnILYPY0Zp-jmKeUQ%3A1676213668834&source=hp&ei=pP3oY9PPMIeT-AaV0YaYBw&iflsig=AK50M_UAAAAAY-kLtH83lrYp8U3tr-l7b-sEhMhw_57l&ved=0ahUKEwjTsa_CnpD9AhWHCd4KHZWoAXMQ4dUDCAk&uact=5&oq=covid+cases+in+india&gs_lcp=Cgdnd3Mtd2l6EAMyBAgjECcyCAgAEIAEELEDMggIABCABBCxAzIICAAQgAQQsQMyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgARQAFgAYOwGaABwAHgAgAF3iAF3kgEDMC4xmAEAoAECoAEB&sclient=gws-wiz");
		WebElement element = driver.findElement(By.xpath("(//*[local-name()='svg']//*[name()='g'])[2]"));
		Actions act = new Actions(driver);

		int getTopLeftY = ((element.getSize().getHeight()) / 2) - element.getSize().getHeight();
		int getTopLeftX = ((element.getSize().getWidth()) / 2) - element.getSize().getWidth();
		String startDate = "12-01-2023";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate currentDate = LocalDate.now();
		LocalDate specifiedDate = LocalDate.parse(startDate, dtf);
		System.out.println(currentDate + " " + specifiedDate);
		Period period = Period.between(specifiedDate, currentDate);
		int differenceInDays = period.getDays() + period.getMonths() * 30 + period.getYears() * 365;
		System.out.println(differenceInDays);
		for (int i = 0; i <= differenceInDays; i++) {
			act.moveToElement(element, getTopLeftX + i, getTopLeftY).perform();
			String dataString = driver.findElement(By.xpath("//div[@class='ExnoTd']")).getText();
			String[] ls = dataString.split("\n");
			System.out.println(Arrays.toString(ls));
			// System.out.println(dataString);
		}

		driver.close();
	}

}
