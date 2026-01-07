
class Ship{

    // health
    public int max_hull;
    public int current_hull;
    // fuel
    public int fuel;
    
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


}