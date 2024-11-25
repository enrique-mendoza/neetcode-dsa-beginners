package neetcode.courses.dsa.linkedlists.doubly.exercises;

import neetcode.courses.dsa.linkedlists.doubly.exercises.nodes.Tab;

public class BrowserHistory {

    private Tab curr;

    public BrowserHistory(String homepage) {
        this.curr = new Tab(homepage);
    }

    // time complexity: O(1)
    public void visit(String url) {
        this.curr.next = new Tab(url, this.curr, null);
        this.curr = this.curr.next;
    }

    // time complexity (linked list, arrays): O(n), O(1)
    public String back(int steps) {
        while (this.curr.prev != null && steps > 0) {
            this.curr = this.curr.prev;
            steps--;
        }

        return this.curr.url;
    }

    // time complexity (linked list, arrays): O(n), O(1)
    public String forward(int steps) {
        while (this.curr.next != null && steps > 0) {
            this.curr = this.curr.next;
            steps--;
        }

        return this.curr.url;
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");

        browserHistory.visit("google.com"); // You are in "leetcode.com". Visit "google.com"
        browserHistory.visit("facebook.com"); // You are in "google.com". Visit "facebook.com"
        browserHistory.visit("youtube.com"); // You are in "facebook.com". Visit "youtube.com"
        browserHistory.back(1); // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        browserHistory.back(1); // You are in "facebook.com", move back to "google.com" return "google.com"
        browserHistory.forward(1); // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        browserHistory.visit("linkedin.com"); // You are in "facebook.com". Visit "linkedin.com"
        browserHistory.forward(2); // You are in "linkedin.com", you cannot move forward any steps.
        browserHistory.back(2); // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
        browserHistory.back(7); // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
    }
}
