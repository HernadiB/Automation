package casinoPages.sweden_casino.jallaPages;

import automationBase.AutomationThreadLocalFactory;
import org.openqa.selenium.WebElement;
import io.github.sukgu.Shadow;
import org.openqa.selenium.support.FindBy;
import webTDK.pagefactory.PageBase;

import java.util.List;

import static webTDK.constants.EnvironmentUrls.AUTONORDIC_URL;

public class JallaLandingPage extends PageBase {
    private Shadow shadow;
    public JallaLandingPage(){
        super(AutomationThreadLocalFactory.getConnectionInfo());
        initPage(this);
        shadow = new Shadow(driver);
    }

    //region elements

    @FindBy(xpath = "")
    public WebElement acceptCookieButton;

    @FindBy(css = "site-root_default.hydrated")
    public WebElement shadowHost;

    @FindBy(xpath = ".//div[@class=\"layout\"]")
    public WebElement layoutGameElement;

    @FindBy(xpath = ".//span[@test-id=\"game-overlay-provider-label\"]")
    public WebElement gameProviderElements;

    //endregion

    //region elements functions

    public void clickToAcceptCookieButton(){
        waitUntilWebElementIsClickable(acceptCookieButton);
        acceptCookieButton.click();
    }

    public int countGameProviderElements(){
        List<WebElement> gameProviderElements = shadow.findElements(shadowHost, "span[test-id=\"game-overlay-provider-label\"]");
        return gameProviderElements.size();
    }

    //endregion

    //region other functions

    public void openJallaCasinoPage(){
        this.driver.get(AUTONORDIC_URL);
    }

    //endregion
}
