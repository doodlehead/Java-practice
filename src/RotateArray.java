public class RotateArray {
    //V1: new array, ezpz
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
//    public void rotate(int[] nums, int k) {
//        int r = k % nums.length; //No need to rotate more than one rotation
//
//        if (k == 0) return;
//
//        if (nums.length % k == 0) {
//            //Divisible
//
//        } else {
//
//        }
//    }
}
