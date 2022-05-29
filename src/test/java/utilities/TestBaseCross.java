//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class TestBaseCross {
    protected WebDriver driver;

    public TestBaseCross() {
    }

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional String browser) {
        this.driver = CrossDriver.getDriver(browser);
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15L));
    }

    @AfterMethod
    public void teardown() {
        CrossDriver.closeDriver();
    }
}
