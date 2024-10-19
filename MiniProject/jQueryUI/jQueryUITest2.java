package MiniProject.jQueryUI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class jQueryUITest2 {

    WebDriver driver;
    String getUrl = "https://jqueryui.com/";

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        System.out.println("jQueryUI started...");
    }

    @Test(priority = 1)
    public void testResizable() throws InterruptedException {
        driver.get(getUrl);
        jQueryUIPages2 j2 = new jQueryUIPages2(driver);
        j2.resizable();
    }

    @Test(priority = 2)
    public void testAutoComplete() throws InterruptedException {
        driver.get(getUrl);
        jQueryUIPages3 j3 = new jQueryUIPages3(driver);
        j3.autoComplete("A");
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        //driver.switchTo().defaultContent();
        System.out.println("jQueryUI closed...");
        Thread.sleep(2000);
        driver.quit();
    }
}
