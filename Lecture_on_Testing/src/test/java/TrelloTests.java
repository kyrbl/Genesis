/*
-----------------------------------COMMENTS--------------------------------

В тестах реших сделать board и retrofitBuilder приватными полями класса.
Так не приходиться создавать в методах локальный объекты каждый раз.
Имена для создания и модификации досок/списков/карточек я передаю как атрибуты board,
а следовательно не в Query, а в Body.

*/
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TrelloTests {

    private String boardId;
    private String listId;
    private String cardId;
    private RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
    private Board board = new Board();

    @Test(priority = 1)
    public void checkCreateBoard() throws IOException {

        board.setName("New Board");

        Board createdBoard = retrofitBuilder.getTrelloapi().createBoard(board).execute().body();

        boardId = createdBoard.getId();

        Assert.assertEquals(createdBoard.getName(), board.getName());
    }

    @Test(priority = 2)
    public void checkUpdateTest() throws IOException {

        String updateName = "Updated board name";
        board.setName(updateName);

        Board updatedBoard = retrofitBuilder.getTrelloapi().updateBoard(board, boardId).execute().body();

        Assert.assertEquals(updatedBoard.getName(), updateName);
    }

    @Test(priority = 3)
    public void checkCreateList() throws IOException {

        board.setName("New List");

        Board newList = retrofitBuilder.getTrelloapi().createList(board, boardId).execute().body();

        listId = newList.getId();

        Assert.assertEquals(newList.getName(), board.getName());
    }

    @Test(priority = 4)
    public void checkCreateCard() throws IOException {

        board.setName("New Card");

        Board newCard = retrofitBuilder.getTrelloapi().createCard(board, listId).execute().body();

        cardId = newCard.getId();

        Assert.assertEquals(newCard.getName(), board.getName());
    }

    @Test(priority = 5)
    public void checkUpdateCard() throws  IOException{

        board.setName("Updated Name");

        Board updatedCard = retrofitBuilder.getTrelloapi().updateCard(board, cardId).execute().body();

        Assert.assertEquals(updatedCard.getName(), board.getName());
    }

    @Test(priority = 6)
    public void checkGetCard() throws IOException{

        int code = retrofitBuilder.getTrelloapi().getCard(cardId, board.getKey(), board.getToken()).execute().code();

        Assert.assertEquals(code, 200);
    }

    @Test(priority = 7)
    public void checkDeleteCard() throws IOException {

        int code = retrofitBuilder.getTrelloapi().deleteCard(cardId, board.getKey(), board.getToken()).execute().code();

        Assert.assertEquals(code, 200);
    }

    @Test(priority = 8)
    public void checkDeleteTest() throws IOException {

        int code = retrofitBuilder.getTrelloapi().deleteBoard(boardId, board.getKey(), board.getToken()).execute().code();

        Assert.assertEquals(code, 200);
    }
}
