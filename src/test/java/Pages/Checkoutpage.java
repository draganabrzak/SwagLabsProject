package Pages;

import Base.BaseTest;
import org.openqa.selenium.support.PageFactory;

public class Checkoutpage extends BaseTest {

    public Checkoutpage() {
        PageFactory.initElements(driver, this);
    }
}
