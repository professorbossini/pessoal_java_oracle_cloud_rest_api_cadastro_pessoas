import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pessoa {
  private int codigo;
  private String nome;
  private int idade;
  private String hobby;

  //apenas para testar
  //depois do teste, pode apagar
  public static void main(String[] args) {
    Pessoa p = new Pessoa();
    p.setNome("João");
    System.out.println(p.getNome());
  }
}
