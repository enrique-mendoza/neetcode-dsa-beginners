package neetcode.courses.dsa.linkedlists.singly.exercises;

import neetcode.courses.dsa.linkedlists.singly.exercises.nodes.ListNode;

public class MergeTwoSortedLists {

    // Problem definition: https://leetcode.com/problems/merge-two-sorted-lists/description/
    // time complexity O(n + m)
    // memomy complexity O(1)
    // where n is the length of list1 and m is the length of list2.
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next; // updating dummy and tail next point
            } else {
                tail.next = list2;
                list2 = list2.next;
            }

            tail = tail.next;
        }

        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        ListNode mergedList = mergeTwoLists(list1, list2);

        System.out.println(mergedList);
    }
}
