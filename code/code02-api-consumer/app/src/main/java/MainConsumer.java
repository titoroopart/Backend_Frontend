public class MainConsumer {

  public static void main(String[] args){
    // ApiConsumer api = new ApiConsumer();
    // ApiConnection api = new ApiConnection();
    // ApiProduct api = new ApiProduct();
    ApiNorris api = new ApiNorris();
    api.connection();
  }
}
