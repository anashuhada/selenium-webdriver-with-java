package MiniProject.DummyTicket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class DummyTicketTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
        driver.manage().window().maximize();

        System.out.println("Web app started...");
    }

    @Test
    public void dummyTicket() throws InterruptedException {
        DummyTicketPages dtp = new DummyTicketPages(driver);
        dtp.getTitle();
        dtp.imageStatus();
        dtp.clickHome();
        dtp.currencyOptions();
        dtp.radioButton();
        dtp.passengerDetails("Ameena", "Ibraheem", "1", "Jan", "2004", "Adam", "Noah", "31", "Dec", "2023");
        dtp.travelDetails("Malaysia", "USA", "30", "Jan", "2025", "No additional info.");
        dtp.deliveryOptions("30", "Oct", "2024");
        dtp.billingDetails("ABC Comp", "0123456789", "abc@example.com", "No. 123", "Harmony", "Butterworth", "12345");
        dtp.additionalInformation("Nothing, thanks.");
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        System.out.print("Web app closed...");
        driver.quit();
        Thread.sleep(3000);
    }
}
