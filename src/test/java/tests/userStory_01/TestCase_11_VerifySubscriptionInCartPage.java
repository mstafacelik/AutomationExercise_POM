package tests.userStory_01;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercise;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TestCase_11_VerifySubscriptionInCartPage extends TestBaseRapor {

    AutomationExercise automationExercise;
    SoftAssert softAssert=new SoftAssert();
    Faker faker=new Faker();

    @Test
    public void VerifySubscriptionInCartPage(){

        automationExercise= new AutomationExercise();
        extentTest = extentReports.createTest("Test von AutomationExercise");

        Driver.getDriver();
        extentTest.info("Browser wurde gestartet.");


        Driver.getDriver().get(ConfigReader.getProperty("AutomationExerciseUrl"));
        extentTest.info("Es wurde zur URL „http://automationexercise.com“ navigiert.");


        softAssert.assertTrue(automationExercise.logoAutomationExercise.isDisplayed());
        extentTest.info("Es wurde überprüft, dass die Startseite erfolgreich sichtbar ist.");


        automationExercise.cartLink.click();

        Driver.clickWithJS(automationExercise.footPage);
        Driver.wait(2);

        softAssert.assertTrue(automationExercise.subscriptionText.isDisplayed());

        automationExercise.eMailAdresseBoxUnterSubscription
                .sendKeys(faker.internet().emailAddress(), Keys.TAB, Keys.ENTER);


        // softAssert.assertTrue(automationExercise."You have been successfully subscribed"); ---> nimm locate



    }


}
