import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;




public class UI_Tests extends TestManager{


    @Test(groups = "UI_Tests", priority = 1)
    public void renameBoardUI(){
        String newName = "Update Board";
        boardPage.renameBoard(newName);

        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.presenceOfElementLocated(boardPage.boardName.getBy()));

        Assert.assertEquals(boardPage.boardName.getText(), newName);
    }

    @Test(groups = "UI_Tests", priority = 2)
    public void renameCardUI(){
        String newName = "Update card";
        boardPage.renameCard(newName);

        Assert.assertEquals(boardPage.cardLink.getText(), newName);
    }

    @Test(groups = "UI_Tests", priority = 3)
    public void deleteCardUI() throws InterruptedException {
        boolean check = boardPage.deleteCard();
        Thread.sleep(3000);
        Assert.assertEquals(check, false);
    }
}
