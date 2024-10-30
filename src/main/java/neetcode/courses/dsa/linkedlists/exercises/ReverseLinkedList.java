package neetcode.courses.dsa.linkedlists.exercises;

import neetcode.courses.dsa.linkedlists.exercises.nodes.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList {

    // Problem definition: https://leetcode.com/problems/reverse-linked-list/
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        List<Integer> values = new ArrayList<>();

        while (head != null) {
            values.add(head.val);
            head = head.next;
        }

        ListNode reverse = new ListNode();

        for (int i = values.size() - 1; i >= 0; i--) {
            if (reverse.next == null) {
                reverse.val = values.get(i);
                reverse.next = new ListNode(values.get(i - 1));
            }
        }

        return reverse;
    }

    // transversely
    // time complexity O(n)
    // memomy complexity O(1) because we're using pointers
    public static ListNode reverseListTwoPointers(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode tmp;

        while (curr != null) {
            tmp = curr.next; // save next value before overwrite it
            curr.next = prev; // delete link to next value
            prev = curr;
            curr = tmp;
        }

        return prev;
    }

    // recursively
    // time complexity O(n)
    // memomy complexity O(n)
    public static ListNode reverseListRecursive(ListNode head) {
        // base case first:
        if (head == null) {
            return null;
        }

        ListNode newHead = head;

        if (head.next != null) {
            newHead = reverseListRecursive(head.next);
            head.next.next = head;
        }

        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        // ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        // ListNode reverseListTwoPointers = reverseListTwoPointers(head);
        // System.out.println(reverseListTwoPointers);

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        ListNode reverseListRecursive = reverseListRecursive(head);
        System.out.println(reverseListRecursive);
    }
}
