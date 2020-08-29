public class FindRightInterval {
    //intervals - array of intervals

    //V1: O(n^2) obvious solution
    //Runtime: 726 ms (awful lol)
    //Memory usage: 42.5 MB
    public int[] findRightInterval(int[][] intervals) {
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

    //V2: There's probably a smarter way...
}
