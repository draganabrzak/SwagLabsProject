package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @BeforeMethod
    public void pageSetup() {
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @Test
    public void userCanLoginWithValidCredentials() throws InterruptedException {

        for (int i = 1; i <= excelReader.getLastRow("Sheet1"); i++) {
            String validUseraname = excelReader.getStringData("Sheet1", i, 0);
            String validPassword = excelReader.getStringData("Sheet1", 1, 1);


            loginPage.inputUsernameField(validUseraname);
            loginPage.inputPasswordField(validPassword);
            loginPage.clickOnLoginButton();
            Thread.sleep(2000);
            Assert.assertTrue(productsPage.burgerMenu.isDisplayed());
            productsPage.clickOnBurgerMenu();
            sidebarMenu.clickOnLogoutButton();

        }


    }

    @Test
    public void userCanNotLoginWithInvalidCredentials() {
        for (int i = 1; i <= excelReader.getLastRow("Sheet1"); i++) {
            String invalidUseraname = excelReader.getStringData("Sheet1", i, 2);
            String invalidPassword = excelReader.getStringData("Sheet1", i, 3);


            loginPage.inputUsernameField(invalidUseraname);
            loginPage.inputPasswordField(invalidPassword);
            loginPage.clickOnLoginButton();
            Assert.assertTrue(loginPage.errorMessage.isDisplayed());

        }

    }

    @Test
    public void userCanNotLoginWithInavlidUseranmeAndValidPassword() {
        for (int i = 1; i <= excelReader.getLastRow("Sheet1"); i++) {
            String invalidUseraname = excelReader.getStringData("Sheet1", i, 2);
            String validPassword = excelReader.getStringData("Sheet1", 1, 1);


            loginPage.inputUsernameField(invalidUseraname);
            loginPage.inputPasswordField(validPassword);
            loginPage.clickOnLoginButton();
            Assert.assertTrue(loginPage.errorMessage.isDisplayed());

        }

    }

    @Test
    public void userCanNotLoginWithValidUsernameandInvalidPassword() {
        for (int i = 1; i < excelReader.getLastRow("Sheet1"); i++) {
            String validUseraname = excelReader.getStringData("Sheet1", i, 0);
            String invalidPassword = excelReader.getStringData("Sheet1", i, 3);


            loginPage.inputUsernameField(validUseraname);
            loginPage.inputPasswordField(invalidPassword);
            loginPage.clickOnLoginButton();
            Assert.assertTrue(loginPage.errorMessage.isDisplayed());

        }

    }

    @Test
    public void userCanNotLoginWithBlankUseraname() {
        String validPassword = excelReader.getStringData("Sheet1", 1, 1);

        loginPage.usernameField.clear();
        loginPage.inputPasswordField(validPassword);
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());


    }

    @Test
    public void userCanNotLoginWithBlankPassword() {
        String validUseraname = excelReader.getStringData("Sheet1", 1, 0);

        loginPage.inputUsernameField(validUseraname);
        loginPage.passwordField.clear();
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());


    }

    @Test
    public void userCanLoginUsingEnterButton() throws InterruptedException {
        String validUseraname = excelReader.getStringData("Sheet1", 1, 0);
        String validPassword = excelReader.getStringData("Sheet1", 1, 1);


        loginPage.inputUsernameField(validUseraname);
        loginPage.inputPasswordField(validPassword);
        loginPage.enterLoginButton();
        Thread.sleep(2000);
        Assert.assertTrue(productsPage.burgerMenu.isDisplayed());


    }

    @Test
    public void userCanLogOut() throws InterruptedException {
        String validUseraname = excelReader.getStringData("Sheet1", 1, 0);
        String validPassword = excelReader.getStringData("Sheet1", 1, 1);

        loginPage.inputUsernameField(validUseraname);
        loginPage.inputPasswordField(validPassword);
        loginPage.enterLoginButton();
        Thread.sleep(2000);
        Assert.assertTrue(productsPage.burgerMenu.isDisplayed());
        productsPage.clickOnBurgerMenu();
        sidebarMenu.clickOnLogoutButton();
        Assert.assertTrue(loginPage.loginButton.isDisplayed());


    }


}
