package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class ProductsPage extends BaseTest {

    public ProductsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "react-burger-menu-btn")
    public WebElement burgerMenu;

   @FindBy(className = "btn_inventory")
   public List<WebElement> addToCartButtons;

    @FindBy(className = "btn_secondary")
    public List<WebElement> removeButton;


    @FindBy(className = "shopping_cart_badge")
    public WebElement cartNumber;

    @FindBy(className = "product_sort_container")
    public WebElement sortDropdown;

    @FindBy(css = ".inventory_item_name")
    public List<WebElement> productName;

    @FindBy(id = "back-to-products")
    public WebElement backToProductButton;


    //------------------------------------------------------

    public void clickOnBurgerMenu() {
        burgerMenu.click();
    }

    public void clickOnAddButton(int i){
        addToCartButtons.get(i).click();

    }

    public void clickOnRemoveButton(int i){
        removeButton.get(i).click();
    }



    public void clickOnSortDropdown(String sortOption) {
        Select select = new Select(sortDropdown);
        select.selectByValue(sortOption);
    }

    public void clickOnProductName(String name) {
        for (int i = 0; i < productName.size(); i++) {
            WebElement product = productName.get(i);
            if (product.getText().equals(name)) {
                product.click();
                break;
            }
        }

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




    }



