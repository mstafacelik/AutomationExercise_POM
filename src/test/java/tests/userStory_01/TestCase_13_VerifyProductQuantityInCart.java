package tests.userStory_01;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercise;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.util.Random;

public class TestCase_13_VerifyProductQuantityInCart extends TestBaseRapor {

    AutomationExercise automationExercise;
    SoftAssert softAssert;
    Random random;

    @Test
    public void verifyProductQuantityInCart() {

        softAssert = new SoftAssert();
        automationExercise = new AutomationExercise();
        random = new Random();

        extentTest = extentReports.createTest("Test von AutomationExercise");

        Driver.getDriver();
        extentTest.info("Browser wurde gestartet.");


        Driver.getDriver().get(ConfigReader.getProperty("AutomationExerciseUrl"));
        extentTest.info("Es wurde zur URL „http://automationexercise.com“ navigiert.");


        softAssert.assertTrue(automationExercise.logoAutomationExercise.isDisplayed());
        extentTest.info("Es wurde überprüft, dass die Startseite erfolgreich sichtbar ist.");


        automationExercise.viewProductsList.get(0).click();
        automationExercise.quantityText.isDisplayed();


        automationExercise.quantityBox.clear();
        automationExercise.quantityBox.sendKeys(ConfigReader.getProperty("AEProductQuantity"), Keys.TAB, Keys.ENTER);

        Driver.waitForVisibility(automationExercise.viewCartLinkUnterAdded,10);
        automationExercise.viewCartLinkUnterAdded.click();

        int actualQuantity = 4;
        int expectedQuantityProduct =Integer.parseInt(automationExercise.quantityProductInCartPage.getText());
        softAssert.assertEquals(actualQuantity, expectedQuantityProduct, "Bestellmenge stimmt nicht überein!!!");

        softAssert.assertAll();

    }


}