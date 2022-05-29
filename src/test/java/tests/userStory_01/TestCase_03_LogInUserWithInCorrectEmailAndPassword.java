package tests.userStory_01;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercise;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TestCase_03_LogInUserWithInCorrectEmailAndPassword extends TestBaseRapor {

    AutomationExercise automationExercise = new AutomationExercise();
    Actions actions = new Actions(Driver.getDriver());
    Faker faker = new Faker();
    SoftAssert softAssert = new SoftAssert();


    @Test(dataProvider = "daten")
    public void logInUserWithInCorrectEmailAndPassword(String inCorrectEmail, String inCorrectPassword) throws InterruptedException {
        extentTest = extentReports.createTest("Test von AutomationExercise");

        Driver.getDriver();
        extentTest.info("Browser wurde gestartet.");


        Driver.getDriver().get(ConfigReader.getProperty("AutomationExerciseUrl"));
        extentTest.info("Es wurde zur URL „http://automationexercise.com“ navigiert.");


        automationExercise.logoAutomationExercise.isDisplayed();
        extentTest.info("Es wurde überprüft, dass die Startseite erfolgreich sichtbar ist.");


        automationExercise.signupLoginLink.click();
        extentTest.info("Es wurde auf die Schaltfläche „Signup / Login“ geklickt.");

        automationExercise.loginToYourAccountText.isDisplayed();

        automationExercise.logInEMailAdresseBox.sendKeys(inCorrectEmail);
        automationExercise.logInPasswordBoxHomePage.sendKeys(inCorrectEmail);
        automationExercise.loginSchaltfläche.click();

        Driver.wait(3);

        Assert.assertTrue(automationExercise.yourEmailOrPasswordIsIncorrectText.isDisplayed());


    }

    @DataProvider
    public static Object[][] daten() {

        Object[][] inCorrectEmailAndPassword = {{"abc@gmail.com", "1234"},
                {"celik@gmail.com", "Ab1234567."}, {"mustingo@gmail.com", "Ab4623,"}};

        return inCorrectEmailAndPassword;


    }

}



