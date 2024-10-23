package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
    @BeforeMethod
    public void pageSetup() {
        driver.navigate().to("https://www.saucedemo.com/");

        String validUseraname = excelReader.getStringData("Sheet1", 1, 0);
        String validPassword = excelReader.getStringData("Sheet1", 1, 1);

        loginPage.inputUsernameField(validUseraname);
        loginPage.inputPasswordField(validPassword);
        loginPage.enterLoginButton();
        cartPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
    }

    String firstName = "Johan";
    String lastName = "Breadfor";
    String zipCode = "70919";

    @Test
    public void userCanByProductWhenInputsAllField() {
        informationForm.inputFirstName(firstName);
        informationForm.inputLastName(lastName);
        informationForm.inpuZipCode(zipCode);
        informationForm.clickOnContinueButton();
        Assert.assertTrue(overViewPage.finishButton.isDisplayed());


    }

    @Test
    public void userCanNotByProductWhenFirstNameFieldIsEmpty() {
        informationForm.firstNameField.clear();
        informationForm.inputLastName(lastName);
        informationForm.inpuZipCode(zipCode);
        informationForm.clickOnContinueButton();
        Assert.assertTrue(informationForm.continueButton.isDisplayed());

    }

    @Test
    public void userCanNotByProductWhenLastNameFieldIsEmpty() {
        informationForm.inputFirstName(firstName);
        informationForm.lastNameField.clear();
        informationForm.inpuZipCode(zipCode);
        informationForm.clickOnContinueButton();
        Assert.assertTrue(informationForm.continueButton.isDisplayed());

    }

    @Test
    public void userCanNotByProductWhenZipCodeIsFieldIsEmpty() {
        informationForm.inputFirstName(firstName);
        informationForm.inputLastName(lastName);
        informationForm.zipCodField.clear();
        informationForm.clickOnContinueButton();
        Assert.assertTrue(informationForm.continueButton.isDisplayed());


    }

    @Test
    public void userCanNotByProductWhenAllFieldAreIsFielEmpty() {
        informationForm.firstNameField.clear();
        informationForm.lastNameField.clear();
        informationForm.zipCodField.clear();
        informationForm.clickOnContinueButton();
        Assert.assertTrue(informationForm.continueButton.isDisplayed());

    }

    @Test
    public void userCanClickOnFinishButton() {
        informationForm.inputFirstName(firstName);
        informationForm.inputLastName(lastName);
        informationForm.inpuZipCode(zipCode);
        informationForm.clickOnContinueButton();
        Assert.assertTrue(overViewPage.finishButton.isDisplayed());
        overViewPage.clickOnFinishButton();
        Assert.assertTrue(overViewPage.confirmationMessage.isDisplayed());


    }

    @Test
    public void userCanClickOnBackHomeButton() {
        informationForm.inputFirstName(firstName);
        informationForm.inputLastName(lastName);
        informationForm.inpuZipCode(zipCode);
        informationForm.clickOnContinueButton();
        Assert.assertTrue(overViewPage.finishButton.isDisplayed());
        overViewPage.clickOnFinishButton();
        overViewPage.clickOnBackHomeButton();
        Assert.assertTrue(productsPage.burgerMenu.isDisplayed());

    }
}
