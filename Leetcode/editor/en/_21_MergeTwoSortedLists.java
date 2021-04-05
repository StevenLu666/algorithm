package editor.en;

import java.util.List;

public class _21_MergeTwoSortedLists{
    
    public void run() {
        Solution s = new Solution();

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        ListNode g = new ListNode(7);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;

        ListNode aa = new ListNode(1);
        ListNode bb = new ListNode(2);
        ListNode cc = new ListNode(3);
        ListNode dd = new ListNode(4);
        ListNode ee = new ListNode(5);
        ListNode ff = new ListNode(6);
        ListNode gg = new ListNode(7);
        aa.next = bb;
        bb.next = cc;
//        cc.next = dd;
//        dd.next = ee;
        cc.next = ff;
        ff.next = gg;

        ListNode r = s.mergeTwoLists(a, aa);
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode ret = new ListNode(0);
        ListNode tail = new ListNode();
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                if (ret.next == null)
                    ret.next = l1;
                tail.next = l1;
                tail = l1;
                l1 = l1.next;
            } else {
                if (ret.next == null)
                    ret.next = l2;
                tail.next = l2;
                tail = l2;
                l2 = l2.next;
            }
        }
        if (l1 == null)
            tail.next = l2;
        else
            tail.next = l1;
        return ret.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}