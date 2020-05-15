package For_UI_tests.pages;

import For_UI_tests.elements.Container;
import For_UI_tests.elements.Field;
import For_UI_tests.elements.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class BoardPage extends Page {
    public BoardPage(WebDriver driver){
        super(driver);
    }

    public Container boardName = new Container(By.cssSelector("span.js-board-editing-target.board-header-btn-text"), driver);
    public Field boardNameField = new Field(By.cssSelector("input.board-name-input.js-board-name-input"), driver);
    public Container cardLink = new Container(By.cssSelector("span.list-card-title.js-card-name"), driver);
    public Field fieldRenameCard = new Field(By.cssSelector("textarea.mod-card-back-title.js-card-detail-title-input"), driver);
    public Link archiveCardLink = new Link(By.cssSelector("a[title = 'Archive']"), driver);
    public Link deleteCardLink = new Link(By.cssSelector("a[title = 'Delete']"), driver);
    public Link confirmDeleteCardLink = new Link(By.cssSelector("input[value = 'Delete']"), driver);

    public void renameCard(String newName){
        this.cardLink.click();
        this.fieldRenameCard.clear();
        this.fieldRenameCard.sendKeys(newName + Keys.ENTER + Keys.ESCAPE + Keys.ESCAPE);
    }

    public boolean deleteCard(){
        this.cardLink.click();
        this.archiveCardLink.click();
        this.deleteCardLink.click();
        this.confirmDeleteCardLink.click();
        boolean check;
        try{
            check = this.cardLink.elementExists();
        } catch (NoSuchElementException e){
            check = false;
        }
        return check;
    }

    public void renameBoard(String newName){
        this.boardName.click();
        this.boardNameField.sendKeys(newName + Keys.ENTER);
    }
}
