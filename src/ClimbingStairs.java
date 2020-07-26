public class ClimbingStairs {
    //Use recursion or dynamic programming
    public int climbStairs(int n) {
        return climbStairsDynamic(n);
    }

    //Runtime: 0 ms
    //Memory usage: 38.1 MB
    public int climbStairsDynamic(int n) {
        if (n == 1) return 1;
        else if (n == 2) return 2;

        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    //Works, but is too slow
    public int climbStairsRecursive(int n) {
        if (n == 1) return 1;
        else if (n == 2) return 2;
        else return climbStairsRecursive(n-1) + climbStairsRecursive(n-2);
    }
}
