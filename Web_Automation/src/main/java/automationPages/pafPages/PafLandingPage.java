package automationPages.pafPages;

import automationBase.AutomationThreadLocalFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import webTDK.common.helpers.wait.WaitHelpers;
import webTDK.pagefactory.PageBase;

import java.util.List;

public class PafLandingPage extends PageBase {
    public PafLandingPage(){
        super(AutomationThreadLocalFactory.getConnectionInfo());
        initPage(this);
    }

    //region elements

    /** Casino Slots gomb **/
    @FindBy(xpath = "//h2[text() = \"Casino Slots\"]/following-sibling::a")
    public WebElement casinoSlotsButton;

    /** Összes Slot gomb **/
    @FindBy(xpath = "//h2[text() = \"All Slots\"]/following-sibling::a")
    public WebElement allSlotsButton;

    /** Cookie elfogadás gomb **/
    @FindBy(xpath = "//button[@type = \"button\" and contains(text(), \"Accept all\")]")
    public WebElement acceptCookieButton;

    /** Játékgyártó legördülő lista **/
    @FindBy(xpath = "//button[@type = \"button\" and contains(text(), \"Supplier\")]")
    public WebElement gameManufacturerDropdown;

    /** Összes Játék gomb **/
    @FindBy(xpath = "//button[@type = \"button\" and contains(text(), \"Show More\")]")
    public WebElement allGamesButton;

    //endregion

    //region element function


    //endregion

    /** Casino Slots gomb kattintás **/
    public void clickToCasinoSlotsButton(){
        waitUntilWebElementIsClickable(casinoSlotsButton);
        casinoSlotsButton.click();
    }

    /** Összes Slot gomb kattintás **/
    public void clickToAllSlotsButton(){
        Actions actions = new Actions(driver);
        actions.moveToElement(allSlotsButton);
        actions.perform();
        waitUntilWebElementIsClickable(allSlotsButton);
        allSlotsButton.click();
    }

    /** Cookie elfogadás gomb kattintás **/
    public void clickToAcceptCookieButton(){
        waitUntilWebElementIsClickable(acceptCookieButton);
        acceptCookieButton.click();
    }

    /** Játékgyártó legördülő lista kattintás **/
    public void clickToGameManufacturerDropdown(){
        waitUntilWebElementIsClickable(gameManufacturerDropdown);
        gameManufacturerDropdown.click();
    }

    public void scrollToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        WaitHelpers.delay(2); // Adjust the delay time as needed
    }

    /** Utolsó játékig görgetés **/
    public void scrollToLastElement(){
        /*List<WebElement> listOfGames = driver.findElements(By.xpath("//li[@class = \"css-qdmxni e1kpsuhn1\"]"));
        if (!listOfGames.isEmpty()) {
            WebElement lastElement = listOfGames.get(listOfGames.size() - 1);
            if (!lastElement.isDisplayed()){
                scrollToElement(lastElement);
            } else{
                clickToAllGamesButton();
            }
        } else {
            System.out.println("No elements found");
        }*/

        List<WebElement> listOfElements = driver.findElements(By.xpath("//li[@class = \"css-qdmxni e1kpsuhn1\"]"));
        if (!listOfElements.isEmpty()) {
            WebElement lastElement = listOfElements.get(listOfElements.size() - 1);
            scrollToElement(lastElement);
        } else {
            System.out.println("No elements found.");
        }
    }

    /** Összes játék gomb kattintás **/
    public void handleShowMoreButton() {
        /*List<WebElement> showMoreButtons = driver.findElements(By.xpath("//button[contains(text(),'Show more')]"));
        if (!showMoreButtons.isEmpty()) {
            WebElement showMoreButton = showMoreButtons.get(0); // Assuming there's only one "Show more" button
            if (showMoreButton.isDisplayed()) {
                showMoreButton.click();
                scrollToLastElement();
            }
        } else {
            scrollToGameManufacturerDropdown();
        }*/

        WebElement showMoreButton;
        do {
            showMoreButton = driver.findElement(By.xpath("//button[@type = \"button\" and contains(text(), \"Show More\")]"));
            if (showMoreButton.isDisplayed()) {
                showMoreButton.click();
                scrollToLastElement();
            }
        } while (showMoreButton.isDisplayed());
    }

    /** Játékok száma **/
    public int numberOfGames(){
        WaitHelpers.delay(5);
        List<WebElement> listOfGamesPreview = driver.findElements(By.xpath("//div[@class = \"enp7ohk0 css-1jrdolm e178mt9h0\"]/a"));
        return listOfGamesPreview.size();
    }

    public void scrollToGameManufacturerDropdown(){
        scrollToElement(gameManufacturerDropdown);
        gameManufacturerDropdown.click();
    }

    /** Játékgyártó listaelem kattintás **/
    public void clickToGameManufacturer(){
        WaitHelpers.delay(5);
        clickToGameManufacturerDropdown();
        List<WebElement> listOfManufacturers = driver.findElements(By.xpath("//div[@class = \"enp7ohk0 css-1jrdolm e178mt9h0\"]/a"));
        if (!listOfManufacturers.isEmpty()) {
            for (WebElement element : listOfManufacturers) {
                clickToGameManufacturerDropdown();
                WaitHelpers.delay(5);
                //waitUntilWebElementIsClickable(element);
                element.click();
                //scrollToLastElement();
                //scrollToGameManufacturerDropdown();
                //System.out.println(element.getText() + " number of games: " + numberOfGames());
                //element.click();
            }
        } else {
            System.out.println("No elements found");
        }
    }

    //region other functions

    public void openPafLandingPage(){
        this.driver.get("https://www.paf.se/en");
    }

    //endregion
}
