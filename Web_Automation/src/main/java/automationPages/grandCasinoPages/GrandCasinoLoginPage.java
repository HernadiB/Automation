package automationPages.grandCasinoPages;

import automationBase.automationThreadLocalFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webTDK.common.helpers.PresenceHelpers;
import webTDK.common.helpers.wait.WaitConditions;
import webTDK.common.helpers.wait.WaitHelpers;
import webTDK.pagefactory.PageBase;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class GrandCasinoLoginPage extends PageBase {
    public GrandCasinoLoginPage(){
        super(automationThreadLocalFactory.getConnectionInfo());
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
    @FindBy(xpath = "//div[contains(text(), \"Játékgyártó\")]")
    public WebElement gameManufacturerDropdown;

    /** Amatic listaelem **/
    @FindBy(xpath = "//a[contains(text(), \"Amatic\")]")
    public WebElement amaticManufacturer;

    /** Játékok előképe **/
    @FindBy(xpath = "//div[contains(@class, \"m-game-grid-item column\")]")
    public List<WebElement> gamesPreview;

    /** Összes játék gomb **/
    @FindBy(xpath = "//button/p[text() = \"Összes Játék\"]/parent::*")
    public WebElement allGamesButton;

    //endregion

    //region element function

    /** Cookie elfogadás gomb kattintás **/
    public void clickToCookieAcceptButton(){
        waitUntilWebElementIsClickable(cookieAcceptButton);
        cookieAcceptButton.click();
    }

    /** Játékok menü elem kattintás **/
    public void clickToGamesNavItem(){
        gamesNavItem.click();
    }

    /** Játékgyártó lenyíló lista kattintás **/
    public void clickToGameManufacturerDropdown(){
        gameManufacturerDropdown.click();
    }

    /** Amatic listaelem kattintás **/
    public void clickToAmaticManufacturer(){
        amaticManufacturer.click();
    }

    /** Összes játék gomb kattintás **/
    public void clickToAllGamesButton(){
        WaitHelpers.delay(5);
        WebElement target = driver.findElement(By.xpath("//button/p[text() = \"Összes Játék\"]/parent::*"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", target);
        target.click();
    }

    public void numberOfGames(){
        WaitHelpers.delay(5);
        List<WebElement> listOfGamesPreview = driver.findElements(By.xpath("//div[contains(@class, \"m-game-grid-item column\")]"));
        System.out.println("Amatic játékok száma: " + listOfGamesPreview.size());
    }

    //endregion

    //region other functions

    public void openGrandCasinoLoginPage(){
        this.driver.get("https://grandcasino.hu/hu-hu/");
    }
}
