package StarSystems;

import DataTypes.Edge;
import DataTypes.Graph;
import DataTypes.Node;

import java.util.List;
import java.util.Random;

public class StarSystem {
    public int sysID;
    public Graph<Star> stars = new Graph<>();
    public static int maxPlanets = 5;


    public StarSystem(int ID, int numStars, List<Culture> cultures) {

        this.sysID = ID;

        Random r = new Random();
        for (int i = 0; i < numStars; i++) {
            int n = r.nextInt(1,maxPlanets);

            Node<Star> starN = new Node<>(new Star(
                    n, (ID*1000+i),cultures
            ));

            stars.add_node(starN);
        }

        for (Node<Star> starNode: stars.V){
            if (stars.num_neighbors(starNode) == 0){
                Node<Star> randNode;
                do {
                    randNode = stars.V.get(r.nextInt(stars.V.size()));
                } while (starNode == randNode);
                stars.E.addLast(new Edge<>(starNode,randNode));
            }
            for (int i = 0; i < r.nextInt(0,(int)(stars.V.size() * 0.5));
                 i++) {
                try {
                    Node<Star> randNode;
                    do {
                        randNode = stars.V.get(r.nextInt(stars.V.size()));
                    } while (starNode == randNode);
                    stars.E.addLast(new Edge<>(starNode,randNode));
                } catch (Exception _) {
                }
            }
        }

    }

    public void tabPrint(int t){
        Star.tp(t);
        System.out.println("System ID: " + sysID);
        System.out.println();
        Star.tp(t);
        System.out.println("Stars: ");
        for (Node<Star> starNode : stars.V) {
            System.out.println();
            starNode.key.tabPrint(t+1);
            Star.tp(t+1);
            System.out.println("Number of neighbors: " + stars.num_neighbors(starNode));
        }
    }

}
