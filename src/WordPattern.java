import java.util.HashMap;
import java.util.HashSet;

public class WordPattern {
    //pattern - only contains lowercase letters
    //str - contains lowercase letters and spaces
    //Runtime: 0 ms
    //Memory usage: 37.4 MB
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");

        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> values = new HashSet<>();

        //Pattern length is diff from str
        if (pattern.length() != words.length) {
            return false;
        }

        for (int i = 0; i < words.length; i++) {
            char currChar = pattern.charAt(i);
            if (map.containsKey(currChar)) {
                //Existing key
                if (map.get(currChar).equals(words[i])) {
                    //The values much match if the keys are the same
                    continue;
                } else {
                    //Different values
                    return false;
                }
            } else {
                //New key
                if (values.contains(words[i])) {
                    //New key, existing value
                    return false;
                } else {
                    //New key, value pair
                    map.put(currChar, words[i]);
                    values.add(words[i]);
                }
            }
        }

        return true;
    }
}
