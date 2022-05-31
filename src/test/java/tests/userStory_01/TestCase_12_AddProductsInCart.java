package tests.userStory_01;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercise;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TestCase_12_AddProductsInCart extends TestBaseRapor {

    AutomationExercise automationExercise;
    SoftAssert softAssert=new SoftAssert();

    @Test
    public void addProductsInCart(){

        automationExercise= new AutomationExercise();
        extentTest = extentReports.createTest("Test von AutomationExercise");

        Driver.getDriver();
        extentTest.info("Browser wurde gestartet.");


        Driver.getDriver().get(ConfigReader.getProperty("AutomationExerciseUrl"));
        extentTest.info("Es wurde zur URL „http://automationexercise.com“ navigiert.");


        softAssert.assertTrue(automationExercise.logoAutomationExercise.isDisplayed());
        extentTest.info("Es wurde überprüft, dass die Startseite erfolgreich sichtbar ist.");

        automationExercise.productsLink.click();

        automationExercise.addToCartFirstProduct.click();
        automationExercise.continueShoppingSchaltfläche.click();
        automationExercise.addToCartSecondProduct.click();

        softAssert.assertTrue(automationExercise.productNameFirstProduct.isDisplayed());
        softAssert.assertTrue(automationExercise.productNameSecondProduct.isDisplayed());

        softAssert.assertTrue(automationExercise.productPriceFirstProduct.isDisplayed());
        softAssert.assertTrue(automationExercise.productPriceSecondProduct.isDisplayed());



    }



}
