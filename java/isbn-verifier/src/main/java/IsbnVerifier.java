class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        int isbnTotal = 0;
        stringToVerify = stringToVerify.replace("-", "");

        if(stringToVerify.length() != 10) {
            return false;
        }

        for(int i = 0; i < stringToVerify.length(); i++) {
            if(
                    ('X' == stringToVerify.charAt(i) && i != stringToVerify.length() - 1) ||
                    ('X' != stringToVerify.charAt(i) && Character.isLetter(stringToVerify.charAt(i)))
            ) {
                return false;
            }

            if(stringToVerify.charAt(i) == 'X' && i == stringToVerify.length() - 1) {
                isbnTotal += 10;
            } else {
                isbnTotal += Integer.parseInt(String.valueOf(stringToVerify.charAt(i))) * (10 - i);
            }
        }

        return isbnTotal % 11 == 0;
    }

}
