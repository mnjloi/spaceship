package DataTypes;

import StarSystems.*;

import java.util.Objects;

public class starFinder {

    public Star find_star_from_name(StarSystem sys, String dest){
        for (Node<Star> star_node : sys.stars.V){
            Star s = star_node.key;
            String name = s.sName;
            if (Objects.equals(dest, name)){
                return (s);
            }
        }
        return (null);
    }
    public Star find_star_from_id(StarSystem sys, int dest){
        for (Node<Star> star_node : sys.stars.V){
            Star s = star_node.key;
            int id = s.sID;
            if (id == dest){
                return (s);
            }
        }
        return (null);
    }

    public Star find_star(StarSystem sys, String dest){
        int id = has_id();
        if(id != 0){
            return find_star_from_id(sys, id);
        } else {
            return find_star_from_name(sys, dest);
        }
    }

    public int has_id(String text) {
        char[] myArray = text.toCharArray();

        char[] id_arr = {'i', 'd', '-'};
        if (){

        }
        return 0;
    }
}
