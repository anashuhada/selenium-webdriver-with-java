package MiniProject.DemoQA;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DemoQAInteractionsPages {

    WebDriver driver;
    JavascriptExecutor js;
    Actions act;

    DemoQAInteractionsPages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
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
    @FindBy(xpath = "//a[@id='draggableExample-tab-axisRestriction']") WebElement restrictedAxis;
    @FindBy(xpath = "//div[@id='restrictedX']") WebElement restrictedX;

    public void draggableSimple() throws InterruptedException {
        js.executeScript("arguments[0].click()", draggableMenu);

        act = new Actions(driver);
        Thread.sleep(2000);
        act.clickAndHold(simpleDrag)
                .moveByOffset(200, 50)
                .release()
                .perform();

        System.out.println("Successfully dragged");
    }

    public void draggableAxisRestricted() throws InterruptedException {
        js.executeScript("arguments[0].click()", draggableMenu);
        js.executeScript("arguments[0].click()", restrictedAxis);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(restrictedX));

        Dimension size = restrictedX.getSize();
        Point location = restrictedX.getLocation();
        System.out.println("Element size: " + size);
        System.out.println("Element location: " + location);

        act = new Actions(driver);
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
            System.out.println("Click - list");
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
                    System.out.println("Click - grid");
                    Thread.sleep(2000);
                }
            }
        }
    }
}


