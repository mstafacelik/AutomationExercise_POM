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

import java.io.IOException;

public class TestCase_01_RegisterUser extends TestBaseRapor {

    AutomationExercise automationExercise ;
    Actions actions = new Actions(Driver.getDriver());
    Faker faker = new Faker();
    SoftAssert softAssert = new SoftAssert();

    @Test(priority = 1)
    public void benutzerRegistration() {

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


        Driver.clickWithJS(automationExercise.newUserNameBox);
        automationExercise.newUserNameBox
                .sendKeys(ConfigReader.getProperty("zurRegistrationNewUserName")
                        + Keys.TAB, ConfigReader.getProperty("zurRegistrationNewUserEMailAdresse"));

        automationExercise.signUpSchaltfläche.click();
        Driver.wait(3);

        if (automationExercise.eMailAdresseBereitsVergebenText.isDisplayed()) {
            Driver.wait(3);
            automationExercise.newUserEMailAdresseBox.clear();
            automationExercise.newUserEMailAdresseBox.sendKeys(faker.internet().emailAddress());
            extentTest.info("Name und E-Mail-Adresse wurden eingegeben");

            automationExercise.signUpSchaltfläche.click();
            extentTest.info("Es wurde  auf die Schaltfläche „Signup“ geklickt.");


        } else {
            extentTest.info("Name und E-Mail-Adresse wurden eingegeben");
            extentTest.info("Es wurde  auf die Schaltfläche „Signup“ geklickt.");
        }


        Driver.wait(2);
        automationExercise.enterAccountInfotmationText.isDisplayed();
        extentTest.info("Es wurde überprüft, dass „ENTER ACCOUNT INFORMATION“ sichtbar ist.");


        automationExercise.radioTitleMr.click();
        automationExercise.paswordBoxZumKontoErstellen.sendKeys(faker.internet().password());
        Driver.selectByIndex(automationExercise.geburtsdatumTagSelect, 15);
        Driver.selectByIndex(automationExercise.geburtsdatumMonatSelect, 9);
        Driver.selectByValue(automationExercise.geburtsdatumJahrSelect, "1990");
        extentTest.info("zur Registration wurde der Titel angekruezt und Passwort und," +
                " Geburtsdatum wurden eingegeben.");


        automationExercise.kontrollKästchenSignUpForOurNewsletter.click();
        extentTest.info("Das Kontrollkästchen 'Sign up for our newsletter' wurde angekreuzt.");


        automationExercise.kontrollKästchenReceiveSpecialOffersFromOurPartners.click();
        extentTest.info("Das Kontrollkästchen 'Receive special offers from our partners!.");


        actions.click(automationExercise.vornameTextBox).sendKeys(faker.name().firstName(), Keys.TAB)
                .sendKeys(faker.name().lastName(), Keys.TAB)
                .sendKeys(faker.company().name(), Keys.TAB)
                .sendKeys(faker.address().fullAddress(), Keys.TAB, Keys.TAB)
                .sendKeys("Canada", Keys.TAB)
                .sendKeys(faker.address().state(), Keys.TAB)
                .sendKeys(faker.address().city(), Keys.TAB)
                .sendKeys(faker.address().zipCode(), Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone())
                .perform();

        Driver.wait(2);
        extentTest.info("zur Registration wurden die erforderlichen Daten eingegeben.");


        automationExercise.kontoErstellenSchaltfläche.click();
        extentTest.info("Es wurde auf die Schaltfläche „Create Account button“ geklickt.");


        Driver.wait(2);
        automationExercise.accountCreatedText.isDisplayed();
        extentTest.info("Es wurde überprüft, dass 'ACCOUNT CREATED!' ist sichtbar.");


        automationExercise.continueSchaltflächeUnterAccountCreatedText.click();
        extentTest.info("Es wurde auf die Schaltfläche „Continue“ geklickt.");


        automationExercise.loggedInAsText.isDisplayed();
        extentTest.info("Es wurde überprüft, dass „Logged in as username“ sichtbar ist.");


        automationExercise.deleteAccountLink.click();
        extentTest.info("Es wurde auf die Schaltfläche „Delete Account“ geklickt.");


        softAssert.assertFalse(automationExercise.deleteAccountText.isDisplayed());
        extentTest.fail("Es wurde festgestellt, dass 'ACCOUNT DELETED!'  nicht sichtbar ist.");

        softAssert.assertFalse(automationExercise.optionsButton.isDisplayed());
        extentTest.fail("Es wurde festgestellt, dass es keine Schaltfläche „Continue“ gibt." +
                "Deswegen  konnte drauf nicht geklickt werden.");

        softAssert.assertAll();




    }

    @DataProvider
    public static Object[][] negativeNewUserSignUp() {

        Object[][] ungültigeDaten = {{".", "1@1"},{",","a.@com"},{"a","1@a"}};

      //  ungültigeDaten[0][0] = ".";
      //  ungültigeDaten[0][1] = "1@1";
      //  ungültigeDaten[1][0] = ",";
      //  ungültigeDaten[1][1] = "a.@com";
      //  ungültigeDaten[2][0] = "a";
      //  ungültigeDaten[2][1] = "1@a";

        return ungültigeDaten;

    }

    @Test(dataProvider = "negativeNewUserSignUp")
    public void negatifTestBenutzerRegistration(String ungültigerName, String ungültigeEMailAdresse) throws IOException {

        extentTest = extentReports.createTest("Test von AutomationExercise");

        Driver.getDriver().get(ConfigReader.getProperty("AutomationExerciseUrl"));
        extentTest.info("Es wurde zur URL „http://automationexercise.com“ navigiert.");


        Driver.waitAndClick(automationExercise.signupLoginLink);
        extentTest.info("Es wurde auf die Schaltfläche „Signup / Login“ geklickt.");
        Driver.wait(2);


        Driver.clickWithJS(automationExercise.newUserNameBox);
        automationExercise.newUserNameBox.sendKeys(ungültigerName);
        automationExercise.newUserEMailAdresseBox.sendKeys(ungültigeEMailAdresse);
        Driver.getScreenshot("deneme");
        automationExercise.signUpSchaltfläche.click();

        Assert.assertTrue(automationExercise.signUpSchaltfläche.isDisplayed());
        extentTest.fail("Trotzder der ungültigen Daten wurden sie zum SignUp akzeptiert !!! ");








    }


}
