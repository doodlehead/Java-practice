import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    //Runtime: 11 ms
    //Memory usage: 54.2 MB
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int prevCount = count.getOrDefault(nums[i],0);
            if (prevCount + 1 > nums.length/2) return nums[i];
            count.put(nums[i], prevCount + 1);
        }
        return -1;
    }
}
