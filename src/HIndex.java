import java.util.Arrays;

public class HIndex {
    //N - # of papers
    //h of their papers have at least h# of citations AND
    //the other (N - h) papers have no more than h citations each

    //V1: Sort the array first
    //Runtime: 0 ms
    //Memory usage: 37.8 MB
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        Arrays.sort(citations);
        int count = 0;

        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] >= (citations.length - i)) {
                count++;
            } else {
                break;
            }

        }
        return count;
    }
}
