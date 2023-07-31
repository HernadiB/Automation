package automationBase;

import webTDK.connection.ConnectionFactory;
import webTDK.connection.ConnectionInfo;
import webTDK.connection.driver.DriverDto;
import webTDK.testEnvironment.UrlHelper;

import java.io.IOException;
import java.util.Properties;

/** Base class to start driver with parameters and other movement **/
public class automationBase {
    /**
     * Read the runtime properties. Browser type, browser version and etc...
     */
    public static void initProps(){
        Properties runtimeProps = new Properties();
        try {
            //Load the prop file
            runtimeProps.load(automationBase.class.getClassLoader().getResourceAsStream("runtime.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load props: " + e);
        }
        //Set properties to thread local variable
        automationThreadLocalFactory.setRuntimeProps(runtimeProps);
    }

    /**
     * Set up driver dto by runtime props
     * Create the connection with the driver
     */
    public static void setDriver(){
        Properties runtimeProps = automationThreadLocalFactory.getRuntimeProps();
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

        automationThreadLocalFactory.setConnectionInfo(connectionInfo);
        initUI();
    }

    /**
     * Create the ApplicationUI class and set to thread local variable
     */
    public static void initUI(){
        automationUI fEUi = new automationUI();
        automationThreadLocalFactory.setUi(fEUi);
    }

    /**
     * Quit driver
     */
    public static void quitDriver(){
        automationThreadLocalFactory.getConnectionInfo().getDriver().quit();
    }
}
