package tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.actions.ElementActions;
import utilities.test_base.TestBase;

import java.util.Random;

public class AddProductToShippingCartTest extends TestBase {

    String fname = "Ahmed";
    String lname = "Mahmoud";
    String password = "123456";
    String email = RandomStringUtils.randomAlphabetic(4);
    String product = "Apple MacBook Pro 13-inch";
    String quantity = "5";

    @Test(priority = 1)
    public void UserCanRegister() {
        HomePage.openHomePage();
        HomePage.openRegistrationPage();
        UserRegistrationPage.userRegistration(fname, lname, email + "@test.com",
                password, password);
        System.out.println(email);
        Assert.assertTrue(ElementActions.getText(UserRegistrationPage.registrationCompletedMessage)
                .contains("Your registration completed"));
    }

    @Test(priority = 2, dependsOnMethods = "UserCanRegister")
    public void UserCanSearchProduct() {
        HomePage.openHomePage();
        SearchPage.searchProduct(product);
        Assert.assertTrue(ElementActions.getText(ProductDetailsPage.currentProduct)
                .contains(product));
    }

    @Test(priority = 3, dependsOnMethods = "UserCanSearchProduct")
    public void UserCanAddProductToShippingCart() {
        ProductDetailsPage.addToCar();
        HomePage.openShoppingCart();
        Assert.assertTrue(ElementActions.getText(CheckoutPage.productName)
                .contains(product));
    }

    @Test(priority = 4, dependsOnMethods = "UserCanAddProductToShippingCart")
    public void UserCanChangeProductQuantityInShippingCart() {
        CheckoutPage.changeQuantity(Integer.parseInt(quantity));
    }

    @Test(priority = 5, dependsOnMethods = "UserCanChangeProductQuantityInShippingCart")
    public void UserCanRemoveProductFromShippingCart() {
        CheckoutPage.removeFormCart();
        Assert.assertTrue(ElementActions.getText(CheckoutPage.emptyCartCheck)
                .contains("Your Shopping Cart is empty!"));
    }
}