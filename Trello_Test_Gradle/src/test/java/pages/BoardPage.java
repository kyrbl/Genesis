package pages;

import elements.Field;
import elements.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoardPage extends Page {
    public BoardPage(WebDriver driver){
        super(driver);
    }

    public Field boardName = new Field(By.cssSelector("a[href='#']"));
}
