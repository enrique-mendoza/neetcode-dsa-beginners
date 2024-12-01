package neetcode.courses.dsa.linkedlists.queues.exercises;

import java.util.LinkedList;
import java.util.Queue;

// Problem definition: https://leetcode.com/problems/implement-stack-using-queues/
public class StackUsingQueues {

    private Queue<Integer> queue;

    public StackUsingQueues() {
        this.queue = new LinkedList<>();
    }

    public void push(int x) { // O(n)
        this.queue.offer(x);

        for (int i = 0; i < this.queue.size() - 1; i++) {
            this.queue.offer(this.queue.poll());
        }
    }

    public int pop() { // O(1)
        if (this.empty()) {
            return -1;
        }

        return this.queue.remove();
    }

    public int top() { // O(1)
        if (this.empty()) {
            return -1;
        }

        return this.queue.peek();
    }

    public boolean empty() { // O(1)
        return this.queue.isEmpty();
    }
}