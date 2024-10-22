package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InformationForm extends BaseTest {
    public InformationForm() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "continue")
    public WebElement continueButton;

    @FindBy(id = "first-name")
    public WebElement firstNameField;

    @FindBy(id = "last-name")
    public WebElement lastNameField;

    @FindBy(id = "postal-code")
    public WebElement zipCodField;

    //----------------------------------------------
     public void clickOnContinueButton() {
         continueButton.click();
     }
     public void inputFirstName(String firstName) {
         firstNameField.clear();
         firstNameField.sendKeys(firstName);

     }
     public void inputLastName(String lastName) {
         lastNameField.clear();
         lastNameField.sendKeys(lastName);
     }
     public void inpuZipCode(String zipCode) {
         zipCodField.clear();
         zipCodField.sendKeys(zipCode);
     }

}
