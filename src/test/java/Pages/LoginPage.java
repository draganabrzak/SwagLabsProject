package Pages;

import Base.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.Key;

import static Base.BaseTest.driver;

public class LoginPage extends BaseTest {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    @FindBy(className = "error-button")
    public WebElement errorMessage;


    //---------------------------------

    public void inputUsernameField(String username){
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void inputPasswordField(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public void enterLoginButton() {
        loginButton.sendKeys(Keys.ENTER);
    }

}
