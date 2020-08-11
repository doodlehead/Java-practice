public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    //Runtime: 2 ms
    //Memory usage: 36.1 MB
    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            if ((n & 1) == 1) //Check the right-most bit with a mask
                count++;
            n = n >>> 1; //unsigned right shift
        }

        return count;
    }
}
