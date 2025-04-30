import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.Call;

public class ApiConnection {

  public static void connection(){
    Retrofit retrofit = new Retrofit.Builder()
      .baseUrl("https://api.example.com/")
      .addConverterFactory(ScalarsConverterFactory.create()) // Usamos String en lugar de JSON
      .build();

    // GetList apiget = retrofit.create(GetList.class);
  }

  public interface GetList {
      @GET("posts/{id}")
      Call<String> getPost(@Path("id") int id); // Retorna String en lugar de objeto
  }
}
