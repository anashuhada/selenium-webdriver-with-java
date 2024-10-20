package MiniProject.DemoQA;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DemoQAFormsPages {

    WebDriver driver;
    JavascriptExecutor js;
    WebDriverWait wait;

    DemoQAFormsPages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
    @FindBy(xpath = "//div[@class='custom-control custom-checkbox custom-control-inline']//input") List<WebElement> hobbies;
    @FindBy(xpath = "//input[@id='uploadPicture']") WebElement uploadButton;
    @FindBy(xpath = "//textarea[@id='currentAddress']") WebElement currentAddressForm;
    @FindBy(xpath = "//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']") WebElement subjects;
    @FindBy(xpath = "//div[@class='subjects-auto-complete__menu-list subjects-auto-complete__menu-list--is-multi css-11unzgr']//div") List<WebElement> listSubjects;

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
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        } catch (StaleElementReferenceException e) {
            return false;
        }
    }

    public void practiceForm(String fName, String lName, String email, String phone, String selDate, String selMonth, String selYear, String uploadImage, String currAdd) throws InterruptedException {
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

        wait.until(ExpectedConditions.visibilityOf(subjects));
        js.executeScript("arguments[0].click()", subjects);
        System.out.println("Number of list elements: " + listSubjects.size());

        if(isElementPresent(subjects)) {
            System.out.println("Element found");
            for (WebElement list : listSubjects) {
                if (list.getText().equals("Maths")) {
                    js.executeScript("arguments[0].click();", list);
                    System.out.println("Maths is clicked");
                    break;
                }
            }
        } else {
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
    }
}


