package utilities;

import org.junit.After;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertTrue;
import static utilities.Driver.getDriver;

public class ReusableMethods {
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        getDriver().quit();
    }
    public static void wait(int seconds){
        try{
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    public static WebElement waitForElementToBeClickable(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static WebElement waitForVisibility(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void clickIfVisible(WebElement element, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutSeconds));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (ElementNotInteractableException e) {
            System.out.println("Element etkileşimde değil, görünür olmayabilir: " + e.getMessage());
        } catch (TimeoutException e) {
            System.out.println("Element zamanında tıklanabilir olmadı: " + e.getMessage());
        }
    }
    public static void scrollToElementInVisible(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript(
                "arguments[0].scrollIntoView(true);",element);
    }
    public static void moveToElement(WebElement element){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).perform();
    }
}
