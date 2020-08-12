public class ReverseBits {
    // you need treat n as an unsigned value
    //Runtime: 1 ms
    //Memory usage: 39 MB
    public int reverseBits(int n) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            res = res << 1; //shift left 1
            res |= (n & 1); //copy the bit value over
            n = n >>> 1; //unsigned shift
        }
        return res;
    }
}
