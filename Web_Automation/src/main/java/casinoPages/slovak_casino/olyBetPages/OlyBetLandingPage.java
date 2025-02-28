package casinoPages.slovak_casino.olyBetPages;

import automationBase.AutomationThreadLocalFactory;
import jdk.dynalink.linker.LinkerServices;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webTDK.pagefactory.PageBase;


import java.util.List;

import static webTDK.constants.EnvironmentUrls.OLYBET_URL;

public class OlyBetLandingPage extends PageBase {
    public OlyBetLandingPage(){
        super(AutomationThreadLocalFactory.getConnectionInfo());
        initPage(this);
    }

    //region elements

    @FindBy(id = "CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")
    public WebElement acceptCookieButton;

    @FindBy(xpath = ".//div[@data-test=\"tab-searchclick\"]//following-sibling::div//span[text()=\"Filter\"]")
    public WebElement filterButton;

    @FindBy(xpath = ".//div[@data-testid=\"Container\"]//font[text()=\"SLOTS\"]")
    public WebElement slotsButton;

    @FindBy(xpath = "(.//font[text()=\"Suppliers\"]//parent::font//ancestor::div[@data-testid=\"Accordion\"]//font)[position() > 1 and (position() - 1) mod 2 = 0]")
    public List<WebElement> suppliersButtons;

    @FindBy(xpath = ".//div[@class=\"sc-o9wd84-3 sc-hy0pb4-7 biMUPe gkvVSd\"]")
    public WebElement suppliersContainer;

    @FindBy(xpath = ".//a[@data-test=\"tab-navclick\"]")
    public WebElement allGamesButton;

    //endregion

    //region element function

    public void clickToAcceptButton(){
        waitUntilWebElementIsClickable(acceptCookieButton);
        acceptCookieButton.click();
    }

    public void clickToFilterButton(){
        waitUntilWebElementIsClickable(filterButton);
        filterButton.click();
    }

    public void clickToSlotsButton(){
        waitUntilWebElementIsClickable(slotsButton);
        slotsButton.click();
    }

    public void clickToAllGamesButton(){
        waitUntilWebElementIsClickable(allGamesButton);
        allGamesButton.click();
    }

    public void clickAndCountSuppliers() {
        for (WebElement supplierButton : suppliersButtons) {
            waitUntilWebElementIsClickable(supplierButton);
            supplierButton.click();

            // Count the number of suppliersContainer elements
            List<WebElement> containers = driver.findElements(By.xpath(".//div[@class=\"sc-o9wd84-3 sc-hy0pb4-7 biMUPe gkvVSd\"]"));
            System.out.println(supplierButton.getText() + ": " + containers.size() * 2);

            // Click the supplier button again to deselect it
            supplierButton.click();
        }
    }

    //endregion


    //region other functions

    public void openOlyBetLandingPage(){
        this.driver.get(OLYBET_URL);
    }

    //endregion
}
