import java.util.logging.Logger;

class ArmstrongNumbers {

	boolean isArmstrongNumber(int numberToCheck) {
		String number = String.valueOf(numberToCheck);

		int result = number.chars()
				.map(num -> num - '0')
				.map(num -> (int)Math.pow(num, number.length()))
				.sum();

		return result == numberToCheck;
	}

}
