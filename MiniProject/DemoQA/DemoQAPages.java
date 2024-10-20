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

public class DemoQAPages {

    WebDriver driver;
    JavascriptExecutor js;
    Actions act;
    Alert al;

    // constructor
    DemoQAPages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
    }

    // locators
    @FindBy(xpath = "//span[normalize-space()='Text Box']") WebElement textboxMenu;
    @FindBy(xpath = "//input[@id='userName']") WebElement userName;
    @FindBy(xpath = "//input[@id='userEmail']") WebElement userEmail;
    @FindBy(xpath = "//textarea[@id='currentAddress']") WebElement currentAddress;
    @FindBy(xpath = "//textarea[@id='permanentAddress']") WebElement permanentAddress;
    @FindBy(xpath = "//button[@id='submit']") WebElement textBoxSubmit;
    @FindBy(xpath = "//div[@class='border col-md-12 col-sm-12']") List<WebElement> listTextBoxOutput;

    // action methods
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

    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/span[1]/div[1]") WebElement formsMenu;
    @FindBy(xpath = "//span[normalize-space()='Practice Form']") WebElement practiceFormMenu;
    @FindBy(xpath = "//input[@id='firstName']") WebElement firstName;
    @FindBy(xpath = "//input[@id='lastName']") WebElement lastName;
    @FindBy(xpath = "//input[@id='userEmail']") WebElement userEmailAddress;
    @FindBy(xpath = "//div[@class='custom-control custom-radio custom-control-inline']//input[@name='gender']") List<WebElement> gender;
    @FindBy(xpath = "//input[@id='userNumber']") WebElement userPhoneNo;
    @FindBy(xpath = "//input[@id='dateOfBirthInput']") WebElement dateOfBirth;
    @FindBy(xpath = "//select[@class='react-datepicker__month-select']") WebElement optionMonth;
    @FindBy(xpath = "//select[@class='react-datepicker__year-select']") WebElement optionYear;
    @FindBy(xpath = "//button[normalize-space()='Next Month']") WebElement nextButton;
    @FindBy(xpath = "//button[normalize-space()='Previous Month']") WebElement previousButton;
    @FindBy(xpath = "//div[@class='react-datepicker__month']//div") List<WebElement> allDate;
    @FindBy(xpath = "//div[@class='subjects-auto-complete__control css-yk16xz-control']") WebElement subjects;
    @FindBy(xpath = "//div[@class='subject-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']") WebElement autoComp;
    @FindBy(xpath = "//div[@class='subjects-auto-complete__menu css-26l3qy-menu']") List<WebElement> listAutoComp;
    @FindBy(xpath = "//div[@class='custom-control custom-checkbox custom-control-inline']//input") List<WebElement> hobbies;
    @FindBy(xpath = "//input[@id='uploadPicture']") WebElement uploadButton;
    @FindBy(xpath = "//textarea[@id='currentAddress']") WebElement currentAddressForm;
    @FindBy(xpath = "//div[@id='state']//div[contains(@class,'css-1hwfws3')]") WebElement dropDownState;
    @FindBy(xpath = "//div[@id='state']//div[contains(@class,'css-1hwfws3')]//div") List<WebElement> listState;

    public void selectingNextMonthYear(String month, String year) {
        while(true) {
            Select selMonth = new Select(optionMonth);
            String currentMonth = selMonth.getFirstSelectedOption().getText();

            Select selYear = new Select(optionYear);
            String currentYear = selYear.getFirstSelectedOption().getText();
            System.out.println("Current month: " + currentMonth + " | Current year: " + currentYear);

            if(currentMonth.equals(month) && currentYear.equals(year)) {
                break;
            }
            nextButton.click();
        }
    }

    public void selectingPreviousMonthYear(String month, String year) {
        while(true) {
            Select selMonth = new Select(optionMonth);
            String currentMonth = selMonth.getFirstSelectedOption().getText();

            Select selYear = new Select(optionYear);
            String currentYear = selYear.getFirstSelectedOption().getText();
            System.out.println("Current month: " + currentMonth + " | Current year: " + currentYear);

            if(currentMonth.equals(month) && currentYear.equals(year)) {
                break;
            }
            previousButton.click();
        }
    }

    public void selectingDate(String date) {
        for(WebElement dt : allDate) {
            if(dt.getText().equals(date)) {
                dt.click();
                return;
            }
        }
    }

    public boolean isElementPresent(WebElement element) {
        try {
            // Check if the element is displayed
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            // Element not found
            return false;
        } catch (StaleElementReferenceException e) {
            // Element reference is stale (perhaps the element is no longer attached to the DOM)
            return false;
        }
    }

    public void practiceForm(String fName, String lName, String email, String phone, String selDate, String selMonth, String selYear, String sub, String uploadImage, String currAdd) throws InterruptedException {
        js.executeScript("arguments[0].click()", formsMenu);
        js.executeScript("arguments[0].click()", practiceFormMenu);

        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        userEmailAddress.sendKeys(email);

        Thread.sleep(3000);
        for(WebElement g : gender) {
            // System.out.println(g.getAttribute("value"));
            String value = g.getAttribute("value");
            if(value.equals("Female")) {
                js.executeScript("arguments[0].click()", g);
            }
        }

        userPhoneNo.sendKeys(phone);

        js.executeScript("arguments[0].click()", dateOfBirth);
        selectingPreviousMonthYear(selMonth, selYear);
        selectingDate(selDate);

        js.executeScript("arguments[0].click()", subjects);
        Thread.sleep(5000);

        if(isElementPresent(autoComp)) {
            System.out.println("Element found");
            autoComp.sendKeys("M");
            for(WebElement list : listAutoComp) {
                System.out.println(list.getText());
            }
        }
        else {
            System.out.println("No element found");
        }

        for(int h = 0; h < hobbies.size(); h++) {
            WebElement hobby = hobbies.get(h);
            if(h == 1) {
                js.executeScript("arguments[0].click()", hobby);
            }
        }

        uploadButton.sendKeys(uploadImage);

        currentAddressForm.sendKeys(currAdd);

//        js.executeScript("arguments[0].click()", dropDownState);
//        for(WebElement list : listState) {
//            System.out.println(list.getAttribute("class"));
//            if(list.getAttribute("class").equals("css-1g6gooi")) {
//                js.executeScript("arguments[0].click()", list);
//                break;
//            }
//        }
    }

    @FindBy(xpath = "//body/div[@id='app']/div[contains(@class,'body-height')]/div[contains(@class,'container playgound-body')]/div[contains(@class,'row')]/div[contains(@class,'col-md-3')]/div[contains(@class,'left-pannel')]/div[contains(@class,'accordion')]/div[3]/span[1]/div[1]/div[1]") WebElement alertFrameWindowMenu;
    @FindBy(xpath = "//span[normalize-space()='Browser Windows']") WebElement browserForWindowsMenu;
    @FindBy(xpath = "//button[@id='tabButton']") WebElement newTab;
    @FindBy(xpath = "//button[@id='windowButton']") WebElement newWindow;
    @FindBy(xpath = "//button[@id='messageWindowButton']") WebElement newWindowMessage;

    public void browserWindows() throws InterruptedException {
        js.executeScript("arguments[0].click()", alertFrameWindowMenu);
        js.executeScript("arguments[0].click()", browserForWindowsMenu);
        js.executeScript("arguments[0].click()", newTab);
        System.out.println("New tab clicked");

        String parentWindow = driver.getWindowHandle(); // single browser

        js.executeScript("arguments[0].click()", newWindow);
        System.out.println("New window clicked");

        js.executeScript("arguments[0].click()", newWindowMessage);
        System.out.println("New window message clicked");

        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);

            if(!windowHandle.equals(parentWindow)) {
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow);
        System.out.println("Switch to parent window");
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

    @FindBy(xpath = "//body/div[@id='app']/div[contains(@class,'body-height')]/div[contains(@class,'container playgound-body')]/div[contains(@class,'row')]/div[contains(@class,'col-md-3')]/div[contains(@class,'left-pannel')]/div[contains(@class,'accordion')]/div[1]/span[1]/div[1]/div[1]") WebElement widgetsMenu;
    @FindBy(xpath = "//span[normalize-space()='Accordian']") WebElement accordian;
    @FindBy(xpath = "//div[@id='section1Heading']") WebElement heading1;
    @FindBy(xpath = "//p[contains(text(),'Lorem Ipsum is simply dummy text of the printing a')]") WebElement textHeading1;
    @FindBy(xpath = "//div[@id='section2Heading']") WebElement heading2;
    @FindBy(xpath = "//div[@id='section2Content']//p[1]") WebElement text1Heading2;
    @FindBy(xpath = "//div[@id='section2Content']//p[2]") WebElement text2Heading2;
    @FindBy(xpath = "//div[@id='section3Heading']") WebElement heading3;
    @FindBy(xpath = "//div[@id='section3Content']//p") WebElement textHeading3;

    public void accordian() throws InterruptedException {
        js.executeScript("arguments[0].click()", widgetsMenu);
        js.executeScript("arguments[0].click()", accordian);

        System.out.println("TextHeading1: " + textHeading1.getText());

        Thread.sleep(2000);

        js.executeScript("arguments[0].click()", heading2);
        System.out.println("Text1Heading2: " + text1Heading2.getText());
        System.out.println("Text2Heading2: " + text2Heading2.getText());

        Thread.sleep(2000);

        js.executeScript("arguments[0].click()", heading3);
        System.out.println("TextHeading3: " + textHeading3.getText());
        js.executeScript("arguments[0].click()", heading3);
    }

    @FindBy(xpath = "//span[normalize-space()='Auto Complete']") WebElement autoComplete;
    @FindBy(xpath = "//div[@class='auto-complete__value-container css-1hwfws3']") WebElement singleAutoComplete;
    //div[@class='auto-complete_menu css-26l3qy-menu']

    public void autoComplete() {
        js.executeScript("arguments[0].click()", autoComplete);
        js.executeScript("arguments[0].click()", singleAutoComplete);
        js.executeScript("arguments[0].setAttribute('value','M')", singleAutoComplete);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement autoCompleteOption = wait.until(ExpectedConditions.visibilityOf(singleAutoComplete));
        System.out.println(autoCompleteOption.isDisplayed());
    }

    @FindBy(xpath = "//span[normalize-space()='Date Picker']") WebElement datePickerMenu;
    @FindBy(xpath = "//input[@id='datePickerMonthYearInput']") WebElement datePicker1;
    @FindBy(xpath = "//input[@id='dateAndTimePickerInput']") WebElement datePicker2;
    @FindBy(xpath = "//span[@class='react-datepicker__month-read-view--down-arrow']") WebElement reactMonth;
    //@FindBy(xpath = "//div[@class='react-datepicker__month-dropdown']//div") List<WebElement> listMonth;
    @FindBy(xpath = "//div[contains(@class,'react-datepicker__month-dropdown-container react-datepicker__month-dropdown-container--scroll')]//div[contains(@class,'react-datepicker__month-dropdown')]//div") List<WebElement> listMonth;
    @FindBy(xpath = "//span[@class='react-datepicker__year-read-view--down-arrow']") WebElement reactYear;
    @FindBy(xpath = "//div[@class='react-datepicker__year-dropdown']//div") List<WebElement> listYear;
    @FindBy(xpath = "//a[@class='react-datepicker__navigation react-datepicker__navigation--years react-datepicker__navigation--years-upcoming']") WebElement yearUpcoming;
    @FindBy(xpath = "//a[@class='react-datepicker__navigation react-datepicker__navigation--years react-datepicker__navigation--years-previous']") WebElement yearPrevious;
    @FindBy(xpath = "//button[normalize-space()='Next Month']") WebElement reactNextButton;
    @FindBy(xpath = "//button[normalize-space()='Previous Month']") WebElement reactPreviousButton;
    @FindBy(xpath = "//div[@class='react-datepicker__month']//div") List<WebElement> reactAllDate;
    @FindBy(xpath = "//ul[@class='react-datepicker__time-list']//li") List<WebElement> timePicker;

    private String getSelectedOptionText(List<WebElement> options) {
        for (WebElement option : options) {
            if (option.getAttribute("class").contains("selected")) {  // Assuming 'selected' class marks the active option
                return option.getText();
            }
        }
        return null;
    }

    public void reactSelectingNextMonthYear(String m, String y) {
        while (true) {
            // Click to open the month dropdown
            js.executeScript("arguments[0].click()", reactMonth);

            // Wait for the month dropdown to be visible
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfAllElements(listMonth));

            String currMonth = getSelectedOptionText(listMonth);
            if (currMonth != null) {
                currMonth = currMonth.replace("✓", "").trim();
            } else {
                System.out.println("Current month is null");
                break;
            }

            // Click to open the year dropdown
            js.executeScript("arguments[0].click()", reactYear);

            // Wait for the year dropdown to be visible
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfAllElements(listYear));

            String currYear = getSelectedOptionText(listYear);
            if (currYear != null) {
                currYear = currYear.replace("✓", "").trim();
            } else {
                System.out.println("Current year is null");
                break;
            }

            System.out.println("Current month: " + currMonth + " | Current year: " + currYear);

            // Check if we've reached the target month/year
            if (currMonth.equals(m) && currYear.equals(y)) {
                break; // Successfully reached the target month/year
            }

            // Navigation Logic
            if (Integer.parseInt(currYear) < Integer.parseInt(y)) {
                // If we are in a year less than the target year
                yearUpcoming.click(); // Move to the next year
            } else if (Integer.parseInt(currYear) > Integer.parseInt(y)) {
                // If we are in a year greater than the target year
                yearPrevious.click(); // Move to the previous year
            } else {
                // Current year equals target year, so we need to change months
                if (currMonth.equals(m)) {
                    yearUpcoming.click(); // Go to January of the next year
                } else {
                    reactNextButton.click(); // Move to the next month
                }
            }
        }
    }

    public void reactSelectingDate(String d) {
        for(WebElement date : reactAllDate) {
            if(date.getText().equals(d)) {
                System.out.println("Date: " + date);
                date.click();
                return;
            }
        }
    }

    public void selectingTime(String time) {
        for(WebElement tp : timePicker) {
            if(tp.getText().equals(time)) {
                tp.click();
                return;
            }
        }
    }

    public void datePicker(String date, String month, String year) throws InterruptedException {
        js.executeScript("arguments[0].click()", datePickerMenu);
        js.executeScript("arguments[0].click()", datePicker1);
        selectingNextMonthYear(month,year);
        selectingDate(date);

//        Thread.sleep(3000);
//        js.executeScript("arguments[0].click()", datePicker2);
//        reactSelectingNextMonthYear("January", "2025");
//        reactSelectingDate("1");
//        selectingTime(time);
    }

    @FindBy(xpath = "//span[normalize-space()='Slider']") WebElement sliderMenu;
    @FindBy(xpath = "//input[@type='range']") WebElement sliderRange;
    @FindBy(xpath = "//input[@id='sliderValue']") WebElement sliderValue;

    public void slider() throws InterruptedException {
        js.executeScript("arguments[0].click()", sliderMenu);
        js.executeScript("arguments[0].scrollIntoView(true);", sliderRange);
        System.out.println("Value before moving: " + sliderValue.getAttribute("value")); // by default

        int sliderWidth = sliderRange.getSize().getWidth();
        System.out.println("Slider width: " + sliderWidth);

        int xOffset = (int) (sliderWidth * 0.25); // x offset to move the slider to 50% of its range
        System.out.println("xOffset: " + xOffset);

        Thread.sleep(3000);

        act = new Actions(driver);
        act.dragAndDropBy(sliderRange, xOffset, 0).perform();
        System.out.println("Value after moving: " + sliderValue.getAttribute("value"));
    }

    @FindBy(xpath = "//span[normalize-space()='Progress Bar']") WebElement progressBarMenu;
    @FindBy(xpath = "//button[@id='startStopButton']") WebElement startStopButton;
    @FindBy(xpath = "//div[@role='progressbar']") WebElement progressBar;

    public void progressBar() throws InterruptedException {
        js.executeScript("arguments[0].click()", progressBarMenu);
        js.executeScript("arguments[0].click()", startStopButton);
        Thread.sleep(2000);
        js.executeScript("arguments[0].click()", startStopButton);
        System.out.println(progressBar.getText());

        driver.navigate().refresh();
        Thread.sleep(2000);

        for (int i = 0; i <= 10; i++) {
            String progress = i + "%";
            js.executeScript("arguments[0].style.width = '" + progress + "';", progressBar);
            js.executeScript("arguments[0].setAttribute('aria-valuenow', '" + i + "');", progressBar);
            js.executeScript("arguments[0].innerText = '" + i + "%';", progressBar);
            System.out.println("Progress: " + i + "%");
            Thread.sleep(1000);
        }

        System.out.println("Progress ended");

    }

    @FindBy(xpath = "//span[normalize-space()='Tabs']") WebElement tabsMenu;
    @FindBy(xpath = "//a[@id='demo-tab-what']") WebElement tabWhat;
    @FindBy(xpath = "//div[@id='demo-tabpane-what']//p") WebElement tabWhatText;
    @FindBy(xpath = "//a[@id='demo-tab-origin']") WebElement tabOrigin;
    @FindBy(xpath = "//div[@id='demo-tabpane-origin']//p") WebElement tabOriginText;
    @FindBy(xpath = "//a[@id='demo-tab-use']") WebElement tabUse;
    @FindBy(xpath = "//div[@id='demo-tabpane-use']//p") WebElement tabUseText;

    public void tabs() throws InterruptedException {
        js.executeScript("arguments[0].click()", tabsMenu);
        js.executeScript("arguments[0].click()", tabWhat);
        System.out.println("Tab What Text: " + tabWhatText.getText());

        Thread.sleep(2000);
        js.executeScript("arguments[0].click()", tabOrigin);
        System.out.println("Tab Origin Text: " + tabOriginText.getText());

        Thread.sleep(2000);
        js.executeScript("arguments[0].click()", tabUse);
        System.out.println("Tab Use Text: " + tabUseText.getText());
    }

    @FindBy(xpath = "//span[normalize-space()='Tool Tips']") WebElement toolTipsMenu;
    @FindBy(xpath = "//button[@id='toolTipButton']") WebElement toolTipButton;
    @FindBy(xpath = "//input[@id='toolTipTextField']") WebElement toolTipTextField;
    @FindBy(xpath = "//a[normalize-space()='Contrary']") WebElement toolTipContrary;
    @FindBy(xpath = "//a[normalize-space()='1.10.32']") WebElement toolTipText;

    public void toolTips() throws InterruptedException {
        js.executeScript("arguments[0].click()", toolTipsMenu);
        act = new Actions(driver);
        act.moveToElement(toolTipButton).perform();
        System.out.println("Hover tool tip button");

        Thread.sleep(2000);

        act.moveToElement(toolTipTextField).perform();
        System.out.println("Hover tool tip text field");

        Thread.sleep(2000);

        act.moveToElement(toolTipContrary).perform();
        System.out.println("Hover tool tip Contrary");

        Thread.sleep(2000);

        act.moveToElement(toolTipText).perform();
        System.out.println("Hover tool tip text");
    }

    @FindBy(xpath = "//span[normalize-space()='Menu']") WebElement widgetMenu;
    @FindBy(xpath = "//a[normalize-space()='Main Item 1']") WebElement mainItem1;
    @FindBy(xpath = "//a[normalize-space()='Main Item 2']") WebElement mainItem2;
    @FindBy(xpath = "//a[normalize-space()='SUB SUB LIST »']") WebElement subItem2;
    @FindBy(xpath = "//a[normalize-space()='Sub Sub Item 2']") WebElement subSubItem2;
    @FindBy(xpath = "//a[normalize-space()='Main Item 3']") WebElement mainItem3;

    public void menu() {
        js.executeScript("arguments[0].click();", widgetMenu);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(mainItem1));

        act = new Actions(driver);
        act.moveToElement(mainItem1)
                .pause(Duration.ofSeconds(2))
                .moveToElement(mainItem2)
                .pause(Duration.ofSeconds(2))
                .moveToElement(subItem2)
                .pause(Duration.ofSeconds(2))
                .moveToElement(subSubItem2)
                .pause(Duration.ofSeconds(2))
                .moveToElement(mainItem3)
                .perform();
    }

    @FindBy(xpath = "//span[normalize-space()='Select Menu']") WebElement selectMenu;
    @FindBy(xpath = "//div[@id='selectOne']//div[contains(@class,'css-1hwfws3')]") WebElement selectOne;
    //@FindBy(xpath = "//div[contains(@class,'css-1pahdxg-control')]") WebElement selectOne;
    @FindBy(xpath = "//div[@class=' css-1s9izoc']//div//div") List<WebElement> listSelectOne;
    @FindBy(xpath = "//select[@id='oldSelectMenu']") WebElement oldSelectMenu;
    @FindBy(xpath = "//select[@id='cars']") WebElement standardMultiSelect;
    @FindBy(xpath = "//div[@class=' css-1hwfws3' and @xpath='3']") WebElement multiSelectDropdown;
    @FindBy(xpath = "//div[@class='css-1rhbuit-multiValue']//div[@class='css-12jo7m5']") List<WebElement> listMultiSelect;

    public void selectMenu() throws InterruptedException {
        js.executeScript("arguments[0].click()", selectMenu);

//        js.executeScript("arguments[0].click()", selectOne);
//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfAllElements(listSelectOne));
//        for(WebElement list : listSelectOne) {
//            if(list.getText().equals("Ms.")) {
//                list.click();
//            }
//        }

//        js.executeScript("arguments[0].click()", multiSelectDropdown);
//        for(WebElement list : listMultiSelect) {
//            System.out.println("listMultiSelect");
//            System.out.println(list.getText());
//        }


//        Select selOldMenu = new Select(oldSelectMenu);
//        List<WebElement> oldStyle = selOldMenu.getOptions();
//        for(WebElement old : oldStyle) {
//            // System.out.println(old.getText());
//            if(old.getText().equals("Purple")) {
//                old.click();
//            }
//        }
//
//        Select selStandardMenu = new Select(standardMultiSelect);
//        List<WebElement> standardMenu = selStandardMenu.getOptions();
//        for(WebElement st : standardMenu) {
//            // System.out.println(st.getText());
//            if(st.getText().equals("Audi")) {
//                st.click();
//            }
//        }


    }

    @FindBy(xpath = "//body/div[@id='app']/div[contains(@class,'body-height')]/div[contains(@class,'container playgound-body')]/div[contains(@class,'row')]/div[contains(@class,'col-md-3')]/div[contains(@class,'left-pannel')]/div[contains(@class,'accordion')]/div[5]/span[1]/div[1]/div[1]") WebElement interactionsMenu;
    @FindBy(xpath = "//span[normalize-space()='Sortable']") WebElement sortable;
    @FindBy(xpath = "//div[@class='vertical-list-container mt-4']//div[@class='list-group-item list-group-item-action']") List<WebElement> listSortable;
    @FindBy(xpath = "//a[@id='demo-tab-grid']") WebElement gridTab;
    @FindBy(xpath = "//div[@class='create-grid']//div[@class='list-group-item list-group-item-action']") List<WebElement> gridSortable;

    public void listSortable() throws InterruptedException {
        js.executeScript("arguments[0].click()", interactionsMenu);
        js.executeScript("arguments[0].click()", sortable);

        act = new Actions(driver);

        WebElement list1 = listSortable.get(0);
        WebElement list2 = listSortable.get(1);
        act.clickAndHold(list1)
                .moveToElement(list2)
                .release()
                .build()
                .perform();

        driver.navigate().refresh();
        Thread.sleep(3000);

        for(int lst = 0; lst < listSortable.size() - 1; lst++) {
            WebElement listSource  = listSortable.get(lst);
            WebElement listTarget = listSortable.get(lst + 1);
            act.clickAndHold(listSource)
                    .moveToElement(listTarget)
                    .release()
                    .build()
                    .perform();

            System.out.println("List source " + lst + " List Target " + (lst + 1));
            Thread.sleep(2000);
        }
    }

    public void gridSortable() throws InterruptedException {
        js.executeScript("arguments[0].click()", interactionsMenu);
        js.executeScript("arguments[0].click()", sortable);
        js.executeScript("arguments[0].click()", gridTab);

        act = new Actions(driver);

//        WebElement grid1 = gridSortable.get(0);
//        WebElement grid2 = gridSortable.get(5);
//
//        act.clickAndHold(grid1)
//                .moveToElement(grid2)
//                .release()
//                .build()
//                .perform();
//
//        driver.navigate().refresh();
//        Thread.sleep(3000);

        for(int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int grd = row * 3 + col;

                if (grd < gridSortable.size() - 1) {
                    WebElement gridSource = gridSortable.get(grd);
                    WebElement gridTarget = gridSortable.get(grd + 1);

                    act.clickAndHold(gridSource)
                            .moveToElement(gridTarget)
                            .release()
                            .build()
                            .perform();

                    System.out.println("Moved element " + grd + " to position " + (grd + 1));
                    Thread.sleep(2000);
                }
            }
        }
    }

    @FindBy(xpath = "//span[normalize-space()='Resizable']")  WebElement resizeableMenu;
    @FindBy(xpath = "//div[@id='resizableBoxWithRestriction']//span[@class='react-resizable-handle react-resizable-handle-se']") WebElement dragHandle1;
    @FindBy(xpath = "//div[@id='resizable']//span[@class='react-resizable-handle react-resizable-handle-se']") WebElement dragHandle2;

    public void resizable() throws InterruptedException {
        js.executeScript("arguments[0].click()", resizeableMenu);

        act = new Actions(driver);
        System.out.println("Before resizing: " + dragHandle1.getLocation().getX() + " | " + dragHandle1.getLocation().getY());

        Thread.sleep(2000);

        act.dragAndDropBy(dragHandle1, 100, 50).perform();
        System.out.println("After resizing: " + dragHandle1.getLocation().getX() + " | " + dragHandle1.getLocation().getY());

        Thread.sleep(2000);
        System.out.println("Before resizing: " + dragHandle2.getLocation().getX() + " | " + dragHandle2.getLocation().getY());

        Thread.sleep(2000);

        act.dragAndDropBy(dragHandle2, 50, 25).perform();
        System.out.println("After resizing: " + dragHandle2.getLocation().getX() + " | " + dragHandle2.getLocation().getY());
    }

    @FindBy(xpath = "//span[normalize-space()='Droppable']") WebElement droppableMenu;
    @FindBy(xpath = "//div[@id='draggable']") WebElement dragSource1;
    @FindBy(xpath = "//div[@id='simpleDropContainer']//div[@id='droppable']") WebElement dropTarget1;
    @FindBy(xpath = "//a[@id='droppableExample-tab-accept']") WebElement acceptTab;
    @FindBy(xpath = "//div[@id='acceptable']") WebElement dragAcceptSource1;
    @FindBy(xpath = "//div[@id='acceptDropContainer']//div[@id='droppable']") WebElement dropAcceptTarget1;
    @FindBy(xpath = "//div[@id='notAcceptable']") WebElement dragAcceptSource2;

    public void droppableSimple() throws InterruptedException {
        js.executeScript("arguments[0].click()", droppableMenu);

        act = new Actions(driver);
        act.dragAndDrop(dragSource1, dropTarget1);
        Thread.sleep(2000);
        System.out.println("Drag and drop");
    }

    public void droppableAccept() throws InterruptedException {
        js.executeScript("arguments[0].click()", droppableMenu);
        js.executeScript("arguments[0].click()", acceptTab);

        act = new Actions(driver);
        act.dragAndDrop(dragAcceptSource1, dropAcceptTarget1);
        Thread.sleep(2000);
        System.out.println("Drag and drop accepted");

        driver.navigate().refresh();
        Thread.sleep(3000);

        act.dragAndDrop(dragAcceptSource2, dropAcceptTarget1);
        Thread.sleep(2000);
        System.out.println("Drag and drop not accepted");
    }

    @FindBy(xpath = "//span[normalize-space()='Dragabble']") WebElement draggableMenu;
    @FindBy(xpath = "//div[@id='dragBox']") WebElement simpleDrag;
    @FindBy(xpath = "//div[@id='restrictedX']") WebElement restrictedX;

    public void draggableSimple() throws InterruptedException {
        js.executeScript("arguments[0].click()", draggableMenu);

        act = new Actions(driver);
        Thread.sleep(2000);
        act.clickAndHold(simpleDrag)
                .moveByOffset(200, 50)
                .release()
                .perform();
    }

    public void draggableAxisRestricted() throws InterruptedException {
        js.executeScript("arguments[0].click()", draggableMenu);

        act = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(restrictedX));
        act.clickAndHold(restrictedX)
                .moveByOffset(200, 0)
                .release()
                .perform();

        System.out.println("Restricted X moved");

    }

    @FindBy(xpath = "//span[normalize-space()='Selectable']") WebElement selectableMenu;
    @FindBy(xpath = "//ul[@id='verticalListContainer']//li") List<WebElement> listSelectable;
    @FindBy(xpath = "//a[@id='demo-tab-grid']") WebElement tabGrid;
    @FindBy(xpath = "//div[@class='grid-container mt-4']//div") List<WebElement> gridSelectable;

    public void listSelectable() {
        js.executeScript("arguments[0].click()", selectableMenu);

        for(WebElement list : listSelectable) {
            js.executeScript("arguments[0].click()", list);
            System.out.println("Click");
        }
    }

    public void gridSelectable() throws InterruptedException {
        js.executeScript("arguments[0].click()", selectableMenu);
        js.executeScript("arguments[0].click()", tabGrid);

        int rows = 3;
        int cols = 3;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                int index = row * cols + col;

                if (index < gridSelectable.size()) {
                    WebElement gridItem = gridSelectable.get(index);
                    js.executeScript("arguments[0].click()", gridItem);
                    System.out.println("Click");
                    Thread.sleep(2000);
                }
            }
        }
    }



}


