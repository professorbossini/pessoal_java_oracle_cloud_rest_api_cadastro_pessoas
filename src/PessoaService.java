import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.json.JSONArray;
import org.json.JSONObject;

import lombok.RequiredArgsConstructor;

import java.util.*;

@RequiredArgsConstructor
public class PessoaService {
  private HttpClient client = HttpClient.newHttpClient();

  //construtor gerado apenas para campos que requerem tratamento
  //por ser final, precisa ser inicializado
  private final String url;

  //tipo de retorno muda
  public List<Pessoa> listar() throws Exception {
    //lista para armazenar as pessoas
    List <Pessoa> pessoas = new ArrayList<>();
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
      JSONObject pessoaJSON = items.getJSONObject(i);
      Pessoa pessoa = new Pessoa();
      pessoa.setNome(pessoaJSON.getString("nome"));
      pessoa.setIdade(pessoaJSON.getInt("idade"));
      pessoa.setHobby(pessoaJSON.getString("hobby"));
      //A cada iteração, adicionamos a pessoa da vez à coleção
      pessoas.add(pessoa);   
    }
    //devolvemos a coleção no final
    return pessoas;
  }

  public void cadastrar(Pessoa p) throws Exception{
    JSONObject pessoaJSON = new JSONObject();
    pessoaJSON.put("nome", p.getNome());
    pessoaJSON.put("idade", p.getIdade());
    pessoaJSON.put("hobby", p.getHobby());
    HttpRequest req = HttpRequest.newBuilder()
      .uri(URI.create(url))
      .header("Content-Type", "application/json")
      .POST(
        HttpRequest.BodyPublishers.ofString(pessoaJSON.toString())
      )
      .
      build();
      client.send(req, HttpResponse.BodyHandlers.ofString());
  }  
}
