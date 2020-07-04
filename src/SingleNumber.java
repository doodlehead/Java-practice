import java.util.*;

public class SingleNumber {
    //V1: using extra memory
    public int singleNumber(int[] nums) {

        HashMap<Integer, Integer> visited = new HashMap<>();

        for (int i: nums) {
            if (visited.containsKey(i)) {
                visited.put(i, visited.get(i) + 1);
            } else {
                visited.put(i, 1);
            }
        }

        for(Map.Entry<Integer, Integer> e: visited.entrySet()) {
            if (e.getValue() == 1) return e.getKey();
        }
        return 0;
    }
}
