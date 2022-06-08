package tests.userStory_01;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercise;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.util.Random;

public class TestCase_20_SearchProductsAndVerifyCartAfterLogIn extends TestBaseRapor {


    AutomationExercise automationExercise;
    SoftAssert softAssert;
    Random random;
    Faker faker;
    Actions actions;

    @Test
    public void SearchProductsAndVerifyCartAfterLogIn() {

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

        automationExercise.searchProductBox
                .sendKeys("t-shirt", Keys.TAB, Keys.ENTER);

        Driver.wait(2);

        Driver.waitForVisibility(automationExercise.searchedProductsText, 5);
        automationExercise.searchedProductsText.isDisplayed();

        String searchedProduct = "t-shirt";


        for (WebElement w : automationExercise.brandAllProductsList) {
            System.out.println(w.getText() + " is displayed? " + w.isDisplayed());
            softAssert.assertTrue(w.getText().toUpperCase().contains(searchedProduct.toUpperCase()));
            softAssert.assertTrue(w.isDisplayed());

        }

        for (WebElement w : automationExercise.viewProductLinkList) {

            w.click();
            Driver.clickWithJS(automationExercise.addToChartSchaltfläche);
            Driver.getDriver().navigate().back();


        }

        automationExercise.cartLink.click();

        for (WebElement w : automationExercise.brandAllProductsList) {
            System.out.println(w.getText() + " is displayed? " + w.isDisplayed());
            softAssert.assertTrue(w.getText().toUpperCase().contains(searchedProduct.toUpperCase()));
            softAssert.assertTrue(w.isDisplayed());

        }

        automationExercise.signupLoginLink.click();
        automationExercise.logInEMailAdresseBox
                .sendKeys(ConfigReader.getProperty("AECorrectEmailAdresse"),
                        Keys.TAB,ConfigReader.getProperty("AECorrectPassword"),Keys.TAB,Keys.ENTER);


        for (WebElement w : automationExercise.brandAllProductsList) {
            System.out.println(w.getText() + " is displayed? " + w.isDisplayed());
            softAssert.assertTrue(w.getText().toUpperCase().contains(searchedProduct.toUpperCase()));
            softAssert.assertTrue(w.isDisplayed());

        }

        softAssert.assertAll();
    }
}