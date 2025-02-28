package casinoPages.sweden_casino.lyckostPages;

import automationBase.AutomationThreadLocalFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webTDK.pagefactory.PageBase;

import static webTDK.constants.EnvironmentUrls.LYCKOST_URL;
import static webTDK.constants.EnvironmentUrls.PAF_URL;

public class LyckostLandingPage extends PageBase {
    public LyckostLandingPage(){
        super(AutomationThreadLocalFactory.getConnectionInfo());
        initPage(this);
    }

    //region elements

    @FindBy(xpath = ".//a[@class=\"highlight__cta\"]")
    public WebElement acceptButton;

    @FindBy(xpath = ".//font[text()=\"Casino\"]")
    public WebElement casinoButton;

    //endregion

    //region element function

    public void clickToAcceptButton(){
        waitUntilWebElementIsClickable(acceptButton);
        this.acceptButton.click();
    }

    public void clickToCasinoButton(){
        waitUntilWebElementIsClickable(casinoButton);
        this.casinoButton.click();
    }

    //endregion

    //region other functions

    public void openLyckostLandingPage(){
        this.driver.get(LYCKOST_URL);
    }

    //endregion
}
