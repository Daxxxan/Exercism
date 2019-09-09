import java.util.stream.Stream;

class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        int result = 0;

        for(int i = 1; i <= input; i++) {
            result += i;
        }

        return (int) Math.pow(result, 2);
    }

    int computeSumOfSquaresTo(int input) {
        int result = 0;

        for(int i = 1; i <= input; i++) {
            result += Math.pow(i, 2);
        }

        return result;
    }

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }

}
