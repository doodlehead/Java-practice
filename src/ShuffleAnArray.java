import java.util.Arrays;
import java.util.Random;

//Fisher-Yates algorithm
//Runtime: 142 ms
//Memory usage: 93.5 MB
public class ShuffleAnArray {
    private int[] arr;
    private int[] shuffled;
    private Random rand;

    private int temp;

    public ShuffleAnArray(int[] nums) {
        this.arr = nums;
        this.shuffled = Arrays.copyOf(nums, nums.length);
        this.rand = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return arr;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        //Do the shuffling
        for (int i = 0; i < this.shuffled.length; i++) {
            int randIndex = rand.nextInt(this.shuffled.length);
            //Swap
            if (randIndex != i) {
                this.temp = this.shuffled[i];
                this.shuffled[i] = this.shuffled[randIndex];
                this.shuffled[randIndex] = this.temp;
            }
        }

        return this.shuffled;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */