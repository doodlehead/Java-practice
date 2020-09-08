public class ImageOverlap {
    //"Images" are always square dimensions
    //Both images are always the same size

    //V1: brute force because I don't have better ideas
    //Runtime complexity: O(n^2) ?
    //Runtime: 33 ms
    //Memory usage: 39.4 MB
    public int largestOverlap(int[][] A, int[][] B) {
        int max = 0;

        for (int x = -(A.length - 1); x < A.length; x++) {
            for (int y = -(A.length - 1); y < A.length; y++) {
                int overlap = getOverlap(A, B, new int[]{ x, y });
                if (overlap > max) max = overlap;
            }
        }
        return max;
    }

    //Offset values will range from (-(length-1), (length-1))
    //Offset of B relative to A
    public int getOverlap(int[][] A, int[][] B, int[] offset) {
        //Negative offsets A, position offsets B
        int[] aOffset = new int[2];
        int[] bOffset = new int[2];

        if (offset[0] >= 0) {
            aOffset[0] = offset[0];
        } else {
            bOffset[0] = -offset[0];
        }

        if (offset[1] >= 0) {
            aOffset[1] = offset[1];
        } else {
            bOffset[1] = -offset[1];
        }

        //Determine the dimensions of the overlap box
        int[] dimensions = new int[]{ A.length - Math.abs(offset[0]), A.length - Math.abs(offset[1]) };
        int overlapCount = 0;
        for (int x = 0; x < dimensions[0]; x++) {
            for (int y = 0; y < dimensions[1]; y++) {
                if (A[y + aOffset[1]][ x + aOffset[0]] == 1 && B[y + bOffset[1]][x + bOffset[0]] == 1) {
                    overlapCount++;
                }
            }
        }
        return overlapCount;
    }

    public static void main(String[] args) {
       int[][] A = {{1,1,0},
               {0,1,0},
               {0,1,0}};
       int[][] B = {{0,0,0},
               {0,1,1},
               {0,0,1}};

       var t = new ImageOverlap();
       System.out.println(t.getOverlap(A, B, new int[]{ 0, 0 }));
    }
}
