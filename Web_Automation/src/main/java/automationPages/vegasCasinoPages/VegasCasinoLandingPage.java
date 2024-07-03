package automationPages.vegasCasinoPages;

import automationBase.AutomationThreadLocalFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import webTDK.pagefactory.PageBase;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static webTDK.constants.EnvironmentUrls.VEGASCASINO_URL;

public class VegasCasinoLandingPage extends PageBase {
    public VegasCasinoLandingPage(){
        super(AutomationThreadLocalFactory.getConnectionInfo());
        initPage(this);
    }

    //region elements

    @FindBy(id = "CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")
    public WebElement acceptCookieButton;

    //endregion

    //region elements functions

    public void clickToAcceptCookieButton(){
        waitUntilWebElementIsClickable(acceptCookieButton);
        acceptCookieButton.click();
    }

    public void navigateToProviders(){
        this.driver.navigate().to("https://vegas.hu/providers");
    }

    public void getGameProviderAndNumber(){
        List<WebElement> providers = driver.findElements(By.cssSelector(".image-content-title"));
        List<WebElement> gameNumbers = driver.findElements(By.cssSelector(".image-content-details"));

        if (providers.size() == gameNumbers.size()) {
            for (int i = 0; i < providers.size(); i++) {
                String providerName = providers.get(i).getText();
                String gamesCount = gameNumbers.get(i).getText();
                System.out.println(providerName + ": " + gamesCount);
            }
        } else {
            System.out.println("The number of providers and game numbers do not match.");
        }
    }

    //endregion

    //region other functions

    public void openVegasCasinoPage(){
        this.driver.get(VEGASCASINO_URL);
    }

    //endregion

}
