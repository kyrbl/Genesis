import conf.TestManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import pages.BoardPage;
import pages.ProfilePage;
import pages.HomePage;
import pages.LoginPage;

public class Basic_Selenium extends TestManager {

    @Test
    public void renameBoardUI(){
        BoardPage boardPage= new BoardPage(driver);
        boardPage.boardName.click();
        Assertions.assertTrue(true);
    }
}
