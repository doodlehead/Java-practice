public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) {
            return "";
        }
        int index = 0; //Finishing index
        outer: while (true) {
            if (index >= strs[0].length()) {
                break outer;
            }

            for (String s: strs) {
                //Reached the end of the word or letter mismatch
                if (index >= s.length() || s.charAt(index) != strs[0].charAt(index)) {
                    break outer;
                }
            }
            index++;
        }
        return strs[0].substring(0, index);
    }
}
