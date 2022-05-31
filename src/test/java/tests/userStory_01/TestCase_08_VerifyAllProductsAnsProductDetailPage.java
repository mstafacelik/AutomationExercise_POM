package tests.userStory_01;

import com.github.javafaker.Faker;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercise;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TestCase_08_VerifyAllProductsAnsProductDetailPage extends TestBaseRapor {

    SoftAssert softAssert=new SoftAssert();
    AutomationExercise automationExercise;


    @Test
    public void verifyAllProductsAnsProductDetailPage(){

        automationExercise= new AutomationExercise();
        extentTest = extentReports.createTest("Test von AutomationExercise");

        Driver.getDriver();
        extentTest.info("Browser wurde gestartet.");


        Driver.getDriver().get(ConfigReader.getProperty("AutomationExerciseUrl"));
        extentTest.info("Es wurde zur URL „http://automationexercise.com“ navigiert.");


        softAssert.assertTrue(automationExercise.logoAutomationExercise.isDisplayed());
        extentTest.info("Es wurde überprüft, dass die Startseite erfolgreich sichtbar ist.");

        automationExercise.productsLink.click();

        softAssert.assertTrue(automationExercise.allProductsText.isDisplayed());

        automationExercise.viewProductLinkFirstProduct.click();

        Driver.wait(2);

        softAssert.assertTrue((automationExercise.productNameFirstProduct.isDisplayed()));
        softAssert.assertTrue((automationExercise.productCategoryFirstProduct.isDisplayed()));
        softAssert.assertTrue((automationExercise.productPriceFirstProduct.isDisplayed()));
        softAssert.assertTrue((automationExercise.productAvailabilityFirstProduct.isDisplayed()));
        softAssert.assertTrue((automationExercise.productConditionFirstProduct.isDisplayed()));
        softAssert.assertTrue((automationExercise.productBrandFirstProduct.isDisplayed()));


        softAssert.assertAll();



    }


}
