package pages;

import elements.Container;
import elements.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends Page{

    public ProfilePage(WebDriver driver){
        super(driver);
    }


    public Link boardLink = new Link(By.cssSelector("a.board-tile.mod-light-background"));

    public Container allBoardsContainer = new Container(By.cssSelector("div.all-boards"));
}
