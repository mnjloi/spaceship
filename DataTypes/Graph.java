package DataTypes;

import java.util.ArrayList;

public class Graph<T> {

    public ArrayList<Node<T>> V;
    public ArrayList<Edge<T>> E;

    public Graph(){
        this.V = new ArrayList<>();
        this.E = new ArrayList<>();
    }

    public void add_node(Node<T> n){
        V.add(n);
    }

    public void add_edge(Edge<T> n){
        if (V.contains(n.a) && V.contains(n.b)){
            if (E.contains(n) || E.contains(n.flip())) {
                throw new Error("edge already exists.");
            }
            E.add(n);
        }
        else {
            throw new Error("edge contains vertices not already in graph.");
        }
    }

    public ArrayList<Node<T>> neighbors(Node<T> n){

        ArrayList<Node<T>> neighborList = new ArrayList<>();

        if (!V.contains(n)){
            throw new Error("no such node in graph.");
        }
        for (Edge<T> tEdge : E) {
            if (n == tEdge.a) {
                neighborList.add(tEdge.b);
            } else if (n == tEdge.b) {
                neighborList.add(tEdge.a);
            }
        }

        return neighborList;
    }

    public int num_neighbors(Node<T> n){

        int neighbors = 0;

        if (!V.contains(n)){
            throw new Error("no such node in graph.");
        }
        for (Edge<T> tEdge : E) {
            if (n == tEdge.a || n == tEdge.b) {
                neighbors++;
            }
        }

        return neighbors;
    }

}
