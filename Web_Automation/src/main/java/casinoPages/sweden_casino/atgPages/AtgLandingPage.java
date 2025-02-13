package casinoPages.sweden_casino.atgPages;

import automationBase.AutomationThreadLocalFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webTDK.common.helpers.wait.WaitHelpers;
import webTDK.pagefactory.PageBase;

import java.util.List;

import static webTDK.common.helpers.wait.WaitHelpers.withCustomImplicitWait;
import static webTDK.constants.EnvironmentUrls.TRAVANDGALOPP_URL;

public class AtgLandingPage extends PageBase {
    public AtgLandingPage() {
        super(AutomationThreadLocalFactory.getConnectionInfo());
        initPage(this);
    }

    //region elements

    @FindBy(xpath = ".//button[@data-test-id=\"acceptAllCookiesBtn\"]")
    public WebElement acceptAllCookiesButton;

    @FindBy(xpath = ".//div[@data-test-id=\"casino-collections-container\"]//p[contains(@class, \"Title\")]")
    public List<WebElement> manufacturerNameElements;

    @FindBy(xpath = ".//div[@data-test-id=\"casino-collections-container\"]//p[contains(@class, \"CTA\")]")
    public List<WebElement> gameNumberByManufacturerElements;

    //endregion

    //region elements functions

    public void clickToAcceptAllCookiesButton() {
        waitUntilWebElementIsClickable(acceptAllCookiesButton);
        acceptAllCookiesButton.click();
    }

    public void printManufacturerNamesAndGameNumbers() {
        waitForPageLoad(this.driver);
        waitUntilWebElementIsClickable(gameNumberByManufacturerElements.get(1));

        for (int i = 0; i < manufacturerNameElements.size(); i++) {
            String manufacturerName = manufacturerNameElements.get(i).getText();
            if (manufacturerName.contains("SPEL FRÅN")) {
                manufacturerName = manufacturerName.replace("SPEL FRÅN", "").trim();
            }
            String gameNumber = gameNumberByManufacturerElements.get(i).getText();
            String[] gameNumberParts = gameNumber.split(" ");
            String gameNumberPart = gameNumberParts.length > 0 ? gameNumberParts[0] : "";
            System.out.println(manufacturerName + ": " + gameNumberPart);
        }
    }


    //endregion

    //region other functions

    public void openAtgCasinoPage() {
        this.driver.get(TRAVANDGALOPP_URL);
    }

    //endregion
}
