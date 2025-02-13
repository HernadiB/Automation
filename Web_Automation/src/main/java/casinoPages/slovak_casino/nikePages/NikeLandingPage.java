package casinoPages.slovak_casino.nikePages;

import automationBase.AutomationThreadLocalFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import webTDK.pagefactory.PageBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static webTDK.constants.EnvironmentUrls.NIKE_URL;

public class NikeLandingPage extends PageBase {
    public NikeLandingPage(){
        super(AutomationThreadLocalFactory.getConnectionInfo());
        initPage(this);
    }

    Map<String, Integer> result = new HashMap<>();

    //region elements

    /** Játékszolgáltatók lista **/
    @FindBy(xpath = ".//nav[@class = \"flex flex-col\"]/a/span[@class = \"text-bold ellipsis\"]")
    public List<WebElement> gameManufacturerElements;

    /** Játékok elem **/
    @FindBy(xpath = ".//div[contains(@class, 'casino-game-img')]")
    public List<WebElement> gamesElements;

    /** Cookie elfogadás gomb **/
    @FindBy(id = "CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")
    public WebElement acceptCookieButton;

    //endregion

    //region element functions

    public void clickToAcceptCookieButton(){
        waitUntilWebElementIsClickable(acceptCookieButton);
        acceptCookieButton.click();
    }

    public void getGamesPerProvider(){
        for (WebElement manufacturer : gameManufacturerElements) {
            String providerName = manufacturer.getText();
            Actions actions = new Actions(driver);
            actions.moveToElement(manufacturer).perform();
            waitUntilWebElementIsClickable(manufacturer);
            manufacturer.click();
            waitForPageLoad(this.driver);
            int gamesNumber = gamesElements.size();
            result.put(providerName, gamesNumber);
        }

        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    //endregion

    //region other functions

    public void openNikeLandingPage(){
        this.driver.get(NIKE_URL);
    }

    //endregion
}
