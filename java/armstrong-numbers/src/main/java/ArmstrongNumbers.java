import java.util.logging.Logger;

class ArmstrongNumbers {

	boolean isArmstrongNumber(int numberToCheck) {
		String numberToCheckAsString = String.valueOf(numberToCheck);

		int result = numberToCheckAsString.chars()
				.map(charDigit -> charDigit - '0')
				.map(digit -> (int)Math.pow(digit, numberToCheckAsString.length()))
				.sum();

		return result == numberToCheck;
	}

}
