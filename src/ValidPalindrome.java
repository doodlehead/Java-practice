public class ValidPalindrome {
    //Runtime: 4 ms
    //Memory usage: 39.5 MB
    public boolean isPalindrome(String s) {
        if (s == null | s.length() <= 1) return true;

        String p = strip(s);
        int length = p.length();
        for (int i = 0; i < length/2; i++) {
            if (p.charAt(i) != p.charAt(length - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    //Remove all non-alphanumeric chars
    public String strip(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i))) {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();

        System.out.println(vp.strip("A man, a plan, a canal: Panama"));
    }
}
