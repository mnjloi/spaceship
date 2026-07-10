import StarSystems.Culture;
import StarSystems.StarSystem;
import ship.Ship;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    public Ship spaceship;
    public List<StarSystem> starSystemList;
    public List<Culture> cultures;
    public static int maxStars = 8;
    public static int maxCultures = 6;
    public Scanner scanner;

    public Game() {
        scanner = new Scanner(System.in);
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

    public void next_action(){
        System.out.println("""
                what do you want to do?
                i - info
                sj - star jump
                sysj - system jump
                """);
        String input = scanner.nextLine();
        String dest;

        switch (input){
            case "i":
                spaceship.info();
                break;
            case "sj":
                System.out.println("write your destination (0 to go back, id-{starID} to work with ID)");
                dest = scanner.nextLine();
                spaceship.star_jump(dest);
                break;
            case "sysj":
                System.out.println("write your destination (0 to go back, id-{sysID} to work with ID)");
                dest = scanner.nextLine();
                spaceship.system_jump(dest, starSystemList);
                break;
            default:
                System.out.println("command not found in dictionary.");
        }
    }

    public void print(){
        for (StarSystem ssystem : starSystemList){
            ssystem.tabPrint(1);
        }
    }


}
