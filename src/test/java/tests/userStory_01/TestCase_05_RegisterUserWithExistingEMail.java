package tests.userStory_01;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercise;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TestCase_05_RegisterUserWithExistingEMail extends TestBaseRapor {


    AutomationExercise automationExercise;
    Faker faker = new Faker();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void RegisterUserWithExistingEMail() {

        automationExercise= new AutomationExercise();
        extentTest = extentReports.createTest("Test von AutomationExercise");

        Driver.getDriver();
        extentTest.info("Browser wurde gestartet.");


        Driver.getDriver().get(ConfigReader.getProperty("AutomationExerciseUrl"));
        extentTest.info("Es wurde zur URL „http://automationexercise.com“ navigiert.");


        softAssert.assertTrue(automationExercise.logoAutomationExercise.isDisplayed());
        extentTest.info("Es wurde überprüft, dass die Startseite erfolgreich sichtbar ist.");


        automationExercise.signupLoginLink.click();
        extentTest.info("Es wurde auf die Schaltfläche „Signup / Login“ geklickt.");

        automationExercise.newUserSignUpText.isDisplayed();
        extentTest.info("Es wurde überprüft, dass „New User Signup!“ sichtbar ist.");

        automationExercise.logInPasswordBoxHomePage.click();

        automationExercise.newUserNameBox.sendKeys(faker.name().fullName());

        automationExercise.newUserEMailAdresseBox
                .sendKeys(ConfigReader.getProperty("AEVorhandenEMailAdresse"));
        automationExercise.signUpSchaltfläche.click();

        Driver.wait(2);

        softAssert.assertTrue(automationExercise.eMailAdresseBereitsVergebenText.isDisplayed());

        softAssert.assertAll();


    }


}
