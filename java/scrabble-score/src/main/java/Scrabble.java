import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Scrabble {

    private int score = 0;
    private Map<Character, Integer> scrabbleScore = Stream.of(new Object[][] {
            {'A', 1}, {'E', 1}, {'I', 1}, {'O', 1}, {'U', 1}, {'L', 1}, {'N', 1}, {'R', 1}, {'S', 1}, {'T', 1},
            {'D', 2}, {'G', 2},
            {'B', 3}, {'C', 3}, {'M', 3}, {'P', 3},
            {'F', 4}, {'H', 4}, {'V', 4}, {'W', 4}, {'Y', 4},
            {'K', 5},
            {'J', 8}, {'X', 8},
            {'Q', 10}, {'Z', 10},
    }).collect(Collectors.toMap(letter -> (Character) letter[0], score -> (Integer) score[1]));

    Scrabble(String word) {
        this.score = calculateWordScore(word.toUpperCase());
    }

    private int calculateWordScore(String word) {
        int score = 0;

        for(int i = 0; i < word.length(); i++) {
            score += scrabbleScore.get(word.charAt(i));
        }

        return score;
    }

    int getScore() {
        return this.score;
    }

}
