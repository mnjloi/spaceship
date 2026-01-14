import java.util.Random;


class Space{

    public Planet root;


    // randomly generate space
    public Space(){

        Random r = new Random();

        int neighbors;

        do {
            neighbors = r.nextInt(3);
        } while (neighbors == 0);

        this.root = new Planet(neighbors,"root");

        fillNeighborhood(root);

        System.out.println("done building \n \n \n ");

    }

    private void fillNeighborhood(Planet root){
        if (root.num_adjs == 0) { return; }

        Random r = new Random();
        int neighbors;

        for (int i = 0; i < root.num_adjs; i++) {
            neighbors = r.nextInt(3);
            Planet n = new Planet(neighbors, "a");

            fillNeighborhood(n);

            root.add_neighbor(n);
        }

    }
    

}