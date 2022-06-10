package tests.userStory_01;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercise;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.util.Random;

public class TestCase_26_verifiyScrollUpWithoutArrowButtonAndScrollDownFunctionality extends TestBaseRapor {


    AutomationExercise automationExercise;
    SoftAssert softAssert;
    Random random;
    Faker faker;
    Actions actions;

    @Test
    public void verifiyScrollUpWithoutArrowButtonAndScrollDownFunctionality() {

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


        //Scrollen Sie nach unten bis zum Ende der Seite
       JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
       js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

       // Alternative Scrollen bis zum Ende der Seite
       // actions.sendKeys(Keys.END).perform();

        softAssert.assertTrue(automationExercise.subscriptionText.isDisplayed());

        // zum Seitenanfang scrollen
        js.executeScript(" window.scrollTo(0, 0);");

        // Alternative Scrollen zum Seitenanfang
        // actions.sendKeys(Keys.HOME).perform();

        softAssert.assertTrue(automationExercise.logoAutomationExercise.isDisplayed());
        softAssert.assertTrue(automationExercise.fullFledgedText.isDisplayed());


        softAssert.assertAll();


    }
}
