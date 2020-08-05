public class PowerOfFour {
    //V1: keep dividing by 4
    public boolean isPowerOfFour(int num) {
        if (num <= 0) return false;
        else if (num == 1) return true;

        int rem = 0;
        int res = 0;

        while (num >= 4) {
            rem = num % 4;
            num = num / 4;

            if (rem == 0 && num == 1)
                return true;
            else if (rem != 0)
                return false;
        }
        return false;
    }

    //V2: probably bitwise manipulation...
}
