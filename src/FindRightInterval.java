import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class FindRightInterval {
    //intervals - array of intervals

    //V1: O(n^2) obvious solution
    //Runtime: 726 ms (awful lol)
    //Memory usage: 42.5 MB
    public int[] findRightIntervalV1(int[][] intervals) {
        int[] res = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            int rightIndex = -1;
            //Calculate the index for the interval
            for (int j = 0; j < intervals.length; j++) {
                if (j == i) continue; //Don't compare with itself

                //Is to the right
                if (intervals[j][0] >= intervals[i][1]) {
                    if (rightIndex == -1) {
                        rightIndex = j;
                    } else {
                        //Compare it to the existing index
                        if (intervals[j][0] < intervals[rightIndex][0]) {
                            rightIndex = j;
                        }
                    }
                }
            }
            res[i] = rightIndex;
        }
        return res;
    }

    //V2: Use the power of sorted maps
    //Runtime: 27 ms
    //Memory usage: 47.7 MB
    public int[] findRightInterval(int[][] intervals) {
        if (intervals.length == 0) return new int[]{};
        else if (intervals.length == 1) return  new int[]{ -1 };

        int[] res = new int[intervals.length];

        // [start, [end, index]]
        TreeMap<Integer, int[]> sortedIntervals = new TreeMap<>();

        //Sort the intervals by start
        for (int i = 0; i < intervals.length; i++) {
            //Remember the original index
            sortedIntervals.put(intervals[i][0], new int[]{ intervals[i][1], i });
        }

        //Get the indexes
        for (int i = 0; i < intervals.length; i++) {
            int endIndex = intervals[i][1];
            Integer key;
            if (sortedIntervals.containsKey(endIndex)) {
                key = endIndex;
            } else {
                key = sortedIntervals.higherKey(endIndex);
            }

            if (key == null) {
                res[i] = -1;
            } else {
                res[i] = sortedIntervals.get(key)[1];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        var m = new FindRightInterval();

        int[][] intervals = new int[][]{
                {3,4},
                {2,3},
                {1,2}};

        int[] indexes = m.findRightInterval(intervals);

        System.out.println(Arrays.toString(indexes));
    }
}
