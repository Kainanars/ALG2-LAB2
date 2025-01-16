import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class ExerciseA {

  // Número máximo de itens no menu, custo máximo e pedidos máximos
  static final int MAX_ITENS_MENU = 110;
  static final int MAX_CUSTO = 30010;
  static final int MAX_PEDIDOS = 1010;

  static int[] custosMenu = new int[MAX_ITENS_MENU];
  static int[] tabelaCustos = new int[MAX_CUSTO];

  // Função recursiva para imprimir os itens do pedido
  static void imprimirItensPedido(int custoTotal, PrintWriter escritor) {
    if (custoTotal == custosMenu[tabelaCustos[custoTotal] - 1]) {
      escritor.print(tabelaCustos[custoTotal]);
      return;
    }
    imprimirItensPedido(custoTotal - custosMenu[tabelaCustos[custoTotal] - 1], escritor);
    escritor.print(" " + tabelaCustos[custoTotal]);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter escritor = new PrintWriter(System.out);

    // Le o número de itens do menu
    int numeroItensMenu = Integer.parseInt(leitor.readLine());
    String[] custos = leitor.readLine().split(" ");
    for (int i = 0; i < numeroItensMenu; i++) {
      custosMenu[i] = Integer.parseInt(custos[i]);
    }

    // Le o número de pedidos
    int numeroPedidos = Integer.parseInt(leitor.readLine());
    int[] custosPedidos = new int[numeroPedidos];
    String[] pedidos = leitor.readLine().split(" ");
    for (int i = 0; i < numeroPedidos; i++) {
      custosPedidos[i] = Integer.parseInt(pedidos[i]);
    }
    Arrays.fill(tabelaCustos, 0);

    // Preenche a tabela de custos com base nos itens do menu
    for (int indiceMenu = 0; indiceMenu < numeroItensMenu; indiceMenu++) {
      int custoItem = custosMenu[indiceMenu];

      if (tabelaCustos[custoItem] == 0) {
        tabelaCustos[custoItem] = indiceMenu + 1;
        for (int custoAtual = 0; custoAtual < MAX_CUSTO - custoItem; custoAtual++) {
          if (tabelaCustos[custoAtual] != 0) {
            if (tabelaCustos[custoAtual] == -1) {
              tabelaCustos[custoAtual + custoItem] = -1;
            } else if (tabelaCustos[custoAtual + custoItem] != 0) {
              tabelaCustos[custoAtual + custoItem] = -1;
            } else {
              tabelaCustos[custoAtual + custoItem] = indiceMenu + 1;
            }
          }
        }
      } else {
        tabelaCustos[custoItem] = -1;
        for (int custoAtual = 0; custoAtual < MAX_CUSTO - custoItem; custoAtual++) {
          if (tabelaCustos[custoAtual] != 0) {
            tabelaCustos[custoAtual + custoItem] = -1;
          }
        }
      }
    }

    // Processa cada pedido e imprime o resultado
    for (int i = 0; i < numeroPedidos; i++) {
      int custoTotal = custosPedidos[i];
      if (tabelaCustos[custoTotal] == 0) {
        escritor.println("Impossible");
      } else if (tabelaCustos[custoTotal] == -1) {
        escritor.println("Ambiguous");
      } else {
        imprimirItensPedido(custoTotal, escritor);
        escritor.println();
      }
    }

    leitor.close();
    escritor.close();
  }
}
