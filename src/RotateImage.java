public class RotateImage {
    //n x n matrix
    //Runtime: 0 ms
    //Memory usage: 40.4 MB
    public void rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length == 1) return;

        //# of layers = n / 2
        for (int layer = 0; layer < matrix.length/2; layer++) {
            for (int i = 0; i < matrix.length - 2*layer - 1; i++) {
                int temp = matrix[layer][layer + i];
                int end = matrix.length - layer - 1; //Stays constant in iteration

                matrix[layer][layer + i] = matrix[end - i][layer]; //looks ok
                matrix[end - i][layer] = matrix[end][end - i]; //
                matrix[end][end - i] = matrix[layer + i][end];
                matrix[layer + i][end] = temp;
            }
        }
    }
}
