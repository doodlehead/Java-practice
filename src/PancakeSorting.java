import java.util.LinkedList;
import java.util.List;

public class PancakeSorting {
    List<Integer> moves = new LinkedList<>();

    //Runtime: 1 ms
    //Memory usage: 39.5 MB
    public List<Integer> pancakeSort(int[] A) {
        //Start at the end
        for (int i = A.length - 1; i >= 0; i--) {
            int currIndex = indexOf(A, i + 1);

            if (currIndex == i) {
                continue; //it's already in the right place
            } else {
                if (currIndex != 0) {
                    //Bring it to the front
                    flip(A, currIndex + 1);
                }
                //Flip it to the rightful index
                flip(A, i + 1);
            }
        }
        return moves;
    }

    //Do a "pancake flip" at the specified index
    //index - starts at 1
    public void flip(int[] arr, int index) {
        moves.add(index);
        int temp;
        for (int i = 0; i < index/2; i ++) {
            temp = arr[i];
            arr[i] = arr[index - 1 - i];
            arr[index - 1 - i] = temp;
        }
    }

    //Because the Java Arrays util class doesn't come with one...
    public static int indexOf(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) return i;
        }
        return -1;
    }
}
