package editor.en;

public class _206_ReverseLinkedList{
    
    public void run() {
        Solution s = new Solution();

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);

        a.next = b;
        b.next = c;

        ListNode r = s.reverseList(a);
        print(r);
    }

    public void print(ListNode listNode) {
        do {
            System.out.println(listNode.val);
            listNode = listNode.next;
        } while (listNode != null);
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode pre = null, curr = null, next = null;
        curr = head;
        next = head.next;
        while(next != null) {
            curr.next = pre;
            pre = curr;
            curr = next;
            next = curr.next;
        }
        curr.next = pre;
        return curr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}