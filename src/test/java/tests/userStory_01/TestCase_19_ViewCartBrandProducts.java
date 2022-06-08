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


        int brandsSize = automationExercise.brandsList.size();



        for (int i = 0; i < 2; i++) {

            int randomBrands = random.nextInt(brandsSize);
            Driver.clickWithJS(automationExercise.brandsList.get(randomBrands));
            Driver.wait(2);
            softAssert.assertTrue(automationExercise.brandsText.isDisplayed());

            for (WebElement w : automationExercise.brandAllProductsList) {

                softAssert.assertTrue(w.isDisplayed());
                System.out.println(w.getText());


            }
            System.out.println("===========#Zweilmal wurden brands üperprüft!#==================");

        }

        softAssert.assertAll();

    }
}