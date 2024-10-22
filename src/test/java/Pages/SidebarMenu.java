package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SidebarMenu extends BaseTest {

    public SidebarMenu() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutButton;

    //-------------------------------------------------

    public void clickOnLogoutButton(){
        logoutButton.click();
    }
}
