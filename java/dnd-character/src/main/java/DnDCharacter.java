import java.util.Arrays;
import java.util.stream.IntStream;

class DnDCharacter {

    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    DnDCharacter() {
        this.strength = ability();
        this.dexterity = ability();
        this.constitution = ability();
        this.intelligence = ability();
        this.wisdom = ability();
        this.charisma = ability();
    }

    int ability() {
        return Arrays.stream(throwDices())
                .sorted()
                .skip(1)
                .sum();
    }

    private int[] throwDices() {
        return IntStream.range(0, 4).map(dice -> throwDice()).toArray();
    }

    private int throwDice() {
        return (int)(6.0 * Math.random()) + 1;
    }

    int modifier(int input) {
        return (int) Math.floor((input - 10) / 2.);
    }

    int getStrength() {
        return this.strength;
    }

    int getDexterity() {
        return this.dexterity;
    }

    int getConstitution() {
        return this.constitution;
    }

    int getIntelligence() {
        return this.intelligence;
    }

    int getWisdom() {
        return this.wisdom;
    }

    int getCharisma() {
        return this.charisma;
    }

    int getHitpoints() {
        return 10 + modifier(getConstitution());
    }

}
