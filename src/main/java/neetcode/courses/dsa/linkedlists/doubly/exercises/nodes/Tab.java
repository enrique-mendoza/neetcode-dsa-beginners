package neetcode.courses.dsa.linkedlists.doubly.exercises.nodes;

public class Tab {

    public String url;

    public Tab next;

    public Tab prev;

    public Tab(String url) {
        this(url, null, null);
    }

    public Tab(String url, Tab prev, Tab next) {
        this.url = url;
        this.prev = prev;
        this.next = next;
    }
}
