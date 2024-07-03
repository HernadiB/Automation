package automationPages.vegasCasinoVipPages;

import automationBase.AutomationThreadLocalFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webTDK.common.helpers.wait.WaitHelpers;
import webTDK.pagefactory.PageBase;

import static webTDK.constants.EnvironmentUrls.VEGASCASINOVIP_URL;

public class VegasCasinoVipLandingPage extends PageBase {
    public VegasCasinoVipLandingPage(){
        super(AutomationThreadLocalFactory.getConnectionInfo());
        initPage(this);
    }

    //region elements

    @FindBy(id = "CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")
    public WebElement acceptCookieButton;

    @FindBy(xpath = "//span[contains(text(), \"Játékok megtekintése\")]")
    public WebElement showGamesButton;

    //endregion

    //region elements functions

    public void clickToAcceptCookieButton(){
        waitUntilWebElementIsClickable(acceptCookieButton);
        acceptCookieButton.click();
    }

    public void clickToShowGamesButton(){
        waitUntilWebElementIsClickable(showGamesButton);
        showGamesButton.click();
        WaitHelpers.delay(3);
    }

    //endregion

    //region other functions

    public void openVegasCasinoVipPage(){
        this.driver.get(VEGASCASINOVIP_URL);
    }

    //endregion
}
