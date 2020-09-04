import java.util.*;

public class LargestTimeForGivenDigits {
    //4 digits
    //Return empty string if invalid
    //Runtime: 11 ms
    //Memory usage: 37.9 MB

    //TODO: this is some oof-level code. Redo it.
    public String largestTimeFromDigits(int[] A) {
        TreeMap<Integer, Integer> digitCount = new TreeMap<>(new ReverseOrder());
        int sixPlusCount = 0;

        //Build sorted map
        for (int i: A) {
            if (i >= 6)
                sixPlusCount++;
            digitCount.put(i, digitCount.getOrDefault(i, 0) + 1);
        }

        int[] limits = new int[]{ 0, 0, 5, 9};

        if (sixPlusCount > 2) {
            return "";
        } else if (sixPlusCount == 2) {
            limits[0] = 1;
            limits[1] = 9;
        } else if (sixPlusCount == 1) {
            limits[0] = 2;
        } else {
            limits[0] = 2;
        }

        int[] digits = new int[4];

        //First digit
        digits[0] = getDigit(limits[0], digitCount);

        //Second digit
        if (digits[0] == -1)
            return "";
        else if (digits[0] == 2) {
            digits[1] = getDigit(3, digitCount);
        } else {
            digits[1] = getDigit(9, digitCount);
        }

        if (digits[1] == -1)
            return "";
        //Third digit
        digits[2] = getDigit(5, digitCount);
        //Fourth digit
        if (digits[2] == -1)
            return "";
        digits[3] = getDigit(9, digitCount);

        return "" + digits[0] + digits[1] + ":" + digits[2] + digits[3];
    }

    //Valid digits are [0, limit]
    public int getDigit(int limit, TreeMap<Integer, Integer> digits) {
        //Iterate biggest to smallest
        for (Map.Entry<Integer, Integer> entry: digits.entrySet()) {
            int key = entry.getKey();
            if (key <= limit) {
                //update the digits count
                int updatedCount = entry.getValue() - 1;
                if (updatedCount == 0) {
                    digits.remove(key);
                } else {
                    digits.put(key, entry.getValue() - 1);
                }

                return key;
            }
        }
        return -1;
    }

    class ReverseOrder implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            return  b.compareTo(a);
        }
    }

    public static void main(String[] args) {
        var t = new LargestTimeForGivenDigits();
        int[] dig = new int[]{ 2, 0, 6, 6 };
        System.out.println(t.largestTimeFromDigits(dig));
    }
}


