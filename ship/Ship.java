package ship;

import DataTypes.Node;
import StarSystems.*;

import java.util.ArrayList;
import java.util.List;

public class Ship{

    // health
    public int max_hull;
    public int current_hull;
    // fuel
    public int fuel;
    public int hyperfuel;
    // parts
    public ArrayList<Part> parts;
    // location
    public Star location;

    public Ship(int max){
        this.max_hull = max;
        this.current_hull = max;
        this.fuel = 10;
        this.hyperfuel = 3;
    }

    public Ship(int max, int starting_fuel, int starting_hyperfuel){
        this.max_hull = max;
        this.current_hull = max;
        this.fuel = starting_fuel;
        this.hyperfuel = starting_hyperfuel;
    }

    public void info(){
        System.out.printf("""
                hull: %d/%d
                remaining fuel: %d regular, %d hyper
                current location: %s in system %s
                """, current_hull, max_hull,
                fuel, hyperfuel,
                location.sName, location.sys.sysName);
    }

    public boolean star_jump(Star dest){
        StarSystem sys = location.sys;
        if (!sys.hasStar(dest)){
            System.out.println("destination not in current system. do you mean to system-jump?");
            return false;
        }
        Node<Star> node_loc = new Node<Star>(this.location), node_dest = new Node<Star>(dest);
        int distance = sys.stars.distance(node_loc, node_dest);
        if (fuel < get_fuel_per_step()*distance) return false;
        this.location = dest;
        return true;
    }

    public boolean system_jump(StarSystem dest, List<StarSystem> starSystemList){
        if (dest == location.sys){
            System.out.println("ship already in destination system.");
            return false;
        }
        if (hyperfuel > 0){
            if (starSystemList.contains(dest)) {
                location.sys = dest;
                System.out.println("jumped to the destination system.");
                return true;
            }
            System.out.println("no such system - need to generate it first.");
        }
        return false;
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