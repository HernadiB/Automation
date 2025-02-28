package casinoPages.sweden_casino.betfairPages;

import automationBase.AutomationThreadLocalFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webTDK.pagefactory.PageBase;

import static webTDK.constants.EnvironmentUrls.BETFAIRINTERNATIONAL_URL;

public class BetfairLandingPage extends PageBase {
    public BetfairLandingPage(){
        super(AutomationThreadLocalFactory.getConnectionInfo());
        initPage(this);
    }

    //region elements

    @FindBy(xpath = ".//a[@id=\"CASINO\"]")
    private WebElement casinoButton;

    //endregion


    //region element function

    public void clickToCasinoButton(){
        waitUntilWebElementIsClickable(casinoButton);
        casinoButton.click();
    }

    //endregion


    //region other functions

    public void openBetfairLandingPage(){
        this.driver.get(BETFAIRINTERNATIONAL_URL);
    }

    //endregion
}
