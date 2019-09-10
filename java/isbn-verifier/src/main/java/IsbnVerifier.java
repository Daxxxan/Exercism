class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        int isbnTotal = 0;
        char charToTest;
        stringToVerify = removeDashCharacter(stringToVerify);

        if(isbnLengthIsValid(stringToVerify)) {
            return false;
        }

        for(int i = 0; i < stringToVerify.length(); i++) {
            charToTest = stringToVerify.charAt(i);

            if((charIsValid(charToTest) && !charPositionIsValid(stringToVerify.length() - 1, i))
                    || characterIsNotAnX(charToTest)) {
                return false;
            } else {
                isbnTotal += calculateIsbn(charToTest, stringToVerify, i);
            }
        }

        return isbnTotal % 11 == 0;
    }

    private int calculateIsbn(char charToTest, String stringToVerify, int currentPosition) {
        if(charIsValid(charToTest) && charPositionIsValid(stringToVerify.length() - 1, currentPosition)) {
            return 10;
        } else {
            return Integer.parseInt(String.valueOf(charToTest)) * (10 - currentPosition);
        }
    }

    private boolean charPositionIsValid(int positionOfTheLastCharacter, int currentPosition) {
        return currentPosition == positionOfTheLastCharacter;
    }

    private boolean charIsValid(char charToTest) {
        return 'X' == charToTest;
    }

    private boolean characterIsNotAnX(char charToTest) {
        return 'X' != charToTest && Character.isLetter(charToTest);
    }

    private boolean isbnLengthIsValid(String stringToVerify) {
        return stringToVerify.length() != 10;
    }

    private String removeDashCharacter(String stringToVerify) {
        return stringToVerify.replace("-", "");
    }
}