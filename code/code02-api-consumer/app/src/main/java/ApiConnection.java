import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.Call;
import java.io.IOException;

public class ApiConnection {

  public static void connection(){
    Retrofit retrofit = new Retrofit.Builder()
      .baseUrl("https://jsonplaceholder.typicode.com/")
      .addConverterFactory(ScalarsConverterFactory.create()) // Usamos String en lugar de JSON
      .build();

    GetList apiget = retrofit.create(GetList.class);
    try {

    String response = apiget.getPost(1).execute().body();
    System.out.println(response);
    } catch(IOException e){
      System.out.println("Error");
    } finally {
      System.exit(0);
    }
  }

  private interface GetList {
      @GET("posts/{id}")
      Call<String> getPost(@Path("id") int id); // Retorna String en lugar de objeto
  }
}
