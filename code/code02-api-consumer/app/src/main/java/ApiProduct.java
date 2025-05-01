import java.io.IOException;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;

public class ApiProduct {

  public static void connection(){
    Retrofit retro = new Retrofit.Builder()
      .baseUrl("https://api.chucknorris.io/jokes/")
      .addConverterFactory(ScalarsConverterFactory.create())
      .build();

    getConnection apiRequest = retro.create(getConnection.class);

    try {
      String response = apiRequest.getPost().execute().body();
      System.out.println(response);
    } catch (IOException e) {
      System.out.println("Error de conexion");
    } finally {
      System.exit(0);
    }
  }

  public interface getConnection {
    @GET("random")
    Call<String> getPost();
}
}
