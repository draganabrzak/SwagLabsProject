package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {
    @BeforeMethod
    public void pageSetup() {
        driver.navigate().to("https://www.saucedemo.com/");

        String validUseraname = excelReader.getStringData("Sheet1", 1, 0);
        String validPassword = excelReader.getStringData("Sheet1", 1, 1);

        loginPage.inputUsernameField(validUseraname);
        loginPage.inputPasswordField(validPassword);
        loginPage.enterLoginButton();
    }

    @Test
    public void cartOpenWhenClickCartIcon() {
        cartPage.clickOnCartIcon();
        Assert.assertTrue(cartPage.continueShoppingButton.isDisplayed());

    }

    @Test
    public void userCanComeBackFromCartToProductsPage() {
        cartPage.clickOnCartIcon();
        cartPage.clickOnContinueShoppingButton();
        Assert.assertTrue(productsPage.burgerMenu.isDisplayed());

    }

    @Test
    public void userCanRemoveProductFromCart() {
        productsPage.emptyCart();
        productsPage.clickOnAddButton(0);
        cartPage.clickOnCartIcon();
        productsPage.clickOnRemoveButton(0);

    }

    @Test
    public void userCanClickCheckoutButton() {
        cartPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        Assert.assertTrue(informationForm.continueButton.isDisplayed());


    }
}
