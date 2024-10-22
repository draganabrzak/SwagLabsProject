package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class BaseTest {
    public static WebDriver driver;
    public LoginPage loginPage;
    public ProductsPage productsPage;
    public SidebarMenu sidebarMenu;
    public CartPage cartPage;
    public InformationForm informationForm;
    public CheckoutPage checkoutpage;
    public OverViewPage overViewPage;

    public ExcelReader excelReader;

    @BeforeClass
    public void setup() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        excelReader = new ExcelReader("C:\\Users\\user\\Desktop\\AccountsForSwagLabs.xlsx");

        loginPage = new LoginPage();
        productsPage = new ProductsPage();
        sidebarMenu = new SidebarMenu();
        cartPage = new CartPage();
        informationForm = new InformationForm();
        checkoutpage = new CheckoutPage();
        overViewPage = new OverViewPage();
    }

}
