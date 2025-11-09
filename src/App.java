
import java.util.HashMap;
import java.util.Scanner;

public class App {

    static int menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Adicionar Vértice");
        System.out.println("2. Adicionar Aresta");
        System.out.println("3. Mostrar Grafo");
        System.out.println("4. Verificar Alcance");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
        int op = scanner.nextInt();
        return op;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Cidade> cepCidades = new HashMap<>();
        Grafo<Cidade> grafo = new Grafo<>();
        int opcao;
        
        do {
            System.out.println("\n--- Menu --- Pressione uma tecla para continuar ---");
            scanner.nextLine();
            opcao = menu();
            
            switch (opcao) {
                case 1:
                    System.out.println("Entre com nome, estado e cep da cidade:");
                    System.out.print("Nome:");
                    String nomeCidade = scanner.nextLine();
                    System.out.print("Estado:");
                    String estado = scanner.nextLine();
                    System.out.print("CEP:");
                    int cep = scanner.nextInt();
                    Cidade novaCidade = new Cidade(nomeCidade, estado, cep);
                    if (grafo.adicionarVertice(novaCidade) == false) {
                        System.out.println("Vertice já existente");
                    } else {
                        System.out.println("Vertice adicionado");
                        cepCidades.put(cep, novaCidade);
                    }
                    break;
                case 2:
                    System.out.print("Digite o vértice de origem: ");
                    int cepOrigem = scanner.nextInt();
                    Cidade origem = cepCidades.get(cepOrigem);
                    System.out.println("Origem selecionada: " + origem);
                    System.out.print("Digite o vértice de destino: ");
                    int cepDestino = scanner.nextInt();
                    Cidade destino = cepCidades.get(cepDestino);
                    System.out.println("Destino selecionado: " + destino);
                    System.out.print("Digite o peso da aresta: ");
                    int peso = scanner.nextInt();
                    if (grafo.adicionarAresta(origem, destino, peso)) {
                        System.out.println("Aresta adicionada com sucesso.");
                    } else {
                        System.out.println("Erro ao adicionar aresta.");
                    }
                    break;
                case 3:
                    grafo.mostrarGrafo();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;

            }

        } while (opcao != 0);

    }
}
