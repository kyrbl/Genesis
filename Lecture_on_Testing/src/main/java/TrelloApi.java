import retrofit2.Call;
import retrofit2.http.*;

public interface TrelloApi {

    @POST("/1/boards/")
    Call<Board> createBoard(@Body Board board);

    @PUT("/1/boards/{id}")
    Call<Board> updateBoard(@Body Board board, @Path("id") String id);

    @DELETE("/1/boards/{id}")
    Call<Board> deleteBoard(@Path("id") String id, @Query("key") String key, @Query("token") String token);

    @POST("/1/boards/{id}/lists")
    Call<Board> createList(@Body Board board, @Path("id") String id);

    @POST("/1/cards")
    Call<Board> createCard(@Body Board board, @Query("idList") String idList);

    @PUT("/1/cards/{id}")
    Call<Board> updateCard(@Body Board board, @Path("id") String id);

    @GET("/1/cards/{id}")
    Call<Board> getCard(@Path("id") String id, @Query("key") String key, @Query("token") String token);

    @DELETE("/1/cards/{id}")
    Call<Board> deleteCard(@Path("id") String id, @Query("key") String key, @Query("token") String token);
}
