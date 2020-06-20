public class ReverseInteger {
    //Version 1. Fast to code, slower execution
    //32 bit signed int
    public int reverse(int x) {
        int pos = (x < 0) ? -x : x;
        StringBuilder sb = new StringBuilder(String.valueOf(pos));
        sb.reverse();

        try {
            int reverse = Integer.parseInt(sb.toString());
            return (x < 0) ? -reverse : reverse;
        } catch(Exception e) {
            return 0;
        }
    }
}
