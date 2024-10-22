package Tests;

import Base.BaseTest;
import org.testng.annotations.BeforeMethod;

public class CartTest extends BaseTest {
    @BeforeMethod
    public void pageSetup() {
        driver.navigate().to("https://www.saucedemo.com/");
    }
}
