

class Planet{

    public String name;
    public int num_adjs;
    public Planet[] adjs;

    // no-neighbor planet
    public Planet(int num_neighbors, String name){
        this.num_adjs = num_neighbors;
        this.name = name;
        this.adjs = new Planet[num_adjs](1, "ab");
    }

    public void print(){
        System.out.println(name);
        
    }

}