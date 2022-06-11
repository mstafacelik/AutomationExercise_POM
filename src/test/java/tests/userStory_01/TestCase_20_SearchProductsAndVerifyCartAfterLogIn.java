package tests.userStory_01;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercise;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.util.Random;

public class TestCase_20_SearchProductsAndVerifyCartAfterLogIn extends TestBaseRapor {


    AutomationExercise automationExercise;
    SoftAssert softAssert;
    Random random;
    Faker faker;
    Actions actions;
    int expectedZahlAllProductList;
    int actualZahlinErgebnisSeite;

    @Test
    public void SearchProductsAndVerifyCartAfterLogIn() {

        automationExercise = new AutomationExercise();
        softAssert = new SoftAssert();
        random = new Random();
        faker = new Faker();
        actions = new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("Test von AutomationExercise");

        Driver.getDriver();
        extentTest.info("Browser wurde gestartet.");


        Driver.getDriver().get(ConfigReader.getProperty("AutomationExerciseUrl"));
        extentTest.info("Es wurde zur URL „http://automationexercise.com“ navigiert.");

        softAssert.assertTrue(automationExercise.logoAutomationExercise.isDisplayed());
        extentTest.info("Es wurde überprüft, dass die Startseite erfolgreich sichtbar ist.");

        automationExercise.productsLink.click();

        Driver.waitForVisibility(automationExercise.allProductsText, 5);
        automationExercise.allProductsText.isDisplayed();

        automationExercise.searchProductBox
                .sendKeys("tShirt", Keys.TAB, Keys.ENTER);

        Driver.wait(2);

        Driver.waitForVisibility(automationExercise.searchedProductsText, 5);
        softAssert.assertTrue(automationExercise.searchedProductsText.isDisplayed());


        expectedZahlAllProductList = 0;

        for (WebElement w : automationExercise.brandAllProductsList) {

            if (w.getText().contains("Tshirt") || w.getText().contains("T-Shirt") || w.getText().contains("T SHIRT")) {

                expectedZahlAllProductList++;
            }
        }


        actualZahlinErgebnisSeite = automationExercise.productPageSearchResultList.size();
        softAssert.assertEquals(actualZahlinErgebnisSeite, expectedZahlAllProductList);


        for (int i = 0; i < automationExercise.addToCartTextSearchedResultPageList.size(); i += 2) {

            automationExercise.addToCartTextSearchedResultPageList.get(i).click();
            Driver.waitAndClick(automationExercise.continueShoppingSchaltfläche);


        }

        automationExercise.cartLink.click();
        expectedZahlAllProductList = 0;

        for (WebElement w : automationExercise.brandAllProductsList) {

            if (w.getText().contains("Tshirt") || w.getText().contains("T-Shirt") || w.getText().contains("T SHIRT")) {

                expectedZahlAllProductList++;
            }
        }

        actualZahlinErgebnisSeite = automationExercise.productPageSearchResultList.size();
        softAssert.assertEquals(actualZahlinErgebnisSeite, expectedZahlAllProductList);


        automationExercise.signupLoginLink.click();
        automationExercise.logInEMailAdresseBox.sendKeys(ConfigReader.getProperty("AECorrectEmailAdresse"),
                Keys.TAB, ConfigReader.getProperty("AECorrectPassword"), Keys.TAB, Keys.ENTER);

        automationExercise.cartLink.click();

        expectedZahlAllProductList = 0;

        for (WebElement w : automationExercise.brandAllProductsList) {

            if (w.getText().contains("Tshirt") || w.getText().contains("T-Shirt") || w.getText().contains("T SHIRT")) {

                expectedZahlAllProductList++;
            }
        }

        softAssert.assertAll();
    }
}