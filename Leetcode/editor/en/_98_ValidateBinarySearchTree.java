package editor.en;

public class _98_ValidateBinarySearchTree{
    
    public void run() {
        Solution s = new Solution();
        int a = 0,b = 0;
        s.helper(a, b);
        System.out.println(a);
        System.out.println(b);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
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

        boolean right = isValidBST(root.right);
        if (!right)
            return false;

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}