package For_UI_tests.pages;


import For_UI_tests.elements.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends Page{

    public ProfilePage(WebDriver driver){
        super(driver);
    }

    public Link boardLink = new Link(By.cssSelector("div[title = 'New Board']"), driver);
}
