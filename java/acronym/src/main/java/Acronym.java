import java.util.stream.Collectors;
import java.util.stream.Stream;

class Acronym {
    private String acronym;

    Acronym(String phrase) {
        this.acronym = Stream.of(phrase.replace('-', ' ').replace('_', ' ').split(" "))
                .filter(splitString -> !splitString.isEmpty())
                .map(string -> string.charAt(0))
                .map(firstCharacter -> firstCharacter.toString().toUpperCase())
                .collect(Collectors.joining());
    }

    String get() {
        return this.acronym;
    }
}
