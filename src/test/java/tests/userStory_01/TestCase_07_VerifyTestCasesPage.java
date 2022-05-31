package tests.userStory_01;

import com.github.javafaker.Faker;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercise;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TestCase_07_VerifyTestCasesPage extends TestBaseRapor {


    AutomationExercise automationExercise ;
    SoftAssert softAssert = new SoftAssert();


    @Test
    public void verifyTestCasesPage() {

        automationExercise= new AutomationExercise();

        extentTest = extentReports.createTest("Test von AutomationExercise");

        Driver.getDriver();
        extentTest.info("Browser wurde gestartet.");


        Driver.getDriver().get(ConfigReader.getProperty("AutomationExerciseUrl"));
        extentTest.info("Es wurde zur URL „http://automationexercise.com“ navigiert.");


        softAssert.assertTrue(automationExercise.logoAutomationExercise.isDisplayed());
        extentTest.info("Es wurde überprüft, dass die Startseite erfolgreich sichtbar ist.");

        automationExercise.testCasesLink.click();

        softAssert.assertTrue(automationExercise.testCasesText.isDisplayed());
        softAssert.assertAll();


    }
}
