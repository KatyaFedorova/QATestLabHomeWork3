package myprojects.automation.assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageElementAction {

    public static WebDriver driver;
    private static WebDriverWait wait = new WebDriverWait(driver, 30);

    public static WebElement getElement(String locator) {
        return driver.findElement(By.cssSelector(locator));
    }

    public static void openUrl(String url) {
        driver.get(url);
    }

    public static void click(String locator) {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
        getElement(locator).click();
    }

    public static void hover(String locator) {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
        Actions action = new Actions(driver);
        action.moveToElement(getElement(locator)).build().perform();
    }

    public static void set(String locator, String value) {
        getElement(locator).sendKeys(value);
    }

    public static void verifyElementWithTextPresent(String locator, String text) {
        String elementText = getElement(locator).getText();
        if (!elementText.contains(text)) {
            throw new RuntimeException("Текст \"%s\" не найден");
        }
    }

    public void waitForContentLoad() {
         //wait.until();
    }

}
