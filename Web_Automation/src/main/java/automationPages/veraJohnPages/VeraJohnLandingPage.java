package automationPages.veraJohnPages;

import automationBase.AutomationThreadLocalFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import webTDK.common.helpers.wait.WaitHelpers;
import webTDK.pagefactory.PageBase;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static webTDK.constants.EnvironmentUrls.VERAJOHN_URL;

public class VeraJohnLandingPage extends PageBase {
    public VeraJohnLandingPage(){
        super(AutomationThreadLocalFactory.getConnectionInfo());
        initPage(this);
    }

    //region elements

    /** Játékgyártó lenyíló lista **/
    @FindBy(xpath = "//select[contains(@class, \"provider-dropdown\")]")
    public WebElement gameManufacturerDropdown;

    //endregion

    //region element function


    //endregion

    /** Játékgyártó lenyíló lista kattintás **/
    public void clickToGameManufacturerDropdown(){
        waitUntilWebElementIsClickable(gameManufacturerDropdown);
        gameManufacturerDropdown.click();
    }

    /** Játékgyártó listaelem kattintás **/
    public void clickToGameManufacturer(){
        waitForPageLoad(driver);
        WebElement selectElement = driver.findElement(By.xpath("//select[contains(@class, \"provider-dropdown\")]"));
        Select select = new Select(selectElement);
        List<WebElement> list = select.getOptions();
        for (int i = 2; i < list.size(); i++){
            WebElement option = list.get(i);
            String manufacturerNameAndGameNumber = option.getText();
            Pattern pattern = Pattern.compile("^(.*?)\\s*\\((\\d+)\\)$");
            Matcher matcher = pattern.matcher(manufacturerNameAndGameNumber);
            if (matcher.matches()){
                String manufacturer = matcher.group(1);
                String numberOfGames = matcher.group(2);
                System.out.println(manufacturer + " number of games: " + numberOfGames);
            } else{
                System.out.println("No elements found");
            }
        }
    }

    //region other functions

    public void openVeraJohnLandingPage(){
        this.driver.get(VERAJOHN_URL);
    }

    //endregion
}
