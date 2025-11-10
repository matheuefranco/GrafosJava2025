
import java.lang.reflect.Array;
import java.util.*;

public class Grafo<T> {

    private HashMap<T, LinkedList<Aresta>> meuGrafo;
    private ArrayList<T> visitados;

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

    // adicionar parametro para definir se é dirigido ou não
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
    public ArrayList<T> buscaProfundidadeDFS(T origem){
        visitados = new ArrayList<>();
        explorarDFS(origem, visitados);
        return visitados; 
    }

    private void explorarDFS(T verticeAtual, ArrayList<T> visitados){
        visitados.add(verticeAtual);
        LinkedList<Aresta> adjacencias = meuGrafo.get(verticeAtual);
        for(Aresta adjacente: adjacencias)
            if(!visitados.contains(adjacente.vertice))
                 explorarDFS((T)adjacente.vertice, visitados);

    }

    public boolean alcance(T origem, T destino){
        visitados = new ArrayList<>();
        boolean existe = existeCaminho(origem, destino, visitados);
        System.out.println("*** Percurso de visitados ***");
        System.out.println(visitados);
        return existe; 
    }

    private boolean existeCaminho(T verticeAtual, T destino, ArrayList<T> visitados){
        if(verticeAtual.equals(destino))
            return true;
        visitados.add(verticeAtual);
        LinkedList<Aresta> adjacencias = meuGrafo.get(verticeAtual);
        for(Aresta adjacente: adjacencias)
            if(!visitados.contains(adjacente.vertice))
                return existeCaminho((T)adjacente.vertice, destino, visitados);

        return false;
    }

}
