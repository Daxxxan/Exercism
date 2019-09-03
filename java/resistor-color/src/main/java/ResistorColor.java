import java.util.*;

class ResistorColor {

    private List colorsList = Arrays.asList("black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white");

    int colorCode(String color) {
        return colorsList.indexOf(color);
    }

    String[] colors() {
        return (String[]) colorsList.toArray(new String[colorsList.size()]);
    }
}
