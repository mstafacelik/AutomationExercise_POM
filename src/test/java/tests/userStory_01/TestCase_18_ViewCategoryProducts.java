package tests.userStory_01;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercise;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class TestCase_18_ViewCategoryProducts extends TestBaseRapor {

    AutomationExercise automationExercise;
    SoftAssert softAssert;
    Random random;
    Faker faker;
    Actions actions;

    @Test
    public void viewCategoryProducts() {

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


        for (WebElement w : automationExercise.kategorienList) {
            System.out.println(w.getText() + " is displayed? " + w.isDisplayed());
            softAssert.assertTrue(w.isDisplayed());
        }


        Driver.clickWithJS(automationExercise.categoryWomenLink);

        int womanKategorieSize = automationExercise.anyCategoryLinkUnderWomenCategory.size();
        int womanRandomKategorie = random.nextInt(womanKategorieSize);

        Driver.wait(3);

        Driver.clickWithJS(automationExercise.anyCategoryLinkUnderWomenCategory.get(womanRandomKategorie));
        softAssert.assertTrue(automationExercise.womenDressTopsSaareeTitleText.isDisplayed());

        Driver.wait(5);



        try {
           automationExercise.womenTopsProductsText.isDisplayed();

        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("Kategorie Women/Tops ist nicht sichtbar");
        }



        Driver.clickWithJS(automationExercise.categoryMenLink);

        int manKategorieSize = automationExercise.anyCategoryLinkUnderWomenCategory.size();
        int manRandomKategorie = random.nextInt(manKategorieSize);


        Driver.clickWithJS(automationExercise.anyCategoryLinkUnderMenCategory.get(manRandomKategorie));
        Driver.wait(2);
        softAssert.assertTrue(automationExercise.menTshirtJeansProductTitleText.isDisplayed());


        softAssert.assertAll();


    }
}
