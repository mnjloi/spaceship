package DataTypes;

import java.util.ArrayList;

public class Node<T> {

    public T key;
    public ArrayList<Node<T>> neighbors;

    public Node(T key){
        this.key = key;
        this.neighbors = new ArrayList<Node<T>>();
    }

}
