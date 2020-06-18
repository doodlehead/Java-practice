import java.util.*;

class TwoSum {
    public int[] twoSum(int[] nums, int target)
    {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(target-nums[i])) //Found solution
            {
                result[0] = Integer.min(i,map.get(target-nums[i]));
                result[1] = Integer.max(i,map.get(target-nums[i]));
                return result;
            }
            map.put(nums[i], i); //Store data
        }
        return result;
    }
}