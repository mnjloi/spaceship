import java.util.Random;

class Planet{

    public String name;
    public int num_adjs;
    public Planet[] adjs;

    // no-neighbor planet
    public Planet(int num_neighbors, String name){
        this.num_adjs = num_neighbors;
        this.name = name;
        this.adjs = new Planet[num_adjs];
    }

    // add neighbor
    public int add_neighbor(Planet neighbor){
        for(int i = 0; i < num_adjs; i++){
            if (adjs[i] == null) {
                adjs[i] = neighbor;
                return 1; // done!
            }
        }
        // no space for the neighbor
        System.out.println("No space for more neighbors!");
        return -1; // done!
    }


    // prints the hierarchy of planets
    public void print(int tabs){
        System.out.println(":" + name + " ("+num_adjs + ") {");
        for (int i = 0; i < num_adjs; i++) {
            pTabs(tabs);
            System.out.print(i);
            if (adjs[i] != null){
                adjs[i].print(tabs + 1);
            }
            else {
                System.out.println('E');
            }
        }
        pTabs(tabs);
        System.out.println("}");
    }

    // pads with t (-)s
    public void pTabs(int tabs){
        for (int t = 0; t < tabs; t++) {
            System.out.print("-");
        }
    }

}