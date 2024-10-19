package MiniProject.jQueryUI;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class jQueryUIPages3 {

    WebDriver driver;
    JavascriptExecutor js;

    jQueryUIPages3(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
    }

    @FindBy(xpath = "//a[normalize-space()='Autocomplete']") WebElement autoCompleteMenu;
    @FindBy(xpath = "//iframe[@class='demo-frame']") WebElement frame;
    @FindBy(xpath = "//input[@id='tags']") WebElement inputTags;
    @FindBy(xpath = "//ul[@id='ui-id-1']//li") List<WebElement> listTags;

    public void autoComplete(String value) {
        js.executeScript("arguments[0].click()", autoCompleteMenu);

        driver.switchTo().frame(frame);

        inputTags.sendKeys(value);
        for(WebElement list : listTags) {
            String text = list.getText();
            if(text.equals("Java")) {
                js.executeScript("arguments[0].click()", list);
                System.out.println("Java");
            }
        }
    }
}
