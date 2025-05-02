import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;

public class ApiNorris {

  public static void connection(){
    Retrofit retrofi = new Retrofit.Builder()
    .baseUrl("https://api.chucknorris.io/")
    .addConverterFactory(ScalarsConverterFactory.create()) // Para String
    .build();
    getApi api = retrofi.create(getApi.class);
    try {
      String response = api.getPost().execute().body();
      System.out.println(response);
    } catch (Exception e) {
      System.out.println("Error connecting api.");
      System.out.println(e);
    } finally {
      System.exit(0);
    }

  }

  public interface getApi {
    @GET("jokes/random")
      //TODO: handle exception
    Call<String> getPost();
  }
}
