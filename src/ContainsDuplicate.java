import java.util.HashSet;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> visited = new HashSet<>();
        for (int i: nums) {
            if (visited.contains(i)) return true;
            visited.add(i);
        }
        return false;
    }
}
