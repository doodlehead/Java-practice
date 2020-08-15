import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    //Case sensitive, s max length = 1010
    //Runtime: 6 ms
    //Memory usage: 37.4 MB
    public int longestPalindrome(String s) {
        if (s.length() == 0) return 0;

        Map<Character, Integer> occur = new HashMap<>();
        //Build occurrence map
        for (int i = 0; i < s.length(); i++) {
            occur.put(s.charAt(i), occur.getOrDefault(s.charAt(i), 0) + 1);
        }

        boolean hasOdd = false;
        int maxLength = 0;

        int count;
        for (Map.Entry<Character, Integer> entry: occur.entrySet()) {
            count = entry.getValue();
            if (!hasOdd && count % 2 == 1) hasOdd = true;

            if (count >= 2) {
                maxLength += (count % 2 == 1) ? (count - 1) : count;
            }
        }

        if (hasOdd) maxLength++;

        return maxLength;
    }
}
