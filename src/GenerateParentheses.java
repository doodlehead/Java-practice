import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//V1 class-based solution because it's easier to code and read
//Runtime: 7 ms
//Memory usage: 41.7 MB
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        if (n == 1) return List.of("()");

        Queue<CombinationEntry> building = new LinkedList<>();
        List<String> res = new LinkedList<>();

        CombinationEntry first = new CombinationEntry(n, n);
        first.addA();
        building.add(first);

        while(!building.isEmpty()) {
            CombinationEntry curr = building.poll();
            if (curr.bLeft > curr.aLeft && curr.bLeft > 0) {
                //Spawn a new combination with an extra B
                CombinationEntry newEntry = curr.clone();
                newEntry.addB();
                building.add(newEntry);
            }
            if (curr.aLeft > 0) {
                //Add the current combination with an extra A
                curr.addA();
                building.add(curr);
            } else if (curr.aLeft == 0 && curr.bLeft == 0) {
                res.add(curr.getEntry());
            }
        }
        return res;
    }
}

class CombinationEntry {
    public int aLeft;
    public int bLeft;
    private StringBuilder entry;

    public CombinationEntry(int aLeft, int bLeft) {
        this(aLeft, bLeft, new StringBuilder());
    }
    public CombinationEntry(int aLeft, int bLeft, StringBuilder entry) {
        this.aLeft = aLeft;
        this.bLeft = bLeft;
        this.entry = entry;
    }

    public void addA() {
        this.entry.append('(');
        this.aLeft--;
    }
    public void addB() {
        this.entry.append(')');
        this.bLeft--;
    }
    public String getEntry() {
        return this.entry.toString();
    }

    public CombinationEntry clone() {
        return new CombinationEntry(this.aLeft, this.bLeft, new StringBuilder(this.entry));
    }
}


