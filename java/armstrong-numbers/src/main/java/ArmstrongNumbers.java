import java.util.logging.Logger;

class ArmstrongNumbers {

	boolean isArmstrongNumber(int numberToCheck) {
		int result = 0;
		String number = String.valueOf(numberToCheck);

		for(int i = 0; i < number.length(); i++) {
			result += (int)Math.pow(number.charAt(i) - '0', (int)number.length());
		}

		return result == numberToCheck;
	}

}
