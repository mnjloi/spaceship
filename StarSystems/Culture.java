package StarSystems;

import DataTypes.NameGen;

import java.util.Random;

public class Culture {
    public int cID;
    public int affinity;
    public String cName;

    public Culture(String name, int ID){
        this.affinity = 0;
        this.cID = ID;
        this.cName = name;
    }

    public Culture(int ID) {
        this.affinity = 0;
        this.cID = ID;

        NameGen gen = new NameGen();
        Random r = new Random();

        this.cName = gen.generateName(r.nextInt(1,5));
    }
}
