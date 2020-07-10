public class CountAndSay {
    //n ranges from 1-30
    //Doing it recursively because the problem said so. To me it makes more sense to do iteratively.
    public String countAndSay(int n) {
        if(n == 1) return "1";

        return doConversion(countAndSay(n-1));
    }

    /**
     * Converts the nth term of the Count and Say sequence into the (n+1)th term
     * @param term - The term to convert into the next one
     * @return The next term
     */
    public String doConversion(String term) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char prev = term.charAt(0);

        for (int i = 1; i < term.length(); i++) {
            if (term.charAt(i) == prev) {
                count++;
            } else {
                sb.append(count);
                sb.append(prev);
                count = 1;
                prev = term.charAt(i);
            }
        }
        sb.append(count);
        sb.append(prev);

        return sb.toString();
    }
}
