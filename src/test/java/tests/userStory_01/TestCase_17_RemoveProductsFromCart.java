package tests.userStory_01;

import com.github.javafaker.Faker;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercise;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.util.Random;

public class TestCase_17_RemoveProductsFromCart extends TestBaseRapor {


    AutomationExercise automationExercise;
    SoftAssert softAssert;
    Random random;
    Faker faker;
    Actions actions;

    @Test
    public void removeProductsFromCart() {

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

        int productsSize = automationExercise.viewProductsList.size();
        int randomProduct = random.nextInt(productsSize);

        for (int i = 0; i < 3; i++) {

            automationExercise.viewProductsList.get(randomProduct).click();
            Driver.waitAndClick(automationExercise.addToChartSchaltfläche);
            Driver.waitAndClick(automationExercise.continueShoppingSchaltfläche);
            Driver.waitAndClick(automationExercise.homeLinkHomePage);

            i++;

        }


        automationExercise.cartLink.click();
        softAssert.assertTrue(automationExercise.shoppingCartText.isDisplayed());

        Driver.waitAndClick(automationExercise.xSchaltflächeUnterProceedToCheckOut);
        Driver.waitAndClick(automationExercise.xSchaltflächeUnterProceedToCheckOut);

        Driver.wait(2);


        softAssert.assertTrue(automationExercise.cartIsEmptyText.isDisplayed());
        softAssert.assertAll();




    }
}
