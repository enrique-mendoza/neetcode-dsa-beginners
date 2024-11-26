package neetcode.courses.dsa.linkedlists.queues;

import neetcode.courses.dsa.linkedlists.queues.nodes.ListNode;

public class Deque {

    private ListNode left;

    private ListNode right;

    public Deque() {
        this.left = null;
        this.right = null;
    }

    public boolean isEmpty() {
        return this.left == null || this.right == null;
    }

    public void append(int value) {
        ListNode newNode = new ListNode(value);

        if (this.right != null) {
            this.right.next = newNode;
            newNode.prev = this.right;
            this.right = this.right.next;
        } else {
            this.left = newNode;
            this.right = newNode;
        }
    }

    public void appendleft(int value) {
        ListNode newNode = new ListNode(value);

        if (this.left != null) {
            newNode.next = this.left;
            this.left.prev = newNode;
            this.left = newNode;
        } else {
            this.left = newNode;
            this.right = newNode;
        }
    }

    public int pop() {
        if (this.right == null) {
            return -1;
        }

        int val = this.right.val;
        this.right = this.right.prev;

        if (this.right == null) {
            this.left = null;
        } else {
            this.right.next = null;
        }

        return val;
    }

    public int popleft() {
        if (this.left == null) {
            return -1;
        }

        int val = this.left.val;
        this.left = this.left.next;

        if (this.left == null) {
            this.right = null;
        } else {
            this.left.prev = null;
        }

        return val;
    }
}