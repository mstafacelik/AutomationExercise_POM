//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class CrossDriver {
    public static WebDriver driver;

    private CrossDriver() {
    }

    public static WebDriver getDriver(String browser) {
        browser = browser == null ? ConfigReader.getProperty("browser") : browser;
        if (driver == null) {
            byte var2 = -1;
            switch(browser.hashCode()) {
                case -1361128838:
                    if (browser.equals("chrome")) {
                        var2 = 0;
                    }
                    break;
                case -909897856:
                    if (browser.equals("safari")) {
                        var2 = 3;
                    }
                    break;
                case -849452327:
                    if (browser.equals("firefox")) {
                        var2 = 1;
                    }
                    break;
                case 105948115:
                    if (browser.equals("opera")) {
                        var2 = 2;
                    }
            }

            switch(var2) {
                case 0:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case 1:
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case 2:
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;
                case 3:
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15L));
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }

    }
}
