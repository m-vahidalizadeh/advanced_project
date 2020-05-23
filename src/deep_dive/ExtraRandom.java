package deep_dive;

import java.util.Random;

public class ExtraRandom extends Random {
    public String nextLetter() {
        int lowercaseACode = 97;
        int randomInt = new Random().nextInt(26) + lowercaseACode;
        return "" + (char) randomInt;
    }
}
