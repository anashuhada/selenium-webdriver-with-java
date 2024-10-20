package MiniProject.DemoQA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoQATest {

    WebDriver driver;
    String webUrl = "https://demoqa.com/elements";

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        System.out.println("Web app started...");
    }

    @Test(priority = 1)
    public void textBox() throws InterruptedException {
        DemoQAElementsPages element = new DemoQAElementsPages(driver);
        driver.get(webUrl);
        element.textBox("Alex Johnson", "alex.johnson@example.com", "123 Elm Street, Apt 4B, Springfield, IL 62704, USA", "789 Maple Avenue, Springfield, IL 62703, USA");
    }

    @Test(priority = 2)
    public void checkBox() throws InterruptedException {
        DemoQAElementsPages element = new DemoQAElementsPages(driver);
        driver.get(webUrl);
        element.checkBox();
    }

    @Test(priority = 3)
    public void radioButton() throws InterruptedException {
        DemoQAElementsPages element = new DemoQAElementsPages(driver);
        driver.get(webUrl);
        element.radioButton();
    }

    @Test(priority = 4)
    public void webTables() {
        DemoQAElementsPages element = new DemoQAElementsPages(driver);
        driver.get(webUrl);
        element.webTables("Sylvia", "Smith", "sylvia@example.com", "35", "15000", "IT", "Sylvia");
    }

    @Test(priority = 5)
    public void buttons() throws InterruptedException {
        DemoQAElementsPages element = new DemoQAElementsPages(driver);
        driver.get(webUrl);
        element.buttons();
    }

    @Test(priority = 6)
    public void links() throws InterruptedException {
        DemoQAElementsPages element = new DemoQAElementsPages(driver);
        driver.get(webUrl);
        element.links();
    }

    @Test(priority = 7)
    public void brokenLinksImages() throws InterruptedException {
        DemoQAElementsPages element = new DemoQAElementsPages(driver);
        driver.get(webUrl);
        element.brokenLinksImages();
    }

    @Test(priority = 8)
    public void uploadAndDownload() throws InterruptedException {
        DemoQAElementsPages element = new DemoQAElementsPages(driver);
        driver.get(webUrl);
        element.uploadAndDownload();
    }

    @Test(priority = 9)
    public void dynamicProperties() throws InterruptedException {
        DemoQAElementsPages element = new DemoQAElementsPages(driver);
        driver.get(webUrl);
        element.dynamicProperties();
    }
                                                                                          
    @Test(priority = 10)
    public void practiceForm() throws InterruptedException {
        DemoQAFormsPages forms = new DemoQAFormsPages(driver);
        driver.get(webUrl);    
        forms.practiceForm("Carissa", "Yeoh", "carissayeoh@example.com", "0123456789", "10", "December", "2023",                                                                                                                                                                                                                                                                                                       "/Volumes/KINGSTON/Downloads/sampleFile.jpeg", "123 Maple Lane Apt 4B Springfield, IL 62704 USA");
    }

    @Test(priority = 11)
    public void browserWindows() throws InterruptedException {
        DemoQAAlertsFrameWindowsPages afw = new DemoQAAlertsFrameWindowsPages(driver);
        driver.get(webUrl);
        afw.browserWindows();
    }

    @Test(priority = 12)
    public void alerts() throws InterruptedException {
        DemoQAAlertsFrameWindowsPages afw = new DemoQAAlertsFrameWindowsPages(driver);
        driver.get(webUrl);
        afw.alerts("Amanda Doe");
    }

    @Test(priority = 13)
    public void frames() throws InterruptedException {
        DemoQAAlertsFrameWindowsPages afw = new DemoQAAlertsFrameWindowsPages(driver);
        driver.get(webUrl);
        afw.frames();
    }

    @Test(priority = 14)
    public void nestedFrames() throws InterruptedException {
        DemoQAAlertsFrameWindowsPages afw = new DemoQAAlertsFrameWindowsPages(driver);
        driver.get(webUrl);
        afw.nestedFrames();
    }

    @Test(priority = 15)
    public void modalDialogs() throws InterruptedException {
        DemoQAAlertsFrameWindowsPages afw = new DemoQAAlertsFrameWindowsPages(driver);
        driver.get(webUrl);
        afw.modalDialogs();
    }

    @Test(priority = 16)
    public void accordian() throws InterruptedException {
        DemoQAWidgetPages widgets = new DemoQAWidgetPages(driver);
        driver.get(webUrl);
        widgets.accordian();
    }

    @Test(priority = 17)
    public void autoComplete() throws InterruptedException {
        DemoQAWidgetPages widgets = new DemoQAWidgetPages(driver);
        driver.get(webUrl);
        widgets.singleAutoComplete();
    }

    @Test(priority = 18)
    public void datePicker() throws InterruptedException {
        DemoQAWidgetPages widgets = new DemoQAWidgetPages(driver);
        driver.get(webUrl);
        widgets.datePicker("1", "January", "2025");
    }

    @Test(priority = 19)
    public void slider() throws InterruptedException {
        DemoQAWidgetPages widgets = new DemoQAWidgetPages(driver);
        driver.get(webUrl);
        widgets.slider();
    }

    @Test(priority = 20)
    public void progressBar() throws InterruptedException {
        DemoQAWidgetPages widgets = new DemoQAWidgetPages(driver);
        driver.get(webUrl);
        widgets.progressBar();
    }

    @Test(priority = 21)
    public void tabs() throws InterruptedException {
        DemoQAWidgetPages widgets = new DemoQAWidgetPages(driver);
        driver.get(webUrl);
        widgets.tabs();
    }

    @Test(priority = 22)
    public void toolTips() throws InterruptedException {
        DemoQAWidgetPages widgets = new DemoQAWidgetPages(driver);
        driver.get(webUrl);
        widgets.toolTips();
    }

    @Test(priority = 23)
    public void menu() {
        DemoQAWidgetPages widgets = new DemoQAWidgetPages(driver);
        driver.get(webUrl);
        widgets.menu();
    }

    @Test(priority = 24)
    public void selectMenu() throws InterruptedException {
        DemoQAWidgetPages widgets = new DemoQAWidgetPages(driver);
        driver.get(webUrl);
        widgets.oldSelectMenu();
        Thread.sleep(3000);
        widgets.standardMenu();
    }

    @Test(priority = 25)
    public void sortable() throws InterruptedException {
        DemoQAInteractionsPages interactions = new DemoQAInteractionsPages(driver);
        driver.get(webUrl);
        interactions.listSortable();
        Thread.sleep(3000);
        interactions.gridSortable();
    }

    @Test(priority = 26)
    public void resizable() throws InterruptedException {
        DemoQAInteractionsPages interactions = new DemoQAInteractionsPages(driver);
        driver.get(webUrl);
        interactions.resizable();
    }

    @Test(priority = 27)
    public void droppable() throws InterruptedException {
        DemoQAInteractionsPages interactions = new DemoQAInteractionsPages(driver);
        driver.get(webUrl);
        interactions.droppableSimple();
        interactions.droppableAccept();
    }

    @Test(priority = 28)
    public void draggable() throws InterruptedException {
        DemoQAInteractionsPages interactions = new DemoQAInteractionsPages(driver);
        driver.get(webUrl);
        interactions.draggableSimple();
        interactions.draggableAxisRestricted();
    }

    @Test(priority = 29)
    public void selectable() throws InterruptedException {
        DemoQAInteractionsPages interactions = new DemoQAInteractionsPages(driver);
        driver.get(webUrl);
        interactions.listSelectable();
        interactions.gridSelectable();
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        System.out.print("Web app closed...");
        driver.quit();
        Thread.sleep(3000);
    }
}