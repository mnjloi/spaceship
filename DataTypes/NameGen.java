package DataTypes;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class NameGen {

    public List<String> syllables;
    public int num;

    public NameGen() {
        try {
            this.syllables = Files.readAllLines(Paths.get("spaceship\\syllables.txt"),
                    StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.num = syllables.size();
    }

    public String generateName(int n) {
        Random random = new Random();
        String ret = "";
        int s = 0;

        for (int i = 0; i < n; i++) {
            s = random.nextInt(this.num);
            ret = (ret + this.syllables.get(s));
        }

        return ret;
    }

    public String generateStarName(){
        Random random = new Random();
        boolean hasNums = random.nextBoolean();
        int n = random.nextInt(1,5);

        if (hasNums){
            String name = generateName(n);
            int i = random.nextInt(1,999);
            return (name + "-" + i);
        }
        else {
            return generateName(n);
        }
    }

}
