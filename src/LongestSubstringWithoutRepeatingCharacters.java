import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    //V1
    //Runtime: 7 ms
    //Memory Usage: 39.7 MB
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return  0;
        if (s.length() == 1) return  1;

        //First char is auto-visited
        HashSet<Character> visited = new HashSet<>();
        visited.add(s.charAt(0));
        int anchorIndex = 0;
        int longest = 1;

        for (int i=1; i < s.length(); i++) {
            if (visited.contains(s.charAt(i))) {
                //Duplicate
                int newAnchorIndex = s.indexOf(s.charAt(i), anchorIndex) + 1;

                for (int p = anchorIndex; p < newAnchorIndex; p++) {
                    visited.remove(s.charAt(p));
                }

                visited.add(s.charAt(newAnchorIndex));
                visited.add(s.charAt(i));

                anchorIndex = newAnchorIndex;
                longest = Integer.max(i - anchorIndex + 1, longest);
            } else {
                //Unique, keep going
                longest = Integer.max(i - anchorIndex + 1, longest);
                visited.add(s.charAt(i));
            }
        }
        return longest;
    }
}
