import StarSystems.Culture;
import StarSystems.StarSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    public Ship spaceship;
    public List<StarSystem> starSystemList;
    public List<Culture> cultures;
    public static int maxStars = 5;
    public static int maxCultures = 5;

    public Game() {
        cultures = new ArrayList<>();
        starSystemList = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < r.nextInt(2,maxCultures); i++) {
            cultures.add(new Culture(i));
        }

        starSystemList.add(
                new StarSystem(1, r.nextInt(1,maxStars),cultures)
        );

    }

    public void print(){
        for (StarSystem ssystem : starSystemList){
            ssystem.tabPrint(1);
        }
    }


}
