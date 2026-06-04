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

    public boolean has_node(Node<T> node){
        return V.contains(node);
    }

    public int distance(Node<T> source, Node<T> dest){
        ArrayList<Node<T>> new_nodes = new ArrayList<>();
        ArrayList<Node<T>> old_nodes = new ArrayList<>();
        int counter = 0;
        new_nodes.addLast(source);
        while(!new_nodes.contains(dest)) {
            if (new_nodes.isEmpty()) return -1;
            ArrayList<Node<T>> pot_nodes = new ArrayList<>();
            counter++;
            for (Node<T> node:new_nodes){
                pot_nodes.addAll(this.neighbors(node));
            }
            pot_nodes.removeAll(old_nodes);
            pot_nodes.removeAll(new_nodes);

            old_nodes.addAll(new_nodes);
            new_nodes = pot_nodes;
        }
        return counter;
    }
}
