import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    //Basic combinatorics problem
    //Runtime: 1ms
    //Memory usage: 40 MB
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();

        Map<Character, char[]> numpadMap = Map.of(
                '2', new char[]{'a', 'b', 'c'},
                '3', new char[]{'d', 'e', 'f'},
                '4', new char[]{'g', 'h', 'i'},
                '5', new char[]{'j', 'k', 'l'},
                '6', new char[]{'m', 'n', 'o'},
                '7', new char[]{'p', 'q', 'r', 's'},
                '8', new char[]{'t', 'u', 'v'},
                '9', new char[]{'w', 'x', 'y', 'z'}
        );
        //All pointers start at 0
        int[] pointers = new int[digits.length()];
        ArrayList<String> result = new ArrayList<>();

        outer: while (true) {
            //Add the entry referenced by the current pointers
            StringBuilder entry = new StringBuilder();
            for (int i = 0; i < pointers.length; i++) {
                char currChar = digits.charAt(i);
                entry.append(numpadMap.get(currChar)[pointers[i]]);
            }
            result.add(entry.toString());

            //Increment the pointers
            pointers[pointers.length-1]++; //Increment the last pointer
            //Account for "carry-over"
            for (int i = pointers.length-1; i >= 0; i--) {
                char currChar = digits.charAt(i); //Current number
                if (pointers[i] == numpadMap.get(currChar).length) {
                    //Overflow
                    if (i == 0) break outer; //We reached the end
                    pointers[i] = 0;
                    pointers[i-1]++;
                } else {
                    break; //No overflow, stop checking
                }
            }
        }
        return result;
    }
}
