package day32;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://blazedemo.com");

        driver.manage().window().maximize();

        // select fromPort
        WebElement fromPort = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select fromDrop = new Select(fromPort);
        fromDrop.selectByVisibleText("Portland");

        // select toPort
        WebElement toPort = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select toDrop = new Select(toPort);
        toDrop.selectByVisibleText("New York");

        // click button find flights
        driver.findElement(By.xpath("//input[@value='Find Flights']")).click();

        // total rows
        int totalRow = driver.findElements(By.xpath("//table[@class='table']//tr")).size();
        System.out.println("Total rows: " + totalRow);

        // total columns
        int totalCol = driver.findElements(By.xpath("//table[@class='table']//th")).size();
        System.out.println("Total columns: " + totalCol);

        // read data from rows and columns
		/*for(int r = 1; r <= totalRow; r++) {
			for(int c = 1; c <= totalCol; c++) {
				String rolCol = driver.findElement(By.xpath("//table[@class='table']//tr["+ r +"]//td[" + c + "]")).getText();
				System.out.println(rolCol);
			}

			Thread.sleep(5000);
		}*/

        // read column price only
        for (int rowPrice = 1; rowPrice < totalRow; rowPrice++) {
            int countRow = driver.findElements(By.xpath("//table[@class='table']//tr[" + rowPrice + "]//td")).size();
            // System.out.println(countRow); // suppose only 5 rows
            
            if (countRow >= 5) {
                String priceText = driver.findElement(By.xpath("//table[@class='table']//tr[" + rowPrice + "]//td[6]")).getText();
                System.out.println(priceText);
                Thread.sleep(3000);

                if(priceText.equals("$200.98")) {
                    // System.out.println("$200.98 printed out");
                    WebElement clickBtn = driver.findElement(By.xpath("//tbody/tr[" + rowPrice + "]/td[1]/input[1]"));
                    clickBtn.click();
                    // System.out.println("$200.98 button clicked");

                    boolean textDisplayed = driver.findElement(By.xpath("//h2[normalize-space()='Your flight from TLV to SFO has been reserved.']")).isDisplayed();
                    System.out.println("Text is displayed: " + textDisplayed);

                    driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("Ana");
                    driver.findElement(By.xpath("//input[@id='address']")).sendKeys("No. 123");
                    driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Boston");
                    driver.findElement(By.xpath("//input[@id='state']")).sendKeys("USA");
                    driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("12345");

                    WebElement card = driver.findElement(By.xpath("//select[@id='cardType']"));
                    Select s = new Select(card);
                    s.selectByVisibleText("American Express");

                    driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("123456789");
                    driver.findElement(By.xpath("//input[@id='creditCardMonth']")).sendKeys("03");
                    driver.findElement(By.xpath("//input[@id='creditCardYear']")).sendKeys("2025");
                    driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("Ana Smith");

                    driver.findElement(By.xpath("//input[@id='rememberMe']")).click();
                    driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();

                    boolean header = driver.findElement(By.xpath("//div[@class='container hero-unit']//h1")).isDisplayed();
                    System.out.println("Header is displayed: " + header);

                    // driver.quit();
                    // Thread.sleep(3000);
                    break;
                }
            }
        }
    }
}
