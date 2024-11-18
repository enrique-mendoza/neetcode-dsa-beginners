package neetcode.courses.dsa.linkedlists.doubly;

import neetcode.courses.dsa.linkedlists.doubly.nodes.ListNode;

public class DoublyLinkedList {

    private ListNode head;

    private ListNode tail;

    public DoublyLinkedList() {
        this.head = new ListNode(0);
        this.tail = new ListNode(0);

        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int index) {
        ListNode curr = this.head.next;

        while (curr != null && index > 0) {
            curr = curr.next;
            index--;
        }

        if (curr != null && curr != this.tail && index == 0) {
            return curr.val;
        }

        return -1;
    }

    public void addAtHead(int val) {
        ListNode newHead = new ListNode(val);
        ListNode prev = this.head;
        ListNode next = this.head.next;

        prev.next = newHead;
        next.prev = newHead;

        newHead.prev = prev;
        newHead.next = next;
    }

    public void addAtTail(int val) {
        ListNode newTail = new ListNode(val);
        ListNode prev = this.tail.prev;
        ListNode next = this.tail;

        prev.next = newTail;
        next.prev = newTail;

        newTail.prev = prev;
        newTail.next = next;
    }

    public void addAtIndex(int index, int val) {
        ListNode curr = this.head.next;

        while (curr != null && index > 0) {
            curr = curr.next;
            index--;
        }

        if (curr != null && index == 0) {
            ListNode node = new ListNode(val);
            ListNode prev = curr.prev;
            ListNode next = curr;

            prev.next = node;
            next.prev = node;

            node.prev = prev;
            node.next = next;
        }
    }

    public void deleteAtIndex(int index) {
        ListNode curr = this.head.next;

        while (curr != null && index > 0) {
            curr = curr.next;
            index--;
        }

        if (curr != null && curr != this.tail && index == 0) {
            ListNode prev = curr.prev;
            ListNode next = curr.next;

            prev.next = next;
            next.prev = prev;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList myLinkedList = new DoublyLinkedList();

        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2); // linked list becomes 1->2->3
        myLinkedList.get(1); // return 2
        myLinkedList.deleteAtIndex(1); // now the linked list is 1->3
        myLinkedList.get(1); // return 3
    }
}
