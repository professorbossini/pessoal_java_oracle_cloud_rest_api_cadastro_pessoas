import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

public class PessoaService {
  private HttpClient client = HttpClient.newHttpClient();
  private String url = "https://g3e99fc358a3389-pessoahobbiesrest.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/pessoas/";

  public void listar() throws Exception {
    HttpRequest req = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .build();
    var res = client.send(req, BodyHandlers.ofString());
    System.out.println(res.body());
  }
}
