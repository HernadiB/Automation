package test;

import automationBase.AutomationBase;
import automationBase.AutomationThreadLocalFactory;
import automationBase.AutomationUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import webTDK.connection.ConnectionInfo;

import java.time.Duration;

public class TestBase {
    public final static Logger LOG = LoggerFactory.getLogger(TestBase.class);
    protected AutomationUI ui;
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod(alwaysRun = true)
    public void before(){
        AutomationBase.initProps();
        AutomationBase.setDriver();
        ui = AutomationThreadLocalFactory.getUi();
        driver = AutomationThreadLocalFactory.getConnectionInfo().getDriver();
        wait = AutomationThreadLocalFactory.getConnectionInfo().getWait();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod(alwaysRun = true)
    public void after(){
        ConnectionInfo connectionInfo = AutomationThreadLocalFactory.getConnectionInfo();
        if (connectionInfo != null && connectionInfo.getDriver() != null) {
            //connectionInfo.getDriver().quit();
        }
        if (driver != null) {
            //driver.quit();
        }
        AutomationThreadLocalFactory.removeThreadLocalVariables();
    }
}
