import java.util.*;
import java.util.stream.Collectors;

//TODO: solve another (better) way
public class Permutations {
    //Distinct integers are given
    //# of permutation = n!
    //Runtime complexity of different solutions are probably similar,
    //so optimize for memory usage?

    //Memory usage should be O(n * n!)

    //V1: weird map implementation
    //Runtime: 11 ms
    //Memory usage: 43.4 MB
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length < 2) {
            LinkedList<List<Integer>> res = new LinkedList<>();
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            res.add(list);
            return res;
        }

        ArrayList<List<Integer>> result = new ArrayList<>();
        ArrayList<Set<Integer>> setList = new ArrayList<>();

        //The base set that all the other sets will be "cloned" from
        Set<Integer> numSetBase = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        //Initialize the custom map-thingy
        for (int i = 0; i < nums.length; i++) {
            List<Integer> temp = new LinkedList<>();
            temp.add(nums[i]);
            result.add(temp); //Key - the list

            Set<Integer> newSet = new HashSet<>(numSetBase);
            newSet.remove(nums[i]);

            setList.add(newSet); //Add to the set of stuff left
        }

        //Iterate
        for (int i = 1; i < nums.length; i++) {
            //Iterate over the whole list
            int initialSize = result.size();
            for (int j = 0; j < initialSize; j++) {
                boolean isFirstElem = true;
                int firstElem = 0;
                //For each unused int in the set entry
                for (int unused: setList.get(j)) {
                    if (isFirstElem) {
                        firstElem = unused;
                        isFirstElem = false;
                    } else {
                        //Add new entries for the unused nums
                        Set<Integer> newSet = new HashSet<>(setList.get(j));
                        List<Integer> newList = new LinkedList<>(result.get(j));
                        newList.add(unused);
                        newSet.remove(unused);
                        //Add the new entry
                        result.add(newList);
                        setList.add(newSet);
                    }
                }
                //Modify the first element
                if (!setList.get(j).isEmpty()) {
                    result.get(j).add(firstElem);
                    setList.get(j).remove(firstElem);
                }
            }
        }
        return result;
    }
}
