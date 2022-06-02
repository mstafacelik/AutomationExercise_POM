package tests.userStory_01;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercise;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.util.Random;

public class TestCase_19_ViewCartBrandProducts extends TestBaseRapor {

    AutomationExercise automationExercise;
    SoftAssert softAssert;
    Random random;
    Faker faker;
    Actions actions;

    @Test
    public void viewCartBrandProducts() {

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

        automationExercise.productsLink.click();


        if (automationExercise.brandsList.size() > 0) {
            System.out.println("=> Marken sind verfügbar und wie folgendes :");

            for (WebElement w : automationExercise.brandsList) {
                System.out.println(w.getText() + " is displayed? " + w.isDisplayed());
                softAssert.assertTrue(w.isDisplayed());
            }

        } else {
            System.out.println("=> Marken sind nicht verfügbar...");
        }


        automationExercise.brandsList.get(2).click();




        int productsSize = automationExercise.brandsList.size();
        int randomProduct = random.nextInt(productsSize);
        automationExercise.brandsList.get(randomProduct).click();



        Driver.wait(10);















        softAssert.assertAll();
    }
}