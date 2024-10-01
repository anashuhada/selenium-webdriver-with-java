package day41;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FDCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
		
		driver.manage().window().maximize();
		
		String filePath = System.getProperty("user.dir") + "/testdata/calculationdata.xlsx";

		int rows = ExcelUtils.getRowCount(filePath, "Sheet1");
		
		// read data from excel
		for(int i = 1; i <= rows; i++) {
			
			// read data from excel
			String principle = ExcelUtils.getCellData(filePath, "Sheet1", i, 0);
			String rateOfInterest = ExcelUtils.getCellData(filePath, "Sheet1", i, 1);
			String period1 = ExcelUtils.getCellData(filePath, "Sheet1", i, 2);
			String period2 = ExcelUtils.getCellData(filePath, "Sheet1", i, 3);
			String freq = ExcelUtils.getCellData(filePath, "Sheet1", i, 4);
			String expMatValue = ExcelUtils.getCellData(filePath, "Sheet1", i, 5);
			
			// pass above data into application
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(principle);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateOfInterest);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(period1);
			
			Select perdrp = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
			perdrp.selectByVisibleText(period2);
			
			Select fredrp = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
			fredrp.selectByVisibleText(freq);
			
			WebElement calcBtn = driver.findElement(By.xpath("//div[@class='cal_div']//a[1]"));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", calcBtn);
			
			// validation
			String actMatValue = driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
			System.out.println("actMatValue: " + actMatValue);
			
			// comparing
			if(Double.parseDouble(expMatValue) == Double.parseDouble(actMatValue)) {
				System.out.println("Test passed");
				ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Passed");
				ExcelUtils.fillGreenColor(filePath, "Sheet1", i, 7);
			}
			else {
				System.out.println("Test failed");
				ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Failed");
				ExcelUtils.fillRedColor(filePath, "Sheet1", i, 7);
			}
			
			Thread.sleep(3000);
			WebElement clearBtn = driver.findElement(By.xpath("//div[@class='cal_div']//a[2]")); // click clear button
			js.executeScript("arguments[0].click()", clearBtn);
		}
		
		// ending of for loop
		driver.close();
		
	}

}
