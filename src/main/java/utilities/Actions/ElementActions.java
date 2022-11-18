package utilities.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.exception_handling.ExceptionHandling;
import utilities.test_base.TestBase;
import utilities.waits.Waits;

public class ElementActions {

    public static WebElement findElement(By elementLocator) {
        try {
            Waits.waitForElementToBeVisible(elementLocator);
            Waits.waitForElementToBeClickable(elementLocator);
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
        return TestBase.getDriver().findElement(elementLocator);
    }

    public static void click(By elementLocator) {
        try {
            Waits.waitForElementToBeVisible(elementLocator);
            Waits.waitForElementToBeClickable(elementLocator);
            TestBase.getDriver().findElement(elementLocator).click();
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }

    public static void sendKeys(By elementLocator, String text) {
        try {
            Waits.waitForElementToBeVisible(elementLocator);
            TestBase.getDriver().findElement(elementLocator).sendKeys(text);
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }

    public static void clear(By elementLocator) {
        try {
            Waits.waitForElementToBeVisible(elementLocator);
            TestBase.getDriver().findElement(elementLocator).clear();
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }

    public static void selectByVisibleText(By elementLocator, String visibleText) {
        try {
            Waits.waitForElementToBeVisible(elementLocator);
            new Select(findElement(elementLocator)).selectByVisibleText(visibleText);
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }
}