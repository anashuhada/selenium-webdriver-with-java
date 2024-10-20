package MiniProject.DemoQA;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DemoQAElementsPages {

    WebDriver driver;
    JavascriptExecutor js;
    Actions act;

    DemoQAElementsPages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
    }

    @FindBy(xpath = "//span[normalize-space()='Text Box']") WebElement textboxMenu;
    @FindBy(xpath = "//input[@id='userName']") WebElement userName;
    @FindBy(xpath = "//input[@id='userEmail']") WebElement userEmail;
    @FindBy(xpath = "//textarea[@id='currentAddress']") WebElement currentAddress;
    @FindBy(xpath = "//textarea[@id='permanentAddress']") WebElement permanentAddress;
    @FindBy(xpath = "//button[@id='submit']") WebElement textBoxSubmit;
    @FindBy(xpath = "//div[@class='border col-md-12 col-sm-12']") List<WebElement> listTextBoxOutput;

    public void textBox(String name, String email, String currAdd, String permAdd) throws InterruptedException {
        js.executeScript("arguments[0].click()", textboxMenu);

        userName.sendKeys(name);
        userEmail.sendKeys(email);
        currentAddress.sendKeys(currAdd);
        permanentAddress.sendKeys(permAdd);

        js.executeScript("arguments[0].click()", textBoxSubmit);

        for(WebElement listOutput : listTextBoxOutput) {
            System.out.println(listOutput.getText());
        }

        Thread.sleep(3000);
    }

    @FindBy(xpath = "//span[normalize-space()='Check Box']") WebElement checkBoxMenu;
    @FindBy(xpath = "//span[@class='rct-checkbox']") WebElement checkBox;

    public void checkBox() throws InterruptedException {
        checkBoxMenu.click();
        checkBox.click();
        Thread.sleep(3000);
    }

    @FindBy(xpath = "//span[normalize-space()='Radio Button']") WebElement radioButtonMenu;
    @FindBy(xpath = "//div[@class='custom-control custom-radio custom-control-inline']//input[@type='radio']") List<WebElement> listRadioButton;

    public void radioButton() throws InterruptedException {
        radioButtonMenu.click();

        for(int rb = 0; rb < listRadioButton.size(); rb++) {
            WebElement index = listRadioButton.get(rb);
            if(rb == 1) {
                js.executeScript("arguments[0].click()", index);
            }
        }
        Thread.sleep(3000);
    }

    @FindBy(xpath = "//span[normalize-space()='Web Tables']") WebElement webTablesMenu;
    @FindBy(xpath = "//input[@id='searchBox']") WebElement searchBox;
    @FindBy(xpath = "//button[@id='addNewRecordButton']") WebElement addButton;
    @FindBy(xpath = "//input[@id='firstName']") WebElement regFirstName;
    @FindBy(xpath = "//input[@id='lastName']") WebElement regLastName;
    @FindBy(xpath = "//input[@id='userEmail']") WebElement regEmail;
    @FindBy(xpath = "//input[@id='age']") WebElement regAge;
    @FindBy(xpath = "//input[@id='salary']") WebElement regSalary;
    @FindBy(xpath = "//input[@id='department']") WebElement regDepartment;
    @FindBy(xpath = "//button[@id='submit']") WebElement regSubmitButton;
    @FindBy(xpath = "//div[@class='rt-tr-group']") List<WebElement> noOfRows;
    @FindBy(xpath = "//div[@class='rt-thead -header']//div[@class='rt-resizable-header-content']") List<WebElement> noOfColumns;

    public void webTables(String fName, String lName, String email, String age, String salary, String department, String keyword) {
        webTablesMenu.click();

        addButton.click();
        regFirstName.sendKeys(fName);
        regLastName.sendKeys(lName);
        regEmail.sendKeys(email);
        regAge.sendKeys(age);
        regSalary.sendKeys(salary);
        regDepartment.sendKeys(department);

        regSubmitButton.click();

        searchBox.sendKeys(keyword);

        int totalRow = noOfRows.size();
        System.out.println("Total rows: " + totalRow);

        int totalColumn = noOfColumns.size();
        System.out.println("Total columns: " + totalColumn);
    }

    @FindBy(xpath = "//span[normalize-space()='Buttons']") WebElement buttonMenu;
    @FindBy(xpath = "//button[@id='doubleClickBtn']") WebElement doubleClickButton;
    @FindBy(xpath = "//p[@id='doubleClickMessage']") WebElement doubleClickMessage;
    @FindBy(xpath = "//button[@id='rightClickBtn']") WebElement rightClickButton;
    @FindBy(xpath = "//p[@id='rightClickMessage']") WebElement rightClickMessage;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[3]/button[1]") WebElement dynamicClickButton;
    @FindBy(xpath = "//p[@id='dynamicClickMessage']") WebElement dynamicClickMessage;

    public void buttons() throws InterruptedException {
        buttonMenu.click();

        act = new Actions(driver);
        act.doubleClick(doubleClickButton).perform();
        System.out.println(doubleClickMessage.getText());
        Thread.sleep(2000);

        act.contextClick(rightClickButton).perform();
        System.out.println(rightClickMessage.getText());
        Thread.sleep(2000);

        dynamicClickButton.click();
        System.out.println(dynamicClickMessage.getText());
        Thread.sleep(2000);
    }

    @FindBy(xpath = "//span[normalize-space()='Links']") WebElement linksMenu;
    @FindBy(xpath = "//a[@id='simpleLink']") WebElement linkHome;
    @FindBy(xpath = "//a[@id='dynamicLink']") WebElement linkHomeDynamic;
    @FindBy(xpath = "//a[@id='created']") WebElement linkCreated;
    @FindBy(xpath = "//a[@id='no-content']") WebElement linkNoContent;
    @FindBy(xpath = "//a[@id='moved']") WebElement linkMoved;
    @FindBy(xpath = "//a[@id='bad-request']") WebElement linkBadRequest;
    @FindBy(xpath = "//a[@id='unauthorized']") WebElement linkUnauthorized;
    @FindBy(xpath = "//a[@id='forbidden']") WebElement linkForbidden;
    @FindBy(xpath = "//a[@id='invalid-url']") WebElement linkInvalidUrl;
    @FindBy(xpath = "//p[@id='linkResponse']") WebElement  linkResponseMessage;

    public void links() throws InterruptedException {
        linksMenu.click();
        linkHome.click();
        Thread.sleep(2000);

        linkHomeDynamic.click();
        Thread.sleep(2000);

        Set<String> windowIDs = driver.getWindowHandles();
        List<String> listWindow = new ArrayList(windowIDs);
        String parentWindow = listWindow.get(0);
        // String childWindow1 = listWindow.get(1); // linkHome
        // String childWindow2 = listWindow.get(2); //  linkHomeDynamic

        driver.switchTo().window(parentWindow);

        js.executeScript("arguments[0].click()", linkCreated);
        System.out.println(linkResponseMessage.getText());
        Thread.sleep(2000);
        driver.navigate().refresh();

        js.executeScript("arguments[0].click()", linkNoContent);
        System.out.println(linkResponseMessage.getText());
        Thread.sleep(2000);
        driver.navigate().refresh();

        js.executeScript("arguments[0].click()", linkMoved);
        System.out.println(linkResponseMessage.getText());
        Thread.sleep(2000);
        driver.navigate().refresh();

        js.executeScript("arguments[0].click()", linkBadRequest);
        System.out.println(linkResponseMessage.getText());
        Thread.sleep(2000);
        driver.navigate().refresh();

        js.executeScript("arguments[0].click()", linkUnauthorized);
        System.out.println(linkResponseMessage.getText());
        Thread.sleep(2000);
        driver.navigate().refresh();

        js.executeScript("arguments[0].click()", linkForbidden);
        System.out.println(linkResponseMessage.getText());
        Thread.sleep(2000);
        driver.navigate().refresh();

        js.executeScript("arguments[0].click()", linkInvalidUrl);
        System.out.println(linkResponseMessage.getText());
    }

    @FindBy(xpath = "//span[normalize-space()='Broken Links - Images']") WebElement brokenLinksImageMenu;
    @FindBy(xpath = "//div[@class='col-12 mt-4 col-md-6']//img[1]") WebElement validImage;
    @FindBy(xpath = "//a[normalize-space()='Click Here for Valid Link']") WebElement validLink;
    @FindBy(xpath = "//a[normalize-space()='Click Here for Broken Link']") WebElement brokenLink;
    @FindBy(xpath = "//p[contains(text(),'This page returned a 500 status code.')]") WebElement statusCode;

    public void brokenLinksImages() throws InterruptedException {
        js.executeScript("arguments[0].click()", brokenLinksImageMenu);

        System.out.println("Valid image is displayed: " + validImage.isDisplayed());

        js.executeScript("arguments[0].click()", validLink);
        driver.navigate().back();
        Thread.sleep(2000);

        js.executeScript("arguments[0].click()", brokenLink);
        System.out.println(statusCode.getText());
    }

    @FindBy(xpath = "//span[normalize-space()='Upload and Download']") WebElement uploadDownloadMenu;
    @FindBy(xpath = "//a[@id='downloadButton']") WebElement downloadButton;
    @FindBy(xpath = "//input[@id='uploadFile']") WebElement uploadFile;

    public void uploadAndDownload() throws InterruptedException {
        uploadDownloadMenu.click();

        downloadButton.click();

        String downloadPath = "/Volumes/KINGSTON/Downloads";
        String fileName = "sampleFile.jpeg";

        File downloadedFile = new File(downloadPath, fileName);

        // waiting for the file to download
        int waitTime = 0;
        while(!downloadedFile.exists() && waitTime < 60) {
            Thread.sleep(2000);
            waitTime++;
        }

        // if the downloaded file exists, upload it
        if(downloadedFile.exists()) {
            uploadFile.sendKeys(downloadedFile.getAbsolutePath());
            System.out.println("File uploaded successfully");
        }
        else {
            System.out.println("Download failed");
        }
    }

    @FindBy(xpath = "//span[normalize-space()='Dynamic Properties']") WebElement dynamicPropertiesMenu;
    @FindBy(xpath = "//button[@id='enableAfter']") WebElement enableAfterButton;
    @FindBy(xpath = "//button[@id='colorChange']") WebElement colorChangeButton;
    @FindBy(xpath = "//button[@id='visibleAfter']") WebElement visibleAfterButton;

    public void dynamicProperties() throws InterruptedException {
        js.executeScript("arguments[0].click()", dynamicPropertiesMenu);

        Thread.sleep(5000);
        System.out.println("Clickable after 5 seconds is: " + enableAfterButton.isEnabled());

        System.out.println("Color changes after 5 seconds is: " + colorChangeButton.isDisplayed());
        Thread.sleep(5000);

        System.out.println("Button visible after 5 seconds is: " + visibleAfterButton.isDisplayed());
    }
}