package neetcode.courses.dsa.linkedlists.doubly.nodes;

public class ListNode {

    public int val;

    public ListNode next;

    public ListNode prev;

    public ListNode(int val) {
        this(val, null, null);
    }

    public ListNode(int val, ListNode prev, ListNode next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}
