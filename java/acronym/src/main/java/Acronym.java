import java.util.ArrayList;
import java.util.Arrays;

class Acronym {
    private String phrase;

    Acronym(String phrase) {
        this.phrase = phrase;
    }

    String get() {
        ArrayList decomposedPhrase = new ArrayList<String>(Arrays.asList(this.phrase.split("[ \\-]")));
        StringBuilder result = new StringBuilder();

        decomposedPhrase.forEach(
                phrase -> {
                    String acronymString = phrase.toString().toUpperCase();
                    char acronymLetter = getFirstLetter(acronymString);

                    if(Character.isLetter(acronymLetter)) {
                        result.append(acronymLetter);
                    }
                }
        );

        return result.toString();
    }

    private char getFirstLetter(String acronymString) {
        if(acronymString.length() == 0) {
            return ' ';
        } else {
            for(int i = 0; i < acronymString.length(); i++) {
                if(Character.isLetter(acronymString.charAt(i))) {
                    return acronymString.charAt(i);
                }
            }
        }

        return ' ';
    }

}
