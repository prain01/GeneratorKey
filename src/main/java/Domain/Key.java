package Domain;

import java.util.Random;

public class Key {

    private final String charsLowerCase = "abcdefghijklmnopqrstuvwxyz";
    private final String charsUpperCase = charsLowerCase.toUpperCase();
    private final String numbers = "0123456789";
    private final String charsSpecial = ".-_@$#&";
    private final String[] charsAll = {charsLowerCase, charsUpperCase, numbers, charsSpecial};
    private String charsSelected;

    public String generateKey(int lengthKey, boolean[] booleans) {
        initSequenceCharacters(booleans);
        Random random = new Random();
        String key = "";
        for (int i = 0; i < lengthKey; i++) {
            key += charsSelected.charAt(random.nextInt(charsSelected.length()));
        }
        return key;
    }

    private String initSequenceCharacters(boolean[] booleans) {
        charsSelected = "";
        for (int i = 0; i < booleans.length; i++) {
            if (booleans[i]) {
                charsSelected += charsAll[i];
            }
        }
        return charsSelected;
    }
}