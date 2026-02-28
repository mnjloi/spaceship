import StarSystems.Culture;
import StarSystems.StarSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    public Ship spaceship;
    public List<StarSystem> starSystemList;
    public List<Culture> cultures;

    public Game() {
        cultures = new ArrayList<>();
        starSystemList = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < r.nextInt(1,5); i++) {
            cultures.add(new Culture(i));
        }

        starSystemList.add(
                new StarSystem(1, r.nextInt(1,9),cultures)
        );

    }

    public void print(){
        for (StarSystem ssystem : starSystemList){
            ssystem.tabPrint(1);
        }
    }


}
