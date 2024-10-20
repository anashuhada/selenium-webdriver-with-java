package MiniProject.DemoQA;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DemoQAAlertsFrameWindowsPages {

    WebDriver driver;
    JavascriptExecutor js;
    Alert al;

    DemoQAAlertsFrameWindowsPages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
    }

    @FindBy(xpath = "//body/div[@id='app']/div[contains(@class,'body-height')]/div[contains(@class,'container playgound-body')]/div[contains(@class,'row')]/div[contains(@class,'col-md-3')]/div[contains(@class,'left-pannel')]/div[contains(@class,'accordion')]/div[3]/span[1]/div[1]/div[1]") WebElement alertFrameWindowMenu;
    @FindBy(xpath = "//span[normalize-space()='Browser Windows']") WebElement browserForWindowsMenu;
    @FindBy(xpath = "//button[@id='tabButton']") WebElement newTab;
    @FindBy(xpath = "//button[@id='windowButton']") WebElement newWindow;
    @FindBy(xpath = "//button[@id='messageWindowButton']") WebElement newWindowMessage;

//    public void browserWindows() throws InterruptedException {
//        js.executeScript("arguments[0].click()", alertFrameWindowMenu);
//        js.executeScript("arguments[0].click()", browserForWindowsMenu);
//        js.executeScript("arguments[0].click()", newTab);
//        System.out.println("New tab clicked");
//
//        String parentWindow = driver.getWindowHandle(); // single browser
//
//        js.executeScript("arguments[0].click()", newWindow);
//        System.out.println("New window clicked");
//
//        js.executeScript("arguments[0].click()", newWindowMessage);
//        System.out.println("New window message clicked");
//
//        Set<String> windowHandles = driver.getWindowHandles();
//        for(String windowHandle : windowHandles) {
//            driver.switchTo().window(windowHandle);
//
//            if(!windowHandle.equals(parentWindow)) {
//                driver.close();
//            }
//        }
//        driver.switchTo().window(parentWindow);
//        System.out.println("Switch to parent window");
//    }

    public void browserWindows() throws InterruptedException {
        js.executeScript("arguments[0].click()", alertFrameWindowMenu);
        js.executeScript("arguments[0].click()", browserForWindowsMenu);
        js.executeScript("arguments[0].click()", newTab);
        System.out.println("New tab clicked");

        js.executeScript("arguments[0].click()", newWindow);
        System.out.println("New window clicked");

        js.executeScript("arguments[0].click()", newWindowMessage);
        System.out.println("New window message clicked");

        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowList = new ArrayList<>(windowHandles);
        String parentWindow = windowList.get(0);

        for(String winID : windowList) {
            if(!winID.equals(parentWindow)) {
                driver.switchTo().window(winID);
                Thread.sleep(3000);
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow);
        System.out.println("Switch to parent window");
        Thread.sleep(3000);
    }

    @FindBy(xpath = "//span[normalize-space()='Alerts']") WebElement alertsMenu;
    @FindBy(xpath = "//button[@id='alertButton']") WebElement alertButton;
    @FindBy(xpath = "//button[@id='timerAlertButton']") WebElement timerAlertButton;
    @FindBy(xpath = "//button[@id='confirmButton']") WebElement confirmButton;
    @FindBy(xpath = "//button[@id='promtButton']") WebElement promptButton;

    public void alerts(String name) throws InterruptedException {
        js.executeScript("arguments[0].click()", alertsMenu);

        js.executeScript("arguments[0].click()", alertButton);
        al = driver.switchTo().alert();
        System.out.println(al.getText());
        al.accept(); // ok
        Thread.sleep(2000);

        js.executeScript("arguments[0].click()", timerAlertButton);
        Thread.sleep(5000);
        System.out.println(al.getText());
        al.accept();
        Thread.sleep(2000);

        js.executeScript("arguments[0].click()", confirmButton);
        System.out.println(al.getText());
        al.dismiss(); // cancel
        Thread.sleep(2000);

        js.executeScript("arguments[0].click()", promptButton);
        System.out.println(al.getText());
        al.sendKeys(name);
        al.accept();
    }

    @FindBy(xpath = "//span[normalize-space()='Frames']") WebElement framesMenu;
    @FindBy(xpath = "//iframe[@id='frame1']") WebElement frame1;
    @FindBy(xpath = "//iframe[@id='frame2']") WebElement frame2;

    public void frames() throws InterruptedException {
        js.executeScript("arguments[0].click()", framesMenu);

        driver.switchTo().frame(frame1);
        System.out.println("Entering frame1");
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        System.out.println("Quiting from frame1");

        driver.switchTo().frame(frame2);
        System.out.println("Entering frame2");
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        System.out.println("Quiting from frame2");
    }

    @FindBy(xpath = "//span[normalize-space()='Nested Frames']") WebElement nestedFramesMenu;
    @FindBy(xpath = "//iframe[@id='frame1']") WebElement parentFrame;
    @FindBy(xpath = "//iframe[@srcdoc='<p>Child Iframe</p>']") WebElement childFrame;

    public void nestedFrames() throws InterruptedException {
        js.executeScript("arguments[0].click()", nestedFramesMenu);

        driver.switchTo().frame(parentFrame);
        System.out.println("Entering parent frame");
        Thread.sleep(2000);

        driver.switchTo().frame(childFrame);
        System.out.println("Entering child frame");
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        System.out.println("Quitting from child frame");
    }

    @FindBy(xpath = "//span[normalize-space()='Modal Dialogs']") WebElement modalDialogsMenu;
    @FindBy(xpath = "//button[@id='showSmallModal']") WebElement smallModalButton;
    @FindBy(xpath = "//div[@class='modal-body']") WebElement smallModalText;
    @FindBy(xpath = "//button[@id='closeSmallModal']") WebElement smallModalClose;
    @FindBy(xpath = "//button[@id='showLargeModal']") WebElement largeModalButton;
    @FindBy(xpath = "//p[contains(text(),'Lorem Ipsum is simply dummy text of the printing a')]") WebElement largeModalText;
    @FindBy(xpath = "//button[@id='closeLargeModal']") WebElement largeModalClose;

    public void modalDialogs() throws InterruptedException {
        js.executeScript("arguments[0].click()", modalDialogsMenu);

        js.executeScript("arguments[0].click()", smallModalButton);
        System.out.println(smallModalButton.getText());
        System.out.println(smallModalText.getText());
        js.executeScript("arguments[0].click()", smallModalClose);
        System.out.println("Small modal closed");

        Thread.sleep(2000);

        js.executeScript("arguments[0].click()", largeModalButton);
        System.out.println(largeModalButton.getText());
        System.out.println(largeModalText.getText());
        js.executeScript("arguments[0].click()", largeModalClose);
        System.out.println("Large modal closed");
    }
}


