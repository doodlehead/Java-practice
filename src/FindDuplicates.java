import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FindDuplicates {
    //V1: O(n) space and time
    //Runtime: 18 ms
    //Memory usage: 49.5 MB
    public List<Integer> findDuplicates1(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        List<Integer> dups = new LinkedList<>();

        for(int i: nums) {
            if (visited.contains(i))
                dups.add(i);
            else
                visited.add(i);
        }
        return dups;
    }

    //V2: O(n) runtime, O(1) extra space
    //Runtime: 6 ms
    //Memory usage: 47.9 MB
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> dups = new LinkedList<>();

        int index = 0;
        int temp = 0;

        while (index < nums.length) {
            if (nums[index] == 0) {
                index++;
                continue;
            }

            if (nums[index] != index + 1) {
                //The current num isn't in its proper place
                temp = nums[nums[index] - 1];
                if (temp == nums[index]) {
                    //swap target is equal to current elem. Duplicate found
                    dups.add(nums[index]);
                    nums[index] = 0;
                    index++;
                    continue;
                } else {
                    //swap
                    nums[nums[index] - 1] = nums[index];
                    nums[index] = temp;
                }
            } else {
                //Move on to the next index
                index++;
            }
        }
        return dups;
    }
}
