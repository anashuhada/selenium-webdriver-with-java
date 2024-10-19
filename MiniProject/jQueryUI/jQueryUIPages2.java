package MiniProject.jQueryUI;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class jQueryUIPages2 {

    WebDriver driver;
    JavascriptExecutor js;
    Actions act;

    jQueryUIPages2(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
    }

    @FindBy(xpath = "//a[normalize-space()='Resizable']") WebElement resizableMenu;
    @FindBy(xpath = "//iframe[@class='demo-frame']") WebElement frame;
    @FindBy(xpath = "//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']") WebElement dragHandle;

    public void resizable() throws InterruptedException {
        js.executeScript("arguments[0].click()", resizableMenu);

        driver.switchTo().frame(frame);
        act = new Actions(driver);

        System.out.println("Before resizing: " + dragHandle.getLocation().getX() + " | " + dragHandle.getLocation().getY());

        Thread.sleep(2000);

        act.dragAndDropBy(dragHandle, 200, 200).perform();
        System.out.println("After resizing: " + dragHandle.getLocation().getX() + " | " + dragHandle.getLocation().getY());
    }
}
