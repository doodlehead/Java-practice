import java.util.Arrays;

public class RotateArray {
    //V1: new array, ezpz
    //Runtime: 1 ms
    //Memory usage: 39.8 MB
    public void rotateV1(int[] nums, int k) {
        if (k == 0) return;

        int[] res = new int[nums.length];
        int r = k % nums.length;

        for (int i = 0; i < nums.length; i++) {
            res[(i + r) % res.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = res[i];
        }
    }

    //V2: rotate it in-place, use constant memory
    //Runtime: 2 ms
    //Memory usage: 42.5 MB ??? It's worse lol
    public void rotate(int[] nums, int k) {
        int r = k % nums.length; //No need to rotate more than one rotation

        if (r == 0 || nums.length < 2) return;

        if (nums.length % r == 0) {
            //Divisible
            for (int i = 0; i < r; i ++) {
                int first = nums[i];
                int index = i;
                //Y'know you could technically multi-thread and parallelize this... Not sure if it would be faster though
                for (int j = 0; j < nums.length/r - 1; j++) {
                    nums[index] = nums[(index + nums.length - r) % nums.length];
                    index = (index + nums.length - r) % nums.length;
                }
                nums[(i + r) % nums.length] = first;
            }
        } else {
            int limit = nums.length;
            int startingIndex = 0;

            while (limit > 0) {
                int first = nums[startingIndex];
                int index = startingIndex;
                //Keep going around backwards
                for (int i = 0; i < limit; i++) {
                    nums[index] = nums[(index - r + nums.length) % nums.length];
                    index = (index - r + nums.length) % nums.length;

                    //We've done a cycle
                    if (index == startingIndex) {
                        limit -= i; //update the new limit
                        break;
                    }
                }
                nums[(startingIndex + r) % nums.length] = first;
                limit--;
                startingIndex++; //increment starting index
            }
        }
    }

//    public static void main(String[] args) {
//        RotateArray ra = new RotateArray();
//        int[] arr = new int[]{ 1, 2, 3, 4, 5, 6 };
//
//        //Test not divisible
//        ra.rotate(arr, 4);
//        System.out.println(Arrays.toString(arr));
//
//        //Test divisible
//        int[] arr2 = new int[]{ 1, 2, 3, 4, 5, 6 };
//        ra.rotate(arr2, 2);
//        System.out.println(Arrays.toString(arr2));
//    }
}
