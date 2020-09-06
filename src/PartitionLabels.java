import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PartitionLabels {
    //Aiming for as many parts as possible
    //Each letter can only belong exclusively to ONE part

    //S: length [1, 500], lowercase
    //Runtime: 4 ms
    //Memory usage: 38 MB
    public List<Integer> partitionLabels(String S) {
        //Find efficient way to check a set of ranges

        /*
         * Create a range system: [storage: O(n)]
         * - intersection: O(n)
         * - belongs to: O(1)
         */

        /*
         * Implementation:
         * - Map: I-1, Bt-n
         * - Array: I-1, Bt-1
         */

        //Represents after the index. 0 checks between (0, 1)

        //false is open (because it's the default value)
        boolean[] ranges = new boolean[S.length()];
        Set<Character> visited = new HashSet<>();

        for (int i = 0; i < S.length(); i++) {
            if (!visited.contains(S.charAt(i))) {
                //Process new character
                int endIndex = S.lastIndexOf(S.charAt(i));
                if (endIndex != i) {
                    //System.out.printf("Adding range: (%d %d)%n", i, endIndex);
                    addRange(ranges, i, endIndex);
                }
                visited.add(S.charAt(i));
            }
        }

        List<Integer> res = new LinkedList<>();
        int prevIndex = -1;

        //Check the ranges array
        for (int i = 0; i < ranges.length; i++) {
            if (!ranges[i]) {
                //System.out.printf("Open at: %d, prev: %d%n", i, prevIndex);
                //open
                res.add(i - prevIndex);
                prevIndex = i;
            }
        }

        return res;
    }

    //Start inclusive, end exclusive
    public void addRange(boolean[] ranges, int start, int end) {
        for (int i = start; i < end; i++) {
            ranges[i] = true;
        }
    }

    public static void main(String[] args) {
        var t = new PartitionLabels();
        String test = "ababcbacadefegdehijhklij";
        System.out.println(t.partitionLabels(test).toString());
    }
}
