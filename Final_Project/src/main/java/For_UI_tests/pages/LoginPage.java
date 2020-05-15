package For_UI_tests.pages;

import For_UI_tests.elements.Field;
import For_UI_tests.elements.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Page{

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public Field emailField = new Field(By.cssSelector("input[id='user']"), driver);
    public Field passwordField = new Field(By.cssSelector("input[id='password']"), driver);
    public Link submitLink = new Link(By.cssSelector("input[id='login']"), driver);

    public void login(){
        this.emailField.sendKeys("blackjack13132001@gmail.com");
        this.passwordField.sendKeys("112233wwcc");
        this.submitLink.click();
    }
}
