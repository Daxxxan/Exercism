import java.util.ArrayList;
import java.util.Arrays;

public class PangramChecker {
    private final static int ALPHABET = 26;

    public boolean isPangram(String input) {
        return input.toLowerCase().chars()
                .filter(Character::isAlphabetic)
                .distinct()
                .count() == ALPHABET;
    }

}
