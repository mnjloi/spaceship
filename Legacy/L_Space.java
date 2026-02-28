package Legacy;

import java.util.Random;


class L_Space {

    public L_Planet root;


    // randomly generate space
    public L_Space(){

        Random r = new Random();

        int neighbors;

        do {
            neighbors = r.nextInt(3);
        } while (neighbors == 0);

        this.root = new L_Planet(neighbors,"root");

        fillNeighborhood(root);

        System.out.println("done building \n \n \n ");

    }

    private void fillNeighborhood(L_Planet root){
        if (root.num_adjs == 0) { return; }

        Random r = new Random();
        int neighbors;

        for (int i = 0; i < root.num_adjs; i++) {
            neighbors = r.nextInt(3);
            L_Planet n = new L_Planet(neighbors, "a");

            fillNeighborhood(n);

            root.add_neighbor(n);
        }

    }
    

}