//Runtime 0ms
//Memory Usage 39.9 MB
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits.length == 1 && digits[0] == 9) return new int[]{ 1, 0 };
        int carry;

        if (digits[digits.length-1] + 1 == 10) {
            digits[digits.length-1] = 0;
            carry = 1;
        } else {
            carry = 0;
            digits[digits.length-1]++;
        }

        for (int i = digits.length-2; i >= 0; i--) {
            if (carry == 0) {
                return digits;
            }

            //Carry over again
            if (digits[i] + carry == 10) {
                if (i == 0) { //Num too big to fit anymore
                    int[] ret = new int[digits.length+1];
                    ret[0] = 1;
                    digits[i] = 0;
                    for (int j = 0; j < digits.length; j++) {
                        ret[j + 1] = digits[j];
                    }
                    return ret;
                } else {
                    digits[i] = 0;
                    carry = 1;
                }
            } else {
                digits[i] = digits[i] + carry;
                carry = 0;
            }
        }
        return digits;
    }
}
