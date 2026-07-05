class ListNode {
    String url;
    ListNode next;
    ListNode prev;
    public ListNode(String url) {
        this.url = url;
        this.next = null;
        this.prev = null;
    }
}
class BrowserHistory {
    ListNode current;
    public BrowserHistory(String homepage) {
        current = new ListNode(homepage);
    }
    public void visit(String url) {
        ListNode newNode = new ListNode(url);
        current.next = null;
        newNode.prev = current;
        current.next = newNode;
        current = newNode;
    }
    public String back(int steps) {
        while(steps > 0 && current.prev != null) {
            current = current.prev;
            steps -- ;
        }
        return current.url;
    }
    public String forward(int steps) {
        while(steps > 0 && current.next != null) {
            current = current.next;
            steps--;
        }
        return current.url;
    }
}