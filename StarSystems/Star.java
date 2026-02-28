package StarSystems;

import DataTypes.NameGen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Star {
    public int sID;
    public String sName;
    public ArrayList<Planet> P = new ArrayList<Planet>();

    public Star(int n, int ID, List<Culture> cultures) {
        this.sID = ID;

        NameGen gen = new NameGen();
        Random r = new Random();

        this.sName = gen.generateStarName();

        if (r.nextBoolean()){
            for (int i = 0; i < n; i++) {
                String name = (sName + "-" + (i+1));
                P.add(new Planet((ID*1000+i), name));
            }
        }
        else {

            int len = cultures.size();
            boolean flag = true;

            for (int i = 0; i < n - 1; i++) {
                int c = makePlanet(n, ID, cultures);
                if (c>0) { flag = false; }
            }
            if (flag) {
                String name = gen.generateName(r.nextInt(1,5));
                int c = r.nextInt(1, len);
                P.add(new Planet((ID*1000+n), name, cultures.get(c)));
            }
            else {
                makePlanet(n, ID, cultures);
            }
        }
    }

    public boolean inhabited(){
        for (Planet planet : P) {
            if (planet.inhabitants != null) {
                return true;
            }
        }
        return false;
    }

    public int makePlanet(int n, int ID, List<Culture> cultures) {
        NameGen gen = new NameGen();
        Random r = new Random();

        int len = cultures.size();

        String name = gen.generateName(r.nextInt(1,5));
        int c = r.nextInt(-4*len, len);

        P.add(new Planet((ID*1000+n), name, (c>0 ? cultures.get(c) : null)));

        return c;
    }

    public void tabPrint(int t){
        tp(t);
        System.out.println(sID + " - " + sName);
        tp(t);
        System.out.println("Planets: ");
        for (Planet planet : P){
            System.out.println();
            planet.tabPrint(t+1);
        }
    }

    static void tp(int t) {
        for (int i = 0; i < t; i++) {
            System.out.print(" - ");
        }
    }

}
