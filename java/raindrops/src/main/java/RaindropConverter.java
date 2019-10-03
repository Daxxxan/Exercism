import java.util.ArrayList;

import static java.lang.Math.sqrt;

class RaindropConverter {

    String convert(int number) {
        StringBuilder result = new StringBuilder();

        if(number % 3 == 0) result.append("Pling");
        if(number % 5 == 0) result.append("Plang");
        if(number % 7 == 0) result.append("Plong");
        if (result.toString().isEmpty()) result.append(number);

        return result.toString();
    }
}
