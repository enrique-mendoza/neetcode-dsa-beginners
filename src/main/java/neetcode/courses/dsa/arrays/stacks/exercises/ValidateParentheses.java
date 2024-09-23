package neetcode.courses.dsa.arrays.stacks.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ValidateParentheses {

    // Problem definition: https://neetcode.io/problems/validate-parentheses
    public static boolean mySolution(String s) {
        List<String> stack = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.add(s.substring(i, i + 1)); //
                continue;
            }

            if (s.charAt(i) == ')' && stack.get(stack.size() - 1).equals("(") ||
                    s.charAt(i) == ']' && stack.get(stack.size() - 1).equals("[") ||
                    s.charAt(i) == '}' && stack.get(stack.size() - 1).equals("{")) {
                stack.remove(stack.size() - 1);
            } else {
                return false;
            }
        }

        return true;
    }

    public static boolean isValid(String s) {
        List<Character> stack = new ArrayList<>();
        HashMap<Character, Character> closeToOpen = new HashMap<>();

        closeToOpen.put(')', '(');
        closeToOpen.put(']', '[');
        closeToOpen.put('}', '{');

        // Time complexity: O(n)
        // Space complexity: O(n)
        for (int c = 0; c < s.length(); c++) {
            if (closeToOpen.containsKey(s.charAt(c))) {
                if (!stack.isEmpty() && stack.get(stack.size() - 1).equals(closeToOpen.get(s.charAt(c)))) {
                    stack.remove(stack.size() - 1);
                } else {
                    return false;
                }
            } else {
                stack.add(s.charAt(c));
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        boolean isValid = isValid(s);
        System.out.println(isValid);
    }
}
