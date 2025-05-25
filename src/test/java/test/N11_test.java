package test;

import org.openqa.selenium.Keys;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import page.N11_page;
import utilities.ConfigurationReader;
import utilities.ReusableMethods;

import java.time.Duration;

import static utilities.Driver.getDriver;
import static utilities.Driver.quitDriver;

public class N11_test {
    N11_page page = new N11_page();
    SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public void setup(){
        getDriver().get(ConfigurationReader.getProperty("n11"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ReusableMethods.clickIfVisible(page.info, 10);
    }
    @Test(priority = 1)
    public void login(){
        page.girisYapButton.click();
        page.email.sendKeys(ConfigurationReader.getProperty("email"));
        page.password.sendKeys(ConfigurationReader.getProperty("pw"));
        page.loginButton.click();
        ReusableMethods.waitForVisibility(page.myAccount,10);
        String actualMessage = page.myAccount.getText();
        String expectedMessage = "RT";
        softAssert.assertEquals(actualMessage,expectedMessage);

    }
    @Test(priority = 2)
    public void searchElement() {
        ReusableMethods.waitForVisibility(page.searchBox,10);
        page.searchBox.sendKeys("IPhone", Keys.ENTER);
        ReusableMethods.scrollToElementInVisible(page.plusButton);
        ReusableMethods.waitForElementToBeClickable(page.plusButton,10);
        page.plusButton.click();
        String actualText = page.basket.getText();
        String expectedText = "1";
        softAssert.assertEquals(actualText,expectedText);
        softAssert.assertAll();
    }
    @Test(priority = 3)
    public void logout(){
        ReusableMethods.moveToElement(page.myAccount);
        page.logoutButton.click();
    }
    @AfterClass
    public void tearDown() {
        quitDriver();
    }
}
