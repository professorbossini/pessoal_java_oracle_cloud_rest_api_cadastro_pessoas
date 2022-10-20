import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PessoaService {
  private HttpClient client = HttpClient.newHttpClient();

  //construtor gerado apenas para campos que requerem tratamento
  //por ser final, precisa ser inicializado
  private final String url;

  public void listar() throws Exception {
    HttpRequest req = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .build();
    var res = client.send(req, BodyHandlers.ofString());
    System.out.println(res.body());
  }
  
}
