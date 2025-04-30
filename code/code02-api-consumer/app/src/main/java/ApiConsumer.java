import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.Call;
import java.io.IOException;

public class ApiConsumer {

    public static void consumer() {
        // 1. Configurar Retrofit
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(ScalarsConverterFactory.create()) // Usamos String en lugar de JSON
            .build();

        // 2. Crear implementación dinámica de la API
        JsonPlaceholderAPI api = retrofit.create(JsonPlaceholderAPI.class);

        try {
            // 3. Hacer la llamada
            String response = api.getPost(1).execute().body();
            System.out.println("✅ Respuesta:\n" + response);
        } catch (IOException e) {
            System.err.println("❌ Error: " + e.getMessage());
        } finally {
            System.exit(0);
        }
    }

    // Interface interna (solo para este ejemplo)
    private interface JsonPlaceholderAPI {
        @GET("posts/{id}")
        Call<String> getPost(@Path("id") int id); // Retorna String en lugar de objeto
    }
}
