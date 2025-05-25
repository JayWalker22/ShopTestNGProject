package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class N11_page {
    public N11_page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (id = "myLocation-close-info")
    public WebElement info;
    @FindBy (className = "btnSignIn")
    public WebElement girisYapButton;
    @FindBy (xpath = "//input[@id='email']")
    public WebElement email;
    @FindBy (xpath = "//input[@id='password']")
    public WebElement password;
    @FindBy (id = "loginButton")
    public WebElement loginButton;
    @FindBy (xpath = "//a[@title='Hesabım']")
    public WebElement myAccount;
    @FindBy (id = "searchData")
    public WebElement searchBox;
    @FindBy (xpath = "(//span[@class='btnBasket'])[1]")
    public WebElement plusButton;
    @FindBy (xpath = "//span[text()='1']")
    public WebElement basket;
    @FindBy (className = "logoutBtn")
    public WebElement logoutButton;
}
