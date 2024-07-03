package automationPages.grandCasinoPages;

import automationBase.AutomationThreadLocalFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import webTDK.common.helpers.wait.WaitHelpers;
import webTDK.pagefactory.PageBase;

import java.util.List;

import static webTDK.constants.EnvironmentUrls.GRANDCASINO_URL;

public class GrandCasinoLandingPage extends PageBase {
    public GrandCasinoLandingPage(){
        super(AutomationThreadLocalFactory.getConnectionInfo());
        initPage(this);
    }

    //region elements

    /** Betöltést jelző kép **/
    @FindBy(xpath = "//img[contains(@src, \"/image/preloader.png\")]")
    public WebElement loadingImage;

    /** Cookie elfogadása gomb **/
    @FindBy(xpath = "//button[@class = \"button-close\" and text() = \"OK\"]")
    public WebElement cookieAcceptButton;

    /** Játék menü elem **/
    @FindBy(xpath = "//a[text() = \"Játékok\"]")
    public WebElement gamesNavItem;

    /** Játékgyártó lenyíló lista **/
    @FindBy(xpath = "//button[@type = \"button\" and @data-menu-target = \"navbarProviderNav\"]")
    public WebElement gameManufacturerDropdown;

    /** Játékgyártó listaelemek **/
    @FindBy(xpath = "//div[@id = \"navbarProviderNav\"]/a")
    public WebElement gameManufacturer;

    /** Játékgyártó neve **/
    @FindBy(xpath = "//div[@id = \"navbarProviderNav\"]/a[contains(@class, \"active\")]")
    public WebElement gameManufacturerName;

    /** Játékok előképe **/
    @FindBy(xpath = "//div[contains(@class, \"m-game-grid-item column\")]")
    public List<WebElement> gamesPreview;

    /** Összes játék gomb **/
    @FindBy(xpath = "//button/p[text() = \"Összes Játék\"]/parent::*")
    public WebElement allGamesButton;

    @FindBy(xpath = "//div[@id = \"game-grid\"]")
    public WebElement allGameList;

    //endregion

    //region element function


    /** Cookie elfogadás gomb kattintás **/
    public void clickToCookieAcceptButton(){
        waitUntilWebElementIsClickable(cookieAcceptButton);
        cookieAcceptButton.click();
    }

    /** Játékok menü elem kattintás **/
    public void clickToGamesNavItem(){
        waitUntilWebElementIsClickable(gamesNavItem);
        gamesNavItem.click();
    }

    /** Játékgyártó lenyíló lista kattintás **/
    public void clickToGameManufacturerDropdown(){
        waitUntilWebElementIsClickable(gameManufacturerDropdown);
        gameManufacturerDropdown.click();
    }

    /** Összes játék gomb kattintás **/
    public void clickToAllGamesButton(){
        waitUntilWebElementIsClickable(allGamesButton);
        WebElement element = driver.findElement(By.xpath("//button/p[text() = \"Összes Játék\"]/parent::*"));

        // Moves the mouse to the middle of the element
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();

        // Apparently scrolls there
        /*JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);*/

        // The framework implemented version
        //PresenceHelpers.scrollToElement(driver, element, 1000, 1000);

        allGamesButton.click();
    }

    /** Játékok száma **/
    public int numberOfGames(){
        WaitHelpers.delay(5);
        List<WebElement> listOfGamesPreview = driver.findElements(By.xpath("//div[contains(@class, \"m-game-grid-item column\")]"));
        return listOfGamesPreview.size();
    }

    /** Utolsó játékig görgetés **/
    public void scrollToLastElement(){
        List<WebElement> listOfGames = driver.findElements(By.xpath("//div[contains(@class, \"m-game-grid-item column\")]"));
        if (!listOfGames.isEmpty()) {
            WebElement lastElement = listOfGames.get(listOfGames.size() - 1);
            Actions actions = new Actions(driver);
            actions.moveToElement(lastElement);
            actions.perform();
            clickToAllGamesButton();
        } else {
            System.out.println("No elements found");
        }
    }

    /** Játékgyártó dropdownig vissza görgetés **/
    public void scrollToGameManufacturerDropdown(){
        waitUntilWebElementIsClickable(gameManufacturerDropdown);
        WebElement element = driver.findElement(By.xpath("//button[@type = \"button\" and @data-menu-target = \"navbarProviderNav\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        gameManufacturerDropdown.click();
    }

    /** Játékgyártó listaelem kattintás **/
    public void clickToGameManufacturer(){
        WaitHelpers.delay(5);
        waitUntilWebElementIsClickable(gameManufacturerDropdown);
        List<WebElement> listOfManufacturers = driver.findElements(By.xpath("//div[@id = \"navbarProviderNav\"]/a"));
        if (!listOfManufacturers.isEmpty()) {
            for (int i = 1; i < listOfManufacturers.size(); i++) {
                WebElement element = listOfManufacturers.get(i);
                gameManufacturerDropdown.click();
                waitUntilWebElementIsClickable(element);
                element.click();
                scrollToLastElement();
                scrollToGameManufacturerDropdown();
                System.out.println(element.getText() + " number of games: " + numberOfGames());
                element.click();
            }
        } else {
            System.out.println("No elements found");
        }
    }

    //endregion

    //region other functions

    public void openGrandCasinoLandingPage(){
        this.driver.get(GRANDCASINO_URL);
    }

    //endregion
}
