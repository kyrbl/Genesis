package conf;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

import java.util.concurrent.TimeUnit;

public class TestManager {
    protected static WebDriver driver;

    @BeforeAll
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);

        //Home page
        HomePage homePage = new HomePage(driver);
        homePage.openPage(homePage.url);
        homePage.loginLink.click();
        //Login page
        LoginPage loginPage = new LoginPage(driver);
        loginPage.emailField.sendKeys("blackjack13132001@gmail.com");
        loginPage.passwordField.sendKeys("112233wwcc" + Keys.ENTER);
        //Board page
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.boardLink.click();
    }
    @AfterAll
    public static void tearDown(){
        driver.quit();
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
