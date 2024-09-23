package neetcode.courses.dsa.arrays.stacks;

import java.util.ArrayList;

public class Stack {

    private ArrayList<Integer> stack = new ArrayList<Integer>();

    public Stack() {
    }

    public void push(int n) {
        stack.add(n);
    }

    public int pop() {
        return stack.remove(stack.size() - 1);
    }

    public int size() {
        return stack.size();
    }
}
