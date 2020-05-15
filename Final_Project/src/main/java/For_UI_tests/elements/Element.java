package For_UI_tests.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public abstract class Element {
    protected By by;
    protected static WebDriver driver;

    public Element(By by, WebDriver driver){
        this.by = by;
        this.driver = driver;
    }

    public By getBy(){
        return by;
    }

    WebElement compose(){
        return driver.findElement(by);
    }

    public void click(){
        compose().click();
    }

    public boolean elementExists(){
        try{
            compose();
            return true;
        }catch (NullPointerException exception){
            return false;
        }
    }

    public String getText(){
        return compose().getText();
    }
}
