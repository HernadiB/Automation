package casinoPages.sweden_casino.hajperPages;

import automationBase.AutomationThreadLocalFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webTDK.pagefactory.PageBase;

import java.util.List;
import java.util.Map;

import static webTDK.constants.EnvironmentUrls.HAJPER_URL;

public class HajperLandingPage extends PageBase {
    public HajperLandingPage(){
        super(AutomationThreadLocalFactory.getConnectionInfo());
        initPage(this);
    }

    //region elements

    @FindBy(xpath = "//a[@onclick = \"cookieConsent();\"]")
    public WebElement acceptCookieButton;

    //endregion

    //region elements functions

    public void clickToAcceptCookieButton(){
        waitUntilWebElementIsClickable(acceptCookieButton);
        acceptCookieButton.click();
    }

    //endregion

    //region other functions

    public void openHajperCasinoPage(){
        this.driver.get(HAJPER_URL);
    }

    //endregion
}
