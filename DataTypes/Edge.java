package DataTypes;

public class Edge<T> {

    public Node<T> a;
    public Node<T> b;

    public Edge(T a, T b) {
        this.a = new Node<T>(a);
        this.b = new Node<T>(b);
    }

    public Edge(Node<T> a, Node<T> b) {
        this.a = a;
        this.b = b;
    }
}
