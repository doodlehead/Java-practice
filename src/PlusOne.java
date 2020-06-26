//Runtime 0ms
//Memory Usage 39.9 MB
public class PlusOne {
    //V1
    public int[] plusOneV1(int[] digits) {
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

    //V2 - A smarter way to doing it
    //Runtime: 0ms
    //Memory Usage: 37.7 MB
    public int[] plusOne(int[] digits) {
        boolean needsExtra = true;

        for (int i: digits) {
            if (i != 9) {
                needsExtra = false;
                break;
            }
        }

        if (needsExtra) {
            int[] ret = new int[digits.length + 1];
            ret[0] = 1;
            return ret;
        } else {
            digits[digits.length-1]++;

            for (int i = digits.length-1; i >= 0; i--) {
                if (digits[i] == 10) {
                    digits[i] = 0;
                    digits[i-1]++;
                } else return digits;
            }
        }

        return digits;
    }
}
