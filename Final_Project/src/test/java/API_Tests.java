import For_API_tests.Board;
import For_API_tests.Card;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class API_Tests  extends TestManager{

    @Test(priority = 1)
    public void checkUpdateBoard() throws IOException {
        String updateName = "Updated board name";
        board.setName(updateName);

        Board updatedBoard = retrofitBuilder.getTrelloapi().updateBoard(board, boardId).execute().body();

        Assert.assertEquals(updatedBoard.getName(), updateName);
    }

    @Test(priority = 2)
    public void checkUpdateCard() throws IOException {
        card.setName("Updated Name");

        Card updatedCard = retrofitBuilder.getTrelloapi().updateCard(card, cardId).execute().body();

        Assert.assertEquals(updatedCard.getName(), card.getName());
    }

    @Test(priority = 3)
    public void checkDeleteCard() throws IOException {
        int code = retrofitBuilder.getTrelloapi().deleteCard(cardId, card.getKey(), card.getToken()).execute().code();

        Assert.assertEquals(code, 200);
    }
}
