package StarSystems;

public class Planet {
    public int pID;
    public String pName;
    public Culture inhabitants;

    public Planet(int ID, String name, Culture c){
        this.pID = ID;
        this.inhabitants = c;
        this.pName = name;
    }

    public Planet(int ID, String name){
        this.pID = ID;
        this.inhabitants = null;
        this.pName = name;
    }

    public void tabPrint(int t){
        Star.tp(t);
        System.out.println(pID + " - " + pName);
        Star.tp(t);
        System.out.println(inhabitants == null ? "no inhabitants" : "Inhabitant: " + inhabitants.cName);
    }

}
