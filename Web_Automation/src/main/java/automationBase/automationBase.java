package automationBase;

import webTDK.connection.ConnectionFactory;
import webTDK.connection.ConnectionInfo;
import webTDK.connection.driver.DriverDto;

import java.io.IOException;
import java.util.Properties;

/** Base class to start driver with parameters and other movement **/
public class AutomationBase {
    /**
     * Read the runtime properties. Browser type, browser version and etc...
     */
    public static void initProps(){
        Properties runtimeProps = new Properties();
        try {
            //Load the prop file
            runtimeProps.load(AutomationBase.class.getClassLoader().getResourceAsStream("runtime.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load props: " + e);
        }
        //Set properties to thread local variable
        AutomationThreadLocalFactory.setRuntimeProps(runtimeProps);
    }

    /**
     * Set up driver dto by runtime props
     * Create the connection with the driver
     */
    public static void setDriver(){
        Properties runtimeProps = AutomationThreadLocalFactory.getRuntimeProps();
        DriverDto driverDto = new DriverDto();
        driverDto.setBrowserType(runtimeProps.getProperty("browserType").toLowerCase())
                .setBrowserVersion(runtimeProps.getProperty("browserVersion").toLowerCase())
                .setImplicitWait(30)
                .setIsRemote(Boolean.parseBoolean(runtimeProps.getProperty("isRemote")))
                .setE23Token(runtimeProps.getProperty("e34Token"));

        ConnectionInfo connectionInfo;
        connectionInfo = ConnectionFactory.createConnection(driverDto);

        //TODO: testEnvironmentType-ra hibát dob
        //connectionInfo.setBaseUrls(UrlHelper.getAllBaseUrlsByEnvironmentType(runtimeProps.getProperty("testEnvironmentType")));

        AutomationThreadLocalFactory.setConnectionInfo(connectionInfo);
        initUI();
    }

    /**
     * Create the ApplicationUI class and set to thread local variable
     */
    public static void initUI(){
        AutomationUI fEUi = new AutomationUI();
        AutomationThreadLocalFactory.setUi(fEUi);
    }

    /**
     * Quit driver
     */
    public static void quitDriver(){
        AutomationThreadLocalFactory.getConnectionInfo().getDriver().quit();
    }
}
