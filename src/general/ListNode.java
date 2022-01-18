package general;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    public ListNode next(int val) {
        ListNode ln = new ListNode(val);
        this.next = ln;
        return ln;
    }
}
