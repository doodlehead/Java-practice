import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    //(), {}, [] allowed
    //Runtime: 4 ms
    //Memory usage: 39.3 MB
    public boolean isValid(String s) {
        if (s.length() == 0) return true;

        //Stack-based solution
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = Map.of(')','(','}','{',']','[');

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) return false;
                char front = stack.pop();
                if (front != map.get(s.charAt(i))) return false;
            }
        }
        return stack.isEmpty();
    }
}
