import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    //V1: convert the num to a string
    //Runtime: 1 ms
    //Memory usage: 37 MB
    public boolean isHappy(int n) {
        if (n == 1) return true;

        Set<Integer> visited = new HashSet<>();
        visited.add(n);

        int curr = n;

        while(curr != 1) {
            int newSum = 0;
            String num = String.valueOf(curr);
            for(int i = 0; i < num.length(); i++) {
                newSum += Math.pow(num.charAt(i) - '0', 2);
            }

            if (newSum == 1) {
                return true;
            } else if (visited.contains(newSum)) {
                return false; //You looped
            } else {
                visited.add(newSum);
                curr = newSum;
            }
        }
        return true;
    }
}
