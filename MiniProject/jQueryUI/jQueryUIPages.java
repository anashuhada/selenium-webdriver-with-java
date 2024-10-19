package MiniProject.jQueryUI;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class jQueryUIPages {

    WebDriver driver;
    JavascriptExecutor js;
    Alert al;
    Actions act;

    jQueryUIPages(WebDriver driver) {
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

    @FindBy(xpath = "//a[normalize-space()='Autocomplete']") WebElement autoCompleteMenu;
    @FindBy(xpath = "//input[@id='tags']") WebElement inputTags;
    @FindBy(xpath = "//ul[@id='ui-id-1']//li") List<WebElement> listTags;

    public void autoComplete(String value) {
        js.executeScript("arguments[0].click()", autoCompleteMenu);

        driver.switchTo().frame(frame);

        inputTags.sendKeys(value);
        for(WebElement list : listTags) {
            // System.out.println(list.getText());
            String text = list.getText();
            if(text.equals("Java")) {
                js.executeScript("arguments[0].click()", list);
                System.out.println("Java");
            }
        }
    }

    @FindBy(xpath = "//a[normalize-space()='Selectmenu']") WebElement selectMenu;
    @FindBy(xpath = "//span[@id='speed-button']") WebElement speedButton;
    @FindBy(xpath = "//ul[@id='speed-menu']//li") List<WebElement> listSpeedButton;
    @FindBy(xpath = "//span[@id='files-button']") WebElement fileButton;
    @FindBy(xpath = "//ul[@id='files-menu']//li[@class='ui-menu-item']") List<WebElement> listFileButton;
    @FindBy(xpath = "//span[@id='number-button']") WebElement numberButton;
    @FindBy(xpath = "//ul[@id='number-menu']//li") List<WebElement> listNumberButton;
    @FindBy(xpath = "//span[@id='salutation-button']") WebElement salutationButton;
    @FindBy(xpath = "//ul[@id='salutation-menu']//li[@class='ui-menu-item']") List<WebElement> listsalutationButton;

    public void selectMenu() throws InterruptedException {
        js.executeScript("arguments[0].click()", selectMenu);

        driver.switchTo().frame(frame);

        js.executeScript("arguments[0].click()", speedButton);
        for(WebElement listSpeed : listSpeedButton) {
            //System.out.println(list.getText());
            String text = listSpeed.getText();
            if(text.equals("Faster")) {
                js.executeScript("arguments[0].click()", listSpeed);
                System.out.println("Faster");
            }
        }

        Thread.sleep(2000);

        js.executeScript("arguments[0].click()", fileButton);
        for(WebElement listFile : listFileButton) {
            //System.out.println(listFile.getText());
            String text = listFile.getText();
            if(text.equals("ui.jQuery.js")) {
                js.executeScript("arguments[0].click()", listFile);
                Thread.sleep(3000);
                System.out.println("ui.jQuery.js");
            }
        }

        Thread.sleep(2000);

        js.executeScript("arguments[0].click()", numberButton);
        for(WebElement listNumber : listNumberButton) {
            //System.out.println(listNumber.getText());
            String text = listNumber.getText();
            if(text.equals("11")) {
                js.executeScript("arguments[0].click()", listNumber);
                Thread.sleep(3000);
                System.out.println("11");
            }
        }

        Thread.sleep(2000);

        js.executeScript("arguments[0].click()", salutationButton);
        for(WebElement listSal : listsalutationButton) {
            //System.out.println(listSal.getText());
            String text = listSal.getText();
            if(text.equals("Other")) {
                js.executeScript("arguments[0].click()", listSal);
                Thread.sleep(3000);
                System.out.println("Other");
            }
        }
    }

    @FindBy(xpath = "//a[normalize-space()='Spinner']") WebElement spinnerMenu;
    @FindBy(xpath = "//iframe[@class='demo-frame']") WebElement iframe;
    @FindBy(xpath = "//input[@id='spinner']") WebElement inputSpinner;
    @FindBy(xpath = "//span[@class='ui-button-icon ui-icon ui-icon-triangle-1-n']") WebElement arrowUp;
    @FindBy(xpath = "//span[@class='ui-button-icon ui-icon ui-icon-triangle-1-s']") WebElement arrowDown;
    @FindBy(xpath = "//button[@id='disable']") WebElement disableButton;
    @FindBy(xpath = "//button[@id='destroy']") WebElement destroyButton;
    @FindBy(xpath = "//button[@id='getvalue']") WebElement getValueButton;
    @FindBy(xpath = "//button[@id='setvalue']") WebElement setValueButton;

    public void clickArrowUp() {
        act = new Actions(driver);
        act.contextClick(arrowUp)
                .clickAndHold()
                .pause(5000)
                .moveByOffset(0, -50)
                .release()
                .perform();
    }

    public void clickArrowDown() {
        act = new Actions(driver);
        act.contextClick(arrowDown)
                .clickAndHold()
                .pause(5000)
                .moveByOffset(100, 50)
                .release()
                .perform();
    }

    public void spinner() throws InterruptedException {
        js.executeScript("arguments[0].click()", spinnerMenu);

        driver.switchTo().frame(iframe);

        clickArrowUp();
        js.executeScript("arguments[0].click()", getValueButton);
        al = driver.switchTo().alert();
        Thread.sleep(3000);
        al.accept();

        inputSpinner.clear();

        clickArrowDown();
        js.executeScript("arguments[0].click()", getValueButton);
        al = driver.switchTo().alert();
        Thread.sleep(3000);
        al.accept();

        disableButton.click();
        Thread.sleep(5000);
        disableButton.click();

        Thread.sleep(2000);

        destroyButton.click();
        Thread.sleep(3000);
        destroyButton.click();

        inputSpinner.clear();
        setValueButton.click();
    }
}
