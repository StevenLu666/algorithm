package editor.en;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _236_LowestCommonAncestorOfABinaryTree{
    
    public void run() {
        Solution s = new Solution();
        TreeNode treeNode = new TreeNode(new Integer[] {3,5,1,6,2,0,8,null,null,7,4});

        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);


        TreeNode r = s.lowestCommonAncestor(treeNode, p, q);
        System.out.println(r.val);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private boolean findNodePath(TreeNode root, TreeNode node, LinkedList<TreeNode> result) {

        if (root == null) {
            return false;
        }

        if (root.val == node.val) {
            result.offerFirst(root);
            return true;
        }

        if (findNodePath(root.left, node, result)) {
            result.offerFirst(root);
            return true;
        }

        if (findNodePath(root.right, node, result)) {
            result.offerFirst(root);
            return true;
        }

        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        LinkedList<TreeNode> resultp = new LinkedList<>();
        if (!findNodePath(root, p, resultp))
            return null;

        LinkedList<TreeNode> resultq = new LinkedList<>();
        if (!findNodePath(root, q, resultq))
            return null;

        System.out.println(Arrays.toString(resultp.toArray()));
        System.out.println(Arrays.toString(resultq.toArray()));

        TreeNode result = null;
        int len = Math.min(resultp.size(), resultq.size());
        for (int i = 0; i < len; i++) {
            if (resultp.peekFirst().val == resultq.peekFirst().val) {
                result = resultp.pollFirst();
                resultq.pollFirst();
            } else {
                break;
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}