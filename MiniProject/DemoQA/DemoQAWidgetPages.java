package MiniProject.DemoQA;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DemoQAWidgetPages {

    WebDriver driver;
    JavascriptExecutor js;
    Actions act;

    DemoQAWidgetPages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
    }

    @FindBy(xpath = "//body/div[@id='app']/div[contains(@class,'body-height')]/div[contains(@class,'container playgound-body')]/div[contains(@class,'row')]/div[contains(@class,'col-md-3')]/div[contains(@class,'left-pannel')]/div[contains(@class,'accordion')]/div[1]/span[1]/div[1]/div[1]") WebElement widgetsMenu;
    @FindBy(xpath = "//span[normalize-space()='Accordian']") WebElement accordian;
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
    @FindBy(xpath = "//div[@class='auto-complete__menu-list css-11unzgr']//div") List<WebElement> listSingle;

    public void singleAutoComplete() throws InterruptedException {
        js.executeScript("arguments[0].click()", autoComplete);

        js.executeScript("arguments[0].click()", singleAutoComplete);
        js.executeScript("arguments[0].value='A';", singleAutoComplete);
        System.out.println("A...");
        for(WebElement list : listSingle) {
            if(list.getText().equals("Aqua")) {
                js.executeScript("arguments[0].click()", list);
            }
        }
    }

    @FindBy(xpath = "//span[normalize-space()='Date Picker']") WebElement datePickerMenu;
    @FindBy(xpath = "//input[@id='datePickerMonthYearInput']") WebElement datePicker1;
    @FindBy(xpath = "//select[@class='react-datepicker__month-select']") WebElement optionMonth;
    @FindBy(xpath = "//select[@class='react-datepicker__year-select']") WebElement optionYear;
    @FindBy(xpath = "//button[normalize-space()='Next Month']") WebElement nextButton;
    @FindBy(xpath = "//button[normalize-space()='Previous Month']") WebElement previousButton;
    @FindBy(xpath = "//div[@class='react-datepicker__month']//div") List<WebElement> allDate;

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

    public void datePicker(String date, String month, String year) throws InterruptedException {
        js.executeScript("arguments[0].click()", datePickerMenu);
        js.executeScript("arguments[0].click()", datePicker1);
        selectingNextMonthYear(month,year);
        selectingDate(date);
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
    @FindBy(xpath = "//select[@id='oldSelectMenu']") WebElement oldSelectMenu;
    @FindBy(xpath = "//select[@id='cars']") WebElement standardMultiSelect;

    public void oldSelectMenu() {
        js.executeScript("arguments[0].click()", selectMenu);

        Select selOldMenu = new Select(oldSelectMenu);
        List<WebElement> oldStyle = selOldMenu.getOptions();
        for(WebElement old : oldStyle) {
            // System.out.println(old.getText());
            if(old.getText().equals("Purple")) {
                old.click();
            }
        }
    }

    public void standardMenu() {
        js.executeScript("arguments[0].click()", selectMenu);
        Select selStandardMenu = new Select(standardMultiSelect);
        List<WebElement> standardMenu = selStandardMenu.getOptions();
        for(WebElement st : standardMenu) {
            // System.out.println(st.getText());
            if(st.getText().equals("Audi")) {
                st.click();
            }
        }
    }
}


