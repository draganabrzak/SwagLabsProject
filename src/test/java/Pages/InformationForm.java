package Pages;

import Base.BaseTest;
import org.openqa.selenium.support.PageFactory;

public class InformationForm extends BaseTest {
    public InformationForm() {
        PageFactory.initElements(driver, this);
    }
}
