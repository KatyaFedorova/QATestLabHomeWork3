package myprojects.automation.assignment3;

import myprojects.automation.assignment3.utils.EventHandler;
import myprojects.automation.assignment3.utils.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

public abstract class BaseScript extends EventHandler {

    private static WebDriver getDriver() {
        String driverName = Properties.getBrowser();
        WebDriver driver;
        String propertyName;
        String path;
        switch (driverName) {
        case "firefox": propertyName = "gecko";
            path = "geckodriver";
            driver = new FirefoxDriver(); break;
        case "chrome": propertyName = "chrome";
            path = "chromedriver.exe";
            driver = new ChromeDriver(); break;
        case "internet explorer": propertyName = "ie";
            path = "IEDriverServer.exe";
            driver = new InternetExplorerDriver(); break;
        default: propertyName = "chrome";
            path = "chromedriver.exe";
            driver = new ChromeDriver();
        }

        System.setProperty(String.format("webdriver.%s.driver", propertyName), new File(BaseScript.class.getResource("/" + path).
                getFile()).getPath());
        PageElementAction.wait = new WebDriverWait(driver, 30);
        return driver;
    }

    public static void setConfiguredDriver() {
        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(getDriver());
        eventFiringWebDriver.register(new EventHandler());

        eventFiringWebDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        eventFiringWebDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        eventFiringWebDriver.manage().window().maximize();
        PageElementAction.driver = eventFiringWebDriver;
    }
}
