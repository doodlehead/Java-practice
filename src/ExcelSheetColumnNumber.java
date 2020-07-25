public class ExcelSheetColumnNumber {

    //It's just a base-26 number system right? Without a zero though...
    //"s" is [1-7] letters long
    //Runtime: 1 ms
    //Memory usage: 38 MB
    public int titleToNumber(String s) {
        int res = 0;
        int multi  = 1;

        for (int i = 0; i < s.length(); i++) {
            res += (s.charAt(s.length() - (i + 1)) - 'A' + 1) * multi;
            multi *= 26;
        }
        return res;
    }
}
