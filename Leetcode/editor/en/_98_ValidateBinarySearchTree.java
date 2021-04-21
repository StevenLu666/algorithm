package editor.en;

import java.util.Arrays;

public class _98_ValidateBinarySearchTree{
    
    public void run() {
        Solution s = new Solution();

        TreeNode a = new TreeNode(new Integer[] {5,1,4,null,null,3,6});

        System.out.println(s.isValidBST(a));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    TreeNode pre = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        boolean left = isValidBST(root.left);
        if (!left)
            return false;

        if (pre != null && pre.val >= root.val)
            return false;

        pre = root;

        return isValidBST(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}