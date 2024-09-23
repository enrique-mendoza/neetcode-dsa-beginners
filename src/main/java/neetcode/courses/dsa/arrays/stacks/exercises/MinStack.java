package neetcode.courses.dsa.arrays.stacks.exercises;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
    List<Integer> stack;
    List<Integer> minValues;

    public MinStack() {
        stack = new ArrayList<>();
        minValues = new ArrayList<>();
    }

    public void push(int val) {
        if (stack.isEmpty() || !minValues.isEmpty() && val <= minValues.get(minValues.size() - 1)) {
            minValues.add(val);
        }

        stack.add(val);
    }

    public void pop() {
        if (!stack.isEmpty()) {
            if (stack.get(stack.size() - 1).equals(minValues.get(minValues.size() - 1))) {
                minValues.remove(minValues.size() - 1);
            }

            stack.remove(stack.size() - 1);
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.get(stack.size() - 1);
        }

        return -1;
    }

    public int getMin() {
        return minValues.isEmpty() ? -1 : minValues.get(minValues.size() - 1);
    }
}
