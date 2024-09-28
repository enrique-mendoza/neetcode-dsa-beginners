package neetcode.courses.dsa.linkedlists;

import neetcode.courses.dsa.linkedlists.nodes.ListNode;

import java.util.ArrayList;

public class SinglyLinkedList {

    private ListNode head;

    private ListNode tail;

    public SinglyLinkedList() {
        this.head = new ListNode(-1);
        this.tail = this.head;
    }

    public int get(int index) {
        int i = 0;
        ListNode curr = this.head.next; // Ignore dummy node

        while (curr != null) {
            if (i == index) {
                return curr.val;
            }

            i++;
            curr = curr.next;
        }

        return -1; // Index out of bounds
    }

    public void insertHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = this.head.next;
        this.head.next = newNode;

        if (newNode.next == null) {
            this.tail = newNode;
        }
    }

    public void insertTail(int val) {
        this.tail.next = new ListNode(val);
        this.tail = this.tail.next;
    }

    public boolean remove(int index) {
        int i = 0;
        ListNode curr = this.head;

        while (i < index && curr != null) {
            i++;
            curr = curr.next;
        }

        // Remove the node ahead of curr
        if (curr != null && curr.next != null) {
            if (curr.next == this.tail) {
                this.tail = curr;
            }

            curr.next = curr.next.next;

            return true;
        }

        return false;
    }

    public ArrayList<Integer> getValues() {
        ListNode curr = this.head.next;
        ArrayList<Integer> values = new ArrayList<>();

        while (curr != null) {
            values.add(curr.val);
            curr = curr.next;
        }

        return values;
    }
}
