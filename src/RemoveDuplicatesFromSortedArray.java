public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        else if (nums.length == 1) return 1;

        int tailIndex = 1; //The first number automatically makes it into the list
        int prevValue = nums[0];
        for (int i=1; i < nums.length; i++) {
            if (nums[i] != prevValue) {
                nums[tailIndex] = nums[i];
                tailIndex++;
            }
            prevValue = nums[i];
        }
        return tailIndex;
    }
}
