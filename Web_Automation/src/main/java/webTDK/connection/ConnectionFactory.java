package webTDK.connection;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import webTDK.connection.driver.DriverDto;
import webTDK.connection.driver.DriverFactory;

import java.time.Duration;

/**
 * Create or update the connection
 */
public class ConnectionFactory {
    /**
     * Create connection with driver
     * @param driverDto Driver setting
     * @return ConnectionInfo object
     */
    public static ConnectionInfo createConnection(DriverDto driverDto){
        ConnectionInfo connectionInfo = new ConnectionInfo();

        // Create the driver by driverDto setting
        WebDriver driver = DriverFactory.createInstance(driverDto);

        // Set implicit and page load timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(driverDto.getImplicitWait()));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(driverDto.getImplicitWait()));

        connectionInfo.setDriver(driver);

        // Create WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(driverDto.getImplicitWait()));

        connectionInfo.setWait(wait);

        return connectionInfo;
    }
}
