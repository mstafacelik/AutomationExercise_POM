package tests.userStory_01;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercise;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TestCase_12_AddProductsInCart extends TestBaseRapor {

    AutomationExercise automationExercise;
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void addProductsInCart() {

        automationExercise = new AutomationExercise();
        extentTest = extentReports.createTest("Test von AutomationExercise");

        Driver.getDriver();
        extentTest.info("Browser wurde gestartet.");


        Driver.getDriver().get(ConfigReader.getProperty("AutomationExerciseUrl"));
        extentTest.info("Es wurde zur URL „http://automationexercise.com“ navigiert.");


        softAssert.assertTrue(automationExercise.logoAutomationExercise.isDisplayed());
        extentTest.info("Es wurde überprüft, dass die Startseite erfolgreich sichtbar ist.");

        automationExercise.productsLink.click();


        String firstProductPrice = automationExercise.productPriceFirstProduct.getText().replaceAll("[^0-9]", "");
        String secondProductPrice = automationExercise.productPriceSecondProduct.getText().replaceAll("[^0-9]", "");

        String firstProductTitelText = automationExercise.productNameFirstProduct.getText();
        String secondProductTitelText = automationExercise.productNameSecondProduct.getText();


        ReusableMethods.hover(automationExercise.addToCartFirstProduct);
        Driver.clickWithJS(automationExercise.addToCartFirstProduct);
        Driver.waitForVisibility(automationExercise.continueShoppingSchaltfläche, 5);
        Driver.clickWithJS(automationExercise.continueShoppingSchaltfläche);

        ReusableMethods.hover(automationExercise.addToCartSecondProduct);
        Driver.clickWithJS(automationExercise.addToCartSecondProduct);
        Driver.waitForVisibility(automationExercise.continueShoppingSchaltfläche, 5);
        Driver.clickWithJS(automationExercise.continueShoppingSchaltfläche);

        Driver.clickWithJS(automationExercise.cartLink);


        String firstProductTitelTextInCartPage = automationExercise.productNameFirstProductInCartPage.getText();
        String secondProductTitelTextInCartPage = automationExercise.productNameSecondProductInCartPage.getText();

        softAssert.assertEquals(firstProductTitelText, firstProductTitelTextInCartPage);
        softAssert.assertEquals(secondProductTitelText, secondProductTitelTextInCartPage);


        String firstProductPriceInCart = automationExercise.productPriceFirstProductTotal.getText().replaceAll("[^0-9]", "");

        String secondProductPriceInCart = automationExercise.productPriceSecondProductTotal.getText().replaceAll("[^0-9]", "");


        softAssert.assertEquals(firstProductPrice, firstProductPriceInCart);
        softAssert.assertEquals(secondProductPrice, secondProductPriceInCart);

        int firstProductQuantityInCartPage=Integer.parseInt(automationExercise.quantityFirstProduktInCartPage.getText());
        int secondProductQuantityInCartPage=Integer.parseInt(automationExercise.quantitySecondProduktInCartPage.getText());

        softAssert.assertEquals(1,firstProductQuantityInCartPage);
        softAssert.assertEquals(1,secondProductQuantityInCartPage);


        softAssert.assertAll();

    }


}