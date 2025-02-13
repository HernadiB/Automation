package casinoPages.sweden_casino.swedenLimitedPages;

import automationBase.AutomationThreadLocalFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import webTDK.pagefactory.PageBase;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static webTDK.constants.EnvironmentUrls.SWEDENLIMITED_URL;
import static webTDK.constants.EnvironmentUrls.VERAJOHN_URL;

public class SwedenLimitedLandingPage extends PageBase {
    public SwedenLimitedLandingPage(){
        super(AutomationThreadLocalFactory.getConnectionInfo());
        initPage(this);
    }

    //region elements

    /** Szűrő gomb **/
    @FindBy(xpath = ".//a[contains(@class, \"cy-open-filters-button\")]")
    public WebElement filterButton;

    /** Játékgyártó szűrő gomb **/
    @FindBy(xpath = ".//div[text()=\"Spelstudior\"]")
    public WebElement gameManufacturerFilterButton;

    /** Játékgyártó lista és játékszám **/
    @FindBy(xpath = ".//span[@class=\"sc-jGHpYF gThgUN\"]")
    public List<WebElement> gameManufacturersAndGameNumbers;

    //endregion

    /** Szűrő gomb kattintás **/
    public void clickToFilterButton(){
        waitUntilWebElementIsClickable(filterButton);
        filterButton.click();
    }

    /** Játékgyártó szűrő kattintás **/
    public void clickToGameManufacturerFilterButton(){
        waitUntilWebElementIsClickable(gameManufacturerFilterButton);
        gameManufacturerFilterButton.click();
    }

    public void printManufacturerNamesAndGameNumbers() {
        waitUntilWebElementIsClickable(gameManufacturersAndGameNumbers.get(1));
        for (int i = 0; i < gameManufacturersAndGameNumbers.size(); i++) {
            String gameManufacturer = gameManufacturersAndGameNumbers.get(i).getText();
            //String[] gameManufacturerParts = gameManufacturer.split(" ");
            //String gameManufacturerPart = gameManufacturerParts.length > 0 ? gameManufacturerParts[0] : "";
            System.out.println(gameManufacturer);
        }
    }

    //region element function


    //endregion

    //region other functions

    public void openSwedenLimitedLandingPage(){
        this.driver.get(SWEDENLIMITED_URL);
    }

    //endregion
}
