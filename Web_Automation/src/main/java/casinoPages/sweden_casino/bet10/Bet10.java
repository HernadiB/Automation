package casinoPages.sweden_casino.bet10;

import automationBase.AutomationThreadLocalFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import webTDK.common.helpers.wait.WaitHelpers;
import webTDK.pagefactory.PageBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static webTDK.constants.EnvironmentUrls.BLUESTARTLIMITED_URL;
import static webTDK.constants.EnvironmentUrls.EXPEKT_URL;

public class Bet10 extends PageBase {
    public Bet10(){
        super(AutomationThreadLocalFactory.getConnectionInfo());
        initPage(this);
    }

    //region elements

    @FindBy(xpath = ".//div[@class=\"MultiSelect__controlWrapper--1xb\"]")
    public WebElement filterButton;

    @FindBy(xpath = ".//label[@class=\"Label__label--1mu Checkbox__label--6Vk\"]")
    public List<WebElement> gameManufacturerDropdownElements;

    @FindBy(xpath = ".//span[@class=\"GameProvider__gameProvider--1Yu  cms-games-grid-game-provider\"]")
    public WebElement gameProvider;

    //endregion

    //region elements functions

    public void clickToFilterButton(){
        waitUntilWebElementIsClickable(filterButton);
        filterButton.click();
    }

    public void scrollToImg() {
        WebElement imgElement = driver.findElement(By.xpath(".//img[@class=\"seo-header-image-desktop\"]"));
        waitUntilWebElementIsVisible(imgElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", imgElement);
        Actions actions = new Actions(driver);
        actions.moveToElement(imgElement);
        actions.perform();
    }

    public void scrollToFilterButton(){
        waitUntilWebElementIsClickable(filterButton);
        WebElement element = driver.findElement(By.xpath(".//div[@class=\"MultiSelect__controlWrapper--1xb\"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    public void scrollToLastElement() {
        int previousNumberOfGames = 0;
        int currentNumberOfGames = 0;

        do {
            previousNumberOfGames = currentNumberOfGames;
            List<WebElement> listOfGames = driver.findElements(By.xpath(".//span[@class=\"GameProvider__gameProvider--1Yu  cms-games-grid-game-provider\"]"));
            currentNumberOfGames = listOfGames.size();

            if (!listOfGames.isEmpty()) {
                WebElement lastElement = listOfGames.get(listOfGames.size() - 1);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lastElement);
                Actions actions = new Actions(driver);
                actions.moveToElement(lastElement);
                actions.perform();
            } else {
                System.out.println("No elements found");
            }

            // Wait for 5 seconds before checking again
            WaitHelpers.delay(5);
        } while (currentNumberOfGames > previousNumberOfGames);
    }

    public int numberOfGames(){
        WaitHelpers.delay(5);
        List<WebElement> listOfGamesPreview = driver.findElements(By.xpath(".//span[@class=\"GameProvider__gameProvider--1Yu  cms-games-grid-game-provider\"]"));
        return listOfGamesPreview.size();
    }

    public void clickFilterAndCountGameProviders() {
        clickToFilterButton();
        // Iterate through each game manufacturer dropdown element
        for (WebElement manufacturer: gameManufacturerDropdownElements) {
            waitUntilWebElementIsClickable(manufacturer);
            manufacturer.click();
            //scrollToImg();
            scrollToLastElement();
            System.out.println(manufacturer.getText() + ": " + numberOfGames());
            scrollToFilterButton();
            manufacturer.click();
        }
    }

    //endregion

    //region other functions

    public void open10BetCasinoPage(){
        this.driver.get(BLUESTARTLIMITED_URL);
    }

    //endregion
}
