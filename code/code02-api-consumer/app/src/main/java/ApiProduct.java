import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;

public class ApiProduct {

  public static void connection(){
    Retrofit retro = new Retrofit.Builder()
      .baseUrl("https://api.chucknorris.io/jokes/")
      .addConverterFactory(ScalarsConverterFactory.create()) // Usamos String en lugar de JSON
      .build();

    getConnection apiRequest = retro.create(getConnection.class);

    try {
      String response = apiRequest.getPost().execute().body();
      System.out.println(response);
    } catch (IOException e) {
      //TODO: handle exception
      System.out.println("Error de conexion");
    }
  }

  public interface getConnection {
    @GET("random")
    Call<String> getPost();
}
}
