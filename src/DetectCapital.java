public class DetectCapital {
    //Runtime: 1 ms
    //Memory usage: 37.8 MB
    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() == 0) return true;

        boolean allCaps, noCaps, firstCap;
        allCaps = noCaps = true;
        firstCap = word.charAt(0) <= 'Z';

        for (int i = 0; i < word.length(); i++) {
            if (allCaps && word.charAt(i) >= 'a') {
                allCaps = false;
            }
            if (noCaps && word.charAt(i) <= 'Z') {
                noCaps = false;
            }
            if (firstCap) {
                if (i == 0) continue;
                if (word.charAt(i) <= 'Z') {
                    firstCap = false;
                }
            }
        }

        return allCaps || noCaps || firstCap;
    }
}
