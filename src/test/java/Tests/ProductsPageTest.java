package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductsPageTest extends BaseTest {
    @BeforeMethod
    public void pageSetup() {
        driver.navigate().to("https://www.saucedemo.com/");

        String validUseraname = excelReader.getStringData("Sheet1", 1, 0);
        String validPassword = excelReader.getStringData("Sheet1", 1, 1);

        loginPage.inputUsernameField(validUseraname);
        loginPage.inputPasswordField(validPassword);
        loginPage.enterLoginButton();
    }

    public void emptyCart() {
        boolean emptyCart = false;

        try {
            productsPage.cartNumber.isDisplayed();
        }catch (Exception e) {
            emptyCart = true;
        }

        Assert.assertTrue(emptyCart);
    }

    @Test
    public void userCanAddProductToCartWhenClicksAddButton() {
        emptyCart();
        productsPage.clickOnAddButton(0);
        Assert.assertEquals(productsPage.cartNumber.getText(),"1");



    }


    @Test
    public void userCanAddMultipleProducts() {
        emptyCart();
        productsPage.clickOnAddButton(0);
        productsPage.clickOnAddButton(1);
        Assert.assertEquals(productsPage.cartNumber.getText(),"2");


    }

    @Test
    public void userCanRemoveProduct() {
        emptyCart();
        productsPage.clickOnAddButton(0);
        Assert.assertEquals(productsPage.cartNumber.getText(),"1");
        productsPage.clickOnRemoveButton(0);
        emptyCart();



    }


    @Test
    public void userCanSortProducts() {
        String ZtoA = "za";
        String AtoZ = "az";
        String lowToHigh ="lohi";
        String hightoLow ="hilo";
        productsPage.clickOnSortDropdown(lowToHigh);
        Assert.assertTrue(productsPage.sortDropdown.getText().contains("low to high"));

    }

    @Test
    public void userCanOpenSidebarMenu() {
        productsPage.clickOnBurgerMenu();
        Assert.assertTrue(sidebarMenu.logoutButton.isDisplayed());


    }

    @Test
    public void userCanOpetProductPage() {
        productsPage.clickOnProductName("Sauce Labs Backpack");
        Assert.assertTrue(productsPage.backToProductButton.isDisplayed());


    }


}
