import java.util.*;

public class BullsAndCows {
    //Strings containing digits of equal unknown length

    //V1: It's too slow... TODO: make it faster
    //Runtime: 12 ms
    //Memory usage: 40 MB
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        List<Character> unmatched = new LinkedList<>();

        int bulls = 0;
        int cows = 0;

        char guessChar;
        char secretChar;
        for (int i = 0; i < secret.length(); i++) {
            guessChar = guess.charAt(i);
            secretChar = secret.charAt(i);
            if (secretChar == guessChar) {
                bulls++;
            } else {
                charCount.put(secretChar, charCount.getOrDefault(secretChar, 0) + 1);
                unmatched.add(guessChar);
            }
        }

        //Process the unmatched chars
        for (Character c: unmatched) {
            if (charCount.containsKey(c)) {
                cows++;
                //Reduce the count by 1
                if (charCount.get(c) == 1) {
                    charCount.remove(c);
                } else {
                    charCount.put(c, charCount.get(c) - 1);
                }
            }
        }

        return String.format("%dA%dB", bulls, cows);
    }
}
