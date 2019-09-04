import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class RnaTranscription {

    private Map dnaToRna = Stream.of(new char[][] {
            {'G', 'C'},
            {'C', 'G'},
            {'T', 'A'},
            {'A', 'U'}
    }).collect(Collectors.toMap(DNA -> DNA[0], RNA -> RNA[1]));

    String transcribe(String dnaStrand) {

        return  dnaStrand.chars()
                .mapToObj(character -> (char) character)
                .map(dnaChar -> dnaChar = (Character) dnaToRna.get(dnaChar))
                .collect(
                        Collector.of(
                                StringBuilder::new,
                                StringBuilder::append,
                                StringBuilder::append,
                                StringBuilder::toString
                        )
                );
    }

}
