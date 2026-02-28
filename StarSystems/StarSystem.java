package StarSystems;

import DataTypes.Graph;
import DataTypes.Node;

import java.util.List;
import java.util.Random;

public class StarSystem {
    public int sysID;
    public Graph<Star> stars = new Graph<Star>();

    public StarSystem(int ID, int numStars, List<Culture> cultures) {

        this.sysID = ID;

        Random r = new Random();
        for (int i = 0; i < numStars; i++) {
            int n = r.nextInt(1,9);

            Node<Star> starN = new Node<>(new Star(
                    n, (ID*1000+i),cultures
            ));

            stars.add_node(starN);
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
