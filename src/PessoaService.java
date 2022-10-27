import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

import org.json.JSONArray;
import org.json.JSONObject;

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
    // System.out.println(res.body());
    //obtemos a raiz do resultado que é um objeto JSON
    JSONObject raiz = new JSONObject(res.body());
    // System.out.println(raiz);
    // dela pegamos a propriedade items, que é um Array, uma coleção
    JSONArray items = raiz.getJSONArray("items");
    // System.out.println(items);
    //iteramos sobre a coleção
    //cada valor dentro dela é um objeto JSON
    for (int i = 0; i < items.length(); i++){
      JSONObject pessoa = items.getJSONObject(i);
      // System.out.println(pessoa);
      //de cada pessoa, pegamos nome, idade e hobby
      System.out.println("Nome: " + pessoa.getString("nome"));
      System.out.println("Idade: " + pessoa.getInt("idade"));
      System.out.println("Hobby: " + pessoa.getString("hobby"));
      System.out.println("**************************");
    }
  }  
}
