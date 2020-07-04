import java.util.*;

public class SingleNumber {
    //V1: using extra memory
    //Runtime: 11 ms
    //Memory usage: 46.5 MB
    public int singleNumberV1(int[] nums) {
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

    //V2: no extra memory, much better runtime. Actually proud I figured this out...
    //Runtime: 1 ms
    //Memory: 41 MB
    public int singleNumber(int[] nums) {
         for(int i = 1; i < nums.length; i++) {
             nums[0] ^= nums[i];
         }
         return nums[0];
    }
}
