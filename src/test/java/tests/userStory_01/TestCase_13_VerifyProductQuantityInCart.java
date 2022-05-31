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

        int productsSize = automationExercise.viewProductsList.size();
        int randomProduct = random.nextInt(productsSize);

        automationExercise.viewProductsList.get(randomProduct).click();
        automationExercise.quantityText.isDisplayed();


        int intMaxQuantityProduct = random.nextInt(1000);
        String stringMaxQuantityProduct=Integer.toString(intMaxQuantityProduct);

        automationExercise.quantityBox.clear();
        automationExercise.quantityBox.sendKeys(stringMaxQuantityProduct,Keys.TAB, Keys.ENTER);
        Driver.wait(2);
        automationExercise.viewCartLinkUnterAdded.click();

        String actualQuantity=stringMaxQuantityProduct;
        String expectedQuantityProduct=automationExercise.quantityProduct.getText();


        softAssert.assertEquals(actualQuantity,expectedQuantityProduct,"Bestellmenge stimmt nicht überein!!!");




    }


}
