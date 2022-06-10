package tests.userStory_01;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercise;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.util.Locale;

public class TestCase_09_SearchProduct extends TestBaseRapor {

    AutomationExercise automationExercise;
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void SearchProduct() {

        automationExercise = new AutomationExercise();
        extentTest = extentReports.createTest("Test von AutomationExercise");

        Driver.getDriver();
        extentTest.info("Browser wurde gestartet.");


        Driver.getDriver().get(ConfigReader.getProperty("AutomationExerciseUrl"));
        extentTest.info("Es wurde zur URL „http://automationexercise.com“ navigiert.");


        softAssert.assertTrue(automationExercise.logoAutomationExercise.isDisplayed());
        extentTest.info("Es wurde überprüft, dass die Startseite erfolgreich sichtbar ist.");

        automationExercise.productsLink.click();

        softAssert.assertTrue(automationExercise.allProductsText.isDisplayed());

        automationExercise.searchProductBox
                .sendKeys("Tshirt", Keys.TAB, Keys.ENTER);

        Driver.wait(3);

        int expectedZahlAllProductList = 0;

        for (WebElement w : automationExercise.brandAllProductsList) {

            if (w.getText().contains("Tshirt") || w.getText().contains("T-Shirt") || w.getText().contains("T SHIRT")) {

                expectedZahlAllProductList++;
            }
        }


        int actualZahlinErgebnisseite = automationExercise.productPageSearchResultList.size();
        softAssert.assertEquals(actualZahlinErgebnisseite, expectedZahlAllProductList);

        softAssert.assertAll();

    }


}