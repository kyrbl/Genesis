package For_UI_tests.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Field extends Element {
    public Field(By by, WebDriver driver) {
        super(by, driver);
    }

    public void clear(){
        compose().clear();
    }

    public void sendKeys(String str){
        compose().sendKeys(str);
    }
}
