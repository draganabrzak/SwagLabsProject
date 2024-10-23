package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverViewPage extends BaseTest {
    public OverViewPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "finish")
    public WebElement finishButton;

    @FindBy(className = "complete-header")
    public WebElement confirmationMessage;

    @FindBy(id = "back-to-products")
    public WebElement backHomeButton;

    //--------------------------------

    public void clickOnFinishButton() {
        finishButton.click();
    }

    public void clickOnBackHomeButton() {
        backHomeButton.click();
    }

}
