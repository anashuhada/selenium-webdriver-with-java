package MiniProject.jQueryUI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class jQueryUITest {

    WebDriver driver;
    String webUrl = "https://jqueryui.com/";

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        System.out.println("jQueryUI started...");
    }

    @Test(priority = 1)
    public void testResizable() throws InterruptedException {
        jQueryUIPages j = new jQueryUIPages(driver);
        driver.get(webUrl);
        j.resizable();
    }

    @Test(priority = 2)
    public void testAutoComplete() throws InterruptedException {
        jQueryUIPages j = new jQueryUIPages(driver);
        driver.get(webUrl);
        j.autoComplete("A");

    }

    @Test(priority = 3)
    public void testSelectMenu() throws InterruptedException {
        jQueryUIPages j = new jQueryUIPages(driver);
        driver.get(webUrl);
        j.selectMenu();
    }

    @Test(priority = 4)
    public void testSpinner() throws InterruptedException {
        jQueryUIPages j = new jQueryUIPages(driver);
        driver.get(webUrl);
        j.spinner();
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        System.out.println("jQueryUI closed...");
        Thread.sleep(2000);
        driver.quit();
    }
}
