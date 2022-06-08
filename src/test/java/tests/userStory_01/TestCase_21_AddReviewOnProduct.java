package tests.userStory_01;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercise;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.Random;

public class TestCase_21_AddReviewOnProduct extends TestBaseRapor {

    AutomationExercise automationExercise;
    SoftAssert softAssert;
    Random random;
    Faker faker;
    Actions actions;

    @Test
    public void addReviewOnProduct() {

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

        Driver.waitForVisibility(automationExercise.allProductsText, 5);
        automationExercise.allProductsText.isDisplayed();


        Driver.wait(3);
        Driver.clickWithJS(automationExercise.viewProductLinkFirstProduct);
        Driver.clickWithJS(automationExercise.nameBoxUnterWriteYourReview);

        automationExercise.nameBoxUnterWriteYourReview.sendKeys(faker.name().fullName(), Keys.TAB, faker.internet().emailAddress(),
                Keys.TAB, ConfigReader.getProperty("AEReview"), Keys.TAB, Keys.ENTER);


        Driver.waitForVisibility(automationExercise.verifySuccessMessageThankYouForYourReview,5);
        softAssert.assertTrue(automationExercise.verifySuccessMessageThankYouForYourReview.isDisplayed());


        softAssert.assertAll();
    }

}
