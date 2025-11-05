
import java.util.*;

public class Grafo<T> {

    private HashMap<T, LinkedList<Aresta>> meuGrafo;

    public Grafo() {
        meuGrafo = new HashMap<>();
    }

    public boolean adicionarVertice(T vertice) {
        if (!meuGrafo.containsKey(vertice)) {
            meuGrafo.put(vertice, new LinkedList<>());
            return true;
        }
        return false;
    }

    public boolean adicionarAresta(T origem, T destino, int peso) {
        if (meuGrafo.containsKey(origem)
                && meuGrafo.containsKey(destino)) {
            meuGrafo.get(origem).add(new Aresta<T>(destino, peso));
            meuGrafo.get(destino).add(new Aresta<T>(origem, peso));
            return true;
        }// fim if
        return false;
    }

    public void mostrarGrafo() {
        for (Map.Entry<T, LinkedList<Aresta>> registro : meuGrafo.entrySet()) {
            T vertice = registro.getKey();
            LinkedList<Aresta> arestas = registro.getValue();
            System.out.print("Vértice " + vertice + ": ");
            for (Aresta aresta : arestas) {
                System.out.print("-> (Destino: " + aresta.vertice + ", Peso: " + aresta.peso + ") ");
            }
            System.out.println("\n");
        }
    }

}
