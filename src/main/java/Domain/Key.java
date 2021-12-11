package Domain;

import java.util.Random;

public class Key {

    private final String charsLowerCase = "abcdefghijklmnopqrstuvwxyz";
    private final String charsUpperCase = charsLowerCase.toUpperCase();
    private final String numbers = "0123456789";
    private final String charsSpecial = ".-_@$#&";
    private final String[] arr= {charsLowerCase, charsUpperCase, numbers, charsSpecial};
    private String simbolos;

    public String generateKey(int lengthKey, boolean[] booleans) {
        initCharacters(booleans);
        Random random = new Random();
        String key = "";
        for (int i = 0; i < lengthKey; i++) {
            key += simbolos.charAt(random.nextInt(simbolos.length()));
        }
        return key;
    }

    private String initCharacters(boolean[] booleans) {
        simbolos = "";
        for (int i = 0; i < booleans.length; i++) {
            if (booleans[i]) {
                simbolos += arr[i];
            }
        }
        return simbolos;
    }
}