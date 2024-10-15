package MiniProject.DummyTicket;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class DummyTicketPages {

    WebDriver driver;
    JavascriptExecutor js;

    // constructor
    DummyTicketPages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // mandatory
        this.js = (JavascriptExecutor) driver;
    }

    // locators
    @FindBy(xpath = "//img[@class='navbar-logo-img navbar-logo-img-normal']") WebElement image;
    @FindBy(xpath = "//a[contains(text(),'Home')]") WebElement home;
    @FindBy(xpath = "//input[@type='radio' and @name='add_to_cart']") List<WebElement> radioButton;
    @FindBy(xpath = "//input[@id='travname']") WebElement firstName;
    @FindBy(xpath = "//input[@id='travlastname']") WebElement lastName;
    @FindBy(xpath = "//input[@id='dob']") WebElement dobPax;
    @FindBy(xpath = "//textarea[@id='order_comments']") WebElement addInfo;
    @FindBy(xpath = "//input[@type='radio' and @name='sex']") List<WebElement> gender;
    @FindBy(xpath = "//input[@id='addmorepax']") WebElement checkboxMorePax;
    @FindBy(xpath = "//span[@id='select2-addpaxno-container']") WebElement clickDropDownMorePax;
    @FindBy(xpath = "//ul[@role='listbox']//li[@role='option']") List<WebElement> dropdownMorePax;
    @FindBy(xpath = "//span[@class='woocommerce-input-wrapper']//input[@type='radio' and @name='traveltype']") List<WebElement> tripType;
    @FindBy(xpath = "//input[@id='fromcity']") WebElement origin;
    @FindBy(xpath = "//input[@id='tocity']") WebElement destination;
    @FindBy(xpath = "//input[@id='departon']") WebElement departDate;
    @FindBy(xpath = "//select[@aria-label='Select month']") WebElement selectMonth;
    @FindBy(xpath = "//select[@aria-label='Select year']") WebElement selectYear;
    @FindBy(xpath = "//span[@class='ui-icon ui-icon-circle-triangle-e']") WebElement futureBtn;
    @FindBy(xpath = "//span[@class='ui-icon ui-icon-circle-triangle-w']") WebElement previousBtn;
    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']//tr//td") List<WebElement> allDate;
    @FindBy(xpath = "//button[normalize-space()='Done']") WebElement doneBtn;
    @FindBy(xpath = "//textarea[@id='notes']") WebElement addInfoTrav;
    @FindBy(xpath = "//input[@id='travname2']") WebElement travFName;
    @FindBy(xpath = "//input[@id='travlastname2']") WebElement travLName;
    @FindBy(xpath = "//input[@id='dob2']") WebElement travDOB;
    @FindBy(xpath = "//input[@id='sex2_1']") List<WebElement> travGender;
    @FindBy(xpath = "//span[@id='select2-paxtype2-container']") WebElement paxType;
    @FindBy(xpath = "//ul[@class='select2-results__options' and @role='listbox']//li") List<WebElement> listPaxType;
    @FindBy(xpath = "//span[@id='select2-reasondummy-container']") WebElement purposeTix;
    @FindBy(xpath = "//ul[@role='listbox' and @id='select2-reasondummy-results']//li") List<WebElement> listPurposeTix;
    @FindBy(xpath = "//input[@id='appoinmentdate']") WebElement apptDate;
    @FindBy(xpath = "//input[@class='input-radio thwcfe-input-field' and @name='deliverymethod']") List<WebElement> listReceiveTix;
    @FindBy(xpath = "//div[@class='wmc-list-currencies']") WebElement currency;
    @FindBy(xpath = "//div[@class='wmc-currency ']//span") List<WebElement> listCurrency;
    @FindBy(xpath = "//input[@id='billname']") WebElement billingName;
    @FindBy(xpath = "//input[@id='billing_phone']") WebElement billingPhone;
    @FindBy(xpath = "//input[@id='billing_email']") WebElement billingEmail;
    @FindBy(xpath = "//span[@id='select2-billing_country-container']") WebElement billingCountry;
    @FindBy(xpath = "//ul[@class='select2-results__options']//li") List<WebElement> listBillingCountry;
    @FindBy(xpath = "//input[@id='billing_address_1']") WebElement billingAddress1;
    @FindBy(xpath = "//input[@id='billing_address_2']") WebElement billingAddress2;
    @FindBy(xpath = "//input[@id='billing_city']") WebElement billingCity;
    @FindBy(xpath = "//span[@id='select2-billing_state-container']") WebElement billingState;
    @FindBy(xpath = "//ul[@id='select2-billing_state-results']//li") List<WebElement> listBillingState;
    @FindBy(xpath = "//input[@id='billing_postcode']") WebElement billingPostcode;
    @FindBy(xpath = "//input[@id='payment_method_paypal']") WebElement paymentPaypal;
    @FindBy(xpath = "//input[@id='payment_method_yith-stripe']") WebElement paymentStripe;
    @FindBy(xpath = "//button[@id='place_order']") WebElement orderBtn;

    // action methods
    public void getTitle() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "Dummy ticket for applying visa - Verifiable flight reservation for embassy");
    }

    public void imageStatus() {
        boolean img = image.isDisplayed();
        System.out.println("Image is displayed: " + img);
    }

    public void clickHome() throws InterruptedException {
        home.click();
        Thread.sleep(3000);
        driver.navigate().back();
    }

    public void currencyOptions() throws InterruptedException {
        currency.click();
        System.out.println("Total currencies: " + listCurrency.size());

        for(WebElement lCurrency : listCurrency) {
            String textCurrency = lCurrency.getText();
            // System.out.println(textCurrency);
            Thread.sleep(2000);

            if(textCurrency.equals("PHP")) {
                lCurrency.click();
                Thread.sleep(2000);
                System.out.println("PHP");
            }
        }
    }

    public void radioButton() {
        int countRdBtn = radioButton.size();
        System.out.println("Total radio button: "+ countRdBtn);

        for(WebElement rb : radioButton) {
            if(rb.getAttribute("value").equals("3186")) {
                rb.click();

                String actualAlertMsg = "Dummy ticket and hotel added to your order. Complete your order below.";
                Assert.assertEquals(actualAlertMsg, "Dummy ticket and hotel added to your order. Complete your order below.");
            }
        }
    }

    public void selectingFutureMonthYear(String mt, String yr) throws InterruptedException {
        while(true) {
            Select selMth = new Select(selectMonth);
            String selectedMonth = selMth.getFirstSelectedOption().getText();

            Select selYr = new Select(selectYear);
            String selectedYear = selYr.getFirstSelectedOption().getText();

           System.out.println("Selected month: " + selectedMonth + " | Selected year: " + selectedYear);

           // if internal true
           if (selectedMonth.equals(mt) && selectedYear.equals(yr)) {
                break;
           }
            // if internal false
            futureBtn.click();
            // Thread.sleep(3000);
        }
    }

    public void selectingPrevMonthYear(String mt, String yr) throws InterruptedException {
        while(true) {
            Select selMth = new Select(selectMonth);
            String selectedMonth = selMth.getFirstSelectedOption().getText();

            Select selYr = new Select(selectYear);
            String selectedYear = selYr.getFirstSelectedOption().getText();

            System.out.println("Selected month: " + selectedMonth + " | Selected year: " + selectedYear);

            // if internal true
            if (selectedMonth.equals(mt) && selectedYear.equals(yr)) {
                break;
            }
            // if internal false
            previousBtn.click();
            // Thread.sleep(3000);
        }
    }

    public void selectingDate(String dt) {
        for (WebElement ad : allDate) {
            if (ad.getText().equals(dt)) {
                ad.click();
                doneBtn.click();
                return;
                // break;
            }
        }
    }

    public void passengerDetails(String fName, String lName, String dt1, String mt1, String yr1, String trFName, String trLName, String dt2, String mt2, String yr2) throws InterruptedException {
        // first name field
        firstName.sendKeys(fName);
        // check for placeholder
        String actualFNameP = firstName.getAttribute("placeholder");
        Assert.assertEquals(actualFNameP, "first and middle name as on passport");

        // last name field
        lastName.sendKeys(lName);
        String actualLNameP = lastName.getAttribute("placeholder");
        Assert.assertEquals(actualLNameP, "last name as on passport");

        // gender selection
        int countGender = gender.size();
        System.out.println("Number of gender: " + countGender);

        for(WebElement g : gender) {
            if(g.getAttribute("id").equals("sex_2")) {
                g.click();
                System.out.println("Female is selected: " + g.isSelected());
            }
        }

        dobPax.click();
        selectingPrevMonthYear(mt1, yr1);
        selectingDate(dt1);

        // checkbox more pax
        checkboxMorePax.click();

        // no of more pax
        clickDropDownMorePax.click();

        int listPax = dropdownMorePax.size();
        System.out.println("Total number of options: " + listPax);

        for(WebElement ddMorePax : dropdownMorePax) {
            //System.out.println(ddMorePax.getText());
            String txt = ddMorePax.getText();

            if(txt.equals("add 1 more passenger (100%)")) {
                ddMorePax.click();
                Thread.sleep(3000);
                // System.out.println("add 1 more passenger (100%) is selected");
                travFName.sendKeys(trFName);
                travLName.sendKeys(trLName);

                // dob
                travDOB.click();
                selectingPrevMonthYear(mt2, yr2);
                selectingDate(dt2);

                int cGender = travGender.size();
                System.out.println("Number of gender: " + cGender);

                for(WebElement tGen : travGender) {
                    if(tGen.getAttribute("value").equals("1")) {
                        tGen.click();
                        System.out.println("Male is selected: " + tGen.isSelected());
                    }
                }

                paxType.click();
                for(WebElement lpt: listPaxType) {
                    if(lpt.getText().equals("Infant")) {
                        js.executeScript("arguments[0].click()", lpt);
                    }
                }
                break;
            }
        }
    }

    public void travelDetails(String org, String dest, String dt, String mt, String yr, String info) throws InterruptedException {

        for(WebElement type : tripType) {
            String idType = type.getAttribute("id");
            if(idType.equals("traveltype_1")) {
                if(type.isSelected()){
                    System.out.println("traveltype_1 is selected");
                }
                else if(idType.equals("traveltype_2")) {
                    if(!type.isSelected()) {
                        type.click();
                        System.out.println("traveltype_2 is selected");
                    }
                }
            }
        }

        js.executeScript("arguments[0].setAttribute('value', arguments[1])", origin, org);
        js.executeScript("arguments[0].setAttribute('value', arguments[1])", destination, dest);

        departDate.click();
        selectingFutureMonthYear(mt, yr);
        selectingDate(dt);

        addInfoTrav.sendKeys(info);
    }

    public void deliveryOptions(String dt, String mt, String yr) throws InterruptedException {
        purposeTix.click();
        for(int p = 0; p < listPurposeTix.size(); p++) {
            WebElement purposeOp = listPurposeTix.get(p);
            // String purposeText = purposeOp.getText(); // if want to use based on the text
            // System.out.println("Purpose: " + purposeText);

            if(p == 7) {
                purposeOp.click(); // if want to use index
            }
        }

        js.executeScript("arguments[0].click()", apptDate);
        //selectingFutureMonthYear(mt, yr);
        //selectingDate(dt);

        for(int rTix = 0; rTix < listReceiveTix.size(); rTix++) {
            WebElement listRTix = listReceiveTix.get(rTix);
            if(rTix == 1) {
                listRTix.click();
            }
        }
    }

    // billing details
    public void billingDetails(String billName, String billPhone, String billEmail, String billAdd1, String billAdd2, String billCity, String billPost) throws InterruptedException {
        billingName.sendKeys(billName);
        billingPhone.sendKeys(billPhone);
        billingEmail.sendKeys(billEmail);

        billingCountry.click();
        System.out.println("Total countries: " + listBillingCountry.size());
        for(WebElement listCountry : listBillingCountry) {
            String country = listCountry.getText();
            if(country.equals("Malaysia")) {
                listCountry.click();
                break;
            }
        }

        billingAddress1.sendKeys(billAdd1);
        billingAddress2.sendKeys(billAdd2);
        billingCity.sendKeys(billCity);

        billingState.click();
        System.out.println("Total states: " + listBillingState.size());
        for(WebElement lBillingState : listBillingState) {
            String state = lBillingState.getText();
            if(state.equals("Johor")) {
                lBillingState.click();
                break;
            }
        }

        billingPostcode.sendKeys(billPost);

        if(paymentPaypal.isSelected()) {
            js.executeScript("arguments[0].click()", orderBtn);
        }
        // either one
        else {
            paymentStripe.click();
            js.executeScript("arguments[0].click()", orderBtn);
        }
    }

    public void additionalInformation(String info) {
        addInfo.sendKeys(info);
        String actualAddInfoP = addInfo.getAttribute("placeholder");
        Assert.assertEquals(actualAddInfoP, "Notes about your order, e.g. special notes for delivery.");
    }

}
