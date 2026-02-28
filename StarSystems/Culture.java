package StarSystems;

public class Culture {
    public int cID;
    public int affinity;
    public String cName;

    public Culture(String name, int ID){
        this.affinity = 0;
        this.cID = ID;
        this.cName = name;
    }
}
