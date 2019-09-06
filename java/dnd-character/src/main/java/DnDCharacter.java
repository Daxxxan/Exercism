import java.util.Arrays;

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
        int[] throwResult = throwDices();
        Arrays.sort(throwResult);
        return throwResult[1] + throwResult[2] + throwResult[3];
    }

    private int[] throwDices() {
        int[] throwResult = new int[4];

        for(int i = 0; i < 4; i++) {
            throwResult[i] = throwDice();
        }

        return throwResult;
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
