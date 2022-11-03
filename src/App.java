import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import java.io.FileInputStream;
import java.util.Properties;

import javax.swing.JOptionPane;
import java.util.*;
public class App {
  public static void main(String[] args) throws Exception {
    Properties properties = new Properties();
    properties.load(new FileInputStream("src/app.properties"));
    PessoaService service =
      new PessoaService(properties.getProperty("URL"));
    int op;
    String menu = "1-Cadastrar\n2-Atualizar\n-3-Listar\n4-Remover\n0-Sair";
    do {
      op = parseInt(showInputDialog(menu));
      switch (op) {
        case 1: {
          String nome = JOptionPane.showInputDialog("Qual o nome?");
          int idade =
            Integer.parseInt(JOptionPane.showInputDialog("Qual a idade?"));
          String hobby = JOptionPane.showInputDialog("Qual o hobby?");
          Pessoa p = new Pessoa();
          p.setNome(nome);
          p.setIdade(idade);
          p.setHobby(hobby);
          service.cadastrar(p);
          JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso!");
          break;
        }
        case 2: {
          break;
        }
        case 3: {
          List <Pessoa> pessoas = service.listar();
          JOptionPane.showMessageDialog(null, pessoas);
          break;
        }
        case 4: {
          break;
        }
        case 0: {
          showMessageDialog(null, "Até mais");
          break;
        }
        default: {
          showMessageDialog(null, "Opção inválida");
          break;
        }
      }
    } while (op != 0);
  }
}

