package ship;

import DataTypes.Node;
import StarSystems.*;

import java.util.ArrayList;

public class Ship{

    // health
    public int max_hull;
    public int current_hull;
    // fuel
    public int fuel;
    // parts
    public ArrayList<Part> parts;
    // location
    public Star location;

    public Ship(int max){
        this.max_hull = max;
        this.current_hull = max;
        this.fuel = 10;
    }

    public Ship(int max, int starting_fuel){
        this.max_hull = max;
        this.current_hull = max;
        this.fuel = starting_fuel;
    }

    public boolean star_jump(Star dest){
        StarSystem sys = location.sys;
        if (!sys.hasStar(dest)){
            System.out.print("destination not in current system. do you mean to system-jump?");
            return false;
        }
        Node<Star> node_loc = new Node<Star>(this.location), node_dest = new Node<Star>(dest);
        int distance = sys.stars.distance(node_loc, node_dest);
        if (fuel < get_fuel_per_step()*distance) return false;
        this.location = dest;
        return true;
    }

    public double get_fuel_per_step(){
        double tot_weight = 0, fuel_efficiency = 0;
        for (Part current_part : parts) {
            tot_weight += current_part.weight;
            if (current_part.getClass() == Engine_Part.class) {
                Engine_Part current_engine_part = (Engine_Part)current_part;
                fuel_efficiency += current_engine_part.fuel_consumption;
            }
        }
        return (tot_weight / fuel_efficiency);
    }

}