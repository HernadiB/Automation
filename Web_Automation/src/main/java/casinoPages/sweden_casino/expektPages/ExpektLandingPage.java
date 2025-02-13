package casinoPages.sweden_casino.expektPages;

import automationBase.AutomationThreadLocalFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webTDK.pagefactory.PageBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static webTDK.constants.EnvironmentUrls.EXPEKT_URL;

public class ExpektLandingPage extends PageBase {
    public ExpektLandingPage(){
        super(AutomationThreadLocalFactory.getConnectionInfo());
        initPage(this);
    }

    Map<String, Integer> providerGameCount = new HashMap<>();

    //region elements

    @FindBy(xpath = "//button[@bol-component = \"accept\"]")
    public WebElement acceptCookieButton;

    @FindBy(xpath = "//a/span[text() = \"Casino\"]")
    public WebElement casinoButton;

    @FindBy(xpath = "//a/span[text() = \"Slots\"]")
    public WebElement slotsFilterButton;

    //endregion

    //region elements functions

    public void clickToAcceptCookieButton(){
        waitUntilWebElementIsClickable(acceptCookieButton);
        acceptCookieButton.click();
    }

    public void clickToCasinoButton(){
        waitUntilWebElementIsClickable(casinoButton);
        casinoButton.click();
    }

    public void clickToSlotsFilterButton(){
        waitUntilWebElementIsClickable(slotsFilterButton);
        slotsFilterButton.click();
    }

    public void countGamesPerProviderNumber(){
        List<WebElement> gameElements = driver.findElements(By.cssSelector("div.MuiGrid-root.MuiGrid-item.MuiGrid-grid-xs-4.MuiGrid-grid-lg-2.MuiGrid-grid-xl-2.css-wrp6ly"));

        for (WebElement gameElement : gameElements) {
            WebElement gameNameElement = gameElement.findElement(By.cssSelector("span.MuiTypography-root.MuiTypography-body3.css-atc6sf"));
            WebElement providerNameElement = gameElement.findElement(By.cssSelector("span.MuiTypography-root.MuiTypography-caption.css-tfj8od"));

            String gameName = gameNameElement.getText();
            String providerName = providerNameElement.getText();

            providerGameCount.put(providerName, providerGameCount.getOrDefault(providerName, 0) + 1);
        }
    }

    public void printGamesPerProdiver(){
        countGamesPerProviderNumber();
        for (Map.Entry<String, Integer> entry : providerGameCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }


    //endregion

    //region other functions

    public void openExpektCasinoPage(){
        this.driver.get(EXPEKT_URL);
    }

    //endregion

}
