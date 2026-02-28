package DataTypes;

public class Edge<T> {

    public Node<T> a;
    public Node<T> b;

    public Edge(Node<T> a, Node<T> b) {
        this.a = a;
        this.b = b;
    }

    public Edge<T> flip() {
        return new Edge<>(b,a);
    }
}
