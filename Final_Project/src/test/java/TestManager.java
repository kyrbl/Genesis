import For_API_tests.Board;
import For_API_tests.Card;
import For_API_tests.List;
import For_API_tests.RetrofitBuilder;
import For_UI_tests.pages.BoardPage;
import For_UI_tests.pages.HomePage;
import For_UI_tests.pages.LoginPage;
import For_UI_tests.pages.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestManager {
    protected String boardId;
    protected String listId;
    protected String cardId;
    protected static RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
    protected static Board board = new Board();
    protected static List list = new List();
    protected static Card card = new Card();
    protected static WebDriver driver;
    protected BoardPage boardPage= new BoardPage(driver);

    @BeforeTest
    public void setUpObjects() throws IOException {

        //Creating a new Board
        board.setName("New Board");
        Board createdBoard = retrofitBuilder.getTrelloapi().createBoard(board).execute().body();
        boardId = createdBoard.getId();

        //Creating a new List on Board
        list.setName("New List");
        List newList = retrofitBuilder.getTrelloapi().createList(list, boardId).execute().body();
        listId = newList.getId();

        //Creating a new Card in List
        card.setName("New Card");
        Card newCard = retrofitBuilder.getTrelloapi().createCard(card, listId).execute().body();
        cardId = newCard.getId();
    }

    @BeforeGroups("UI_Tests")
    public void setUpUI(){
        //Setting up driver and browser
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        //Getting to Home page
        HomePage homePage = new HomePage(driver);
        homePage.openPage(homePage.url);
        homePage.loginLink.click();

        //Getting to Login page
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        //Getting to Board page
        ProfilePage profilePage = new ProfilePage(driver);
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.presenceOfElementLocated(profilePage.boardLink.getBy()));
        profilePage.boardLink.click();
    }

    @AfterGroups("UI_Tests")
    public void tearDown(){
        //Closing driver
        driver.quit();
    }

    @AfterTest
    public void closeAll() throws IOException {
        //Deleting Board
        retrofitBuilder.getTrelloapi().deleteBoard(boardId, board.getKey(), board.getToken()).execute();
    }
}
