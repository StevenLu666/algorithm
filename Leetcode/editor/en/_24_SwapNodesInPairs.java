package editor.en;

public class _24_SwapNodesInPairs{
    
    public void run() {
        Solution s = new Solution();

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);

        a.next = b;
        b.next = c;

        ListNode r = s.swapPairs(a);
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

// pre, curr, nex, nexnex.
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode ret = head.next;
        ListNode pre = null, curr = head, nex = null, nexnex = null;
        while (curr != null) {
            nex = curr.next;
            if (nex != null)
                nexnex = nex.next;
            else
                break;

            if (pre != null)
                pre.next = nex;

            nex.next = curr;
            curr.next = nexnex;
            pre = curr;
            curr = nexnex;
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}