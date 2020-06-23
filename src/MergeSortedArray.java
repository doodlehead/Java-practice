import java.util.Arrays;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }

        int index1 = 0, index2 = 0;
        int[] copyNums1 = Arrays.copyOf(nums1, nums1.length);

        while (index1 + index2 < m + n) {

            if (index2 >= n || (index1 < m && copyNums1[index1] < nums2[index2])) {
                //Take the number from nums1 if nums2 if empty or nums1 is smaller
                nums1[index1 + index2] = copyNums1[index1];
                index1++;
            } else {
                //Take the number from nums2
                nums1[index1 + index2] = nums2[index2];
                index2++;
            }
        }
    }
}
