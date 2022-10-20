import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import java.io.FileInputStream;
import java.util.Properties;

public class App {
  public static void main(String[] args) throws Exception {
    PessoaService service = new PessoaService();
    service.listar();
    //comente por enquanto
    // int op;
    // String menu = "1-Cadastrar\n2-Atualizar\n-3-Listar\n4-Remover\n0-Sair";
  }
}
    // Properties properties = new Properties();
    // properties.load(new FileInputStream("src/app.properties"));
    // System.out.println(properties.getProperty("URL"));

    // do {
    //   op = parseInt(showInputDialog(menu));
    //   switch (op) {
    //     case 1: {
    //       break;
    //     }
    //     case 2: {
    //       break;
    //     }
    //     case 3: {
    //       break;
    //     }
    //     case 4: {
    //       break;
    //     }
    //     case 0: {
    //       showMessageDialog(null, "Até mais");
    //       break;
    //     }
    //     default: {
    //       showMessageDialog(null, "Opção inválida");
    //       break;
    //     }
    //   }
    // } while (op != 0);
