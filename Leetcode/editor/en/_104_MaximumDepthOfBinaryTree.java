package editor.en;

import java.util.ArrayDeque;
import java.util.Deque;

public class _104_MaximumDepthOfBinaryTree{
    
    public void run() {
        Solution s = new Solution();
        TreeNode treeNode = new TreeNode(new Integer[] {0,2,4,1,null,3,-1,5,1,null,6,null,8});
//        TreeNode treeNode = new TreeNode(new Integer[] {3,9,20,null,null,15,7});
        System.out.println(s.maxDepth(treeNode));
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

    private int helper(TreeNode root, int level) {
        if (root == null)
            return level;
        return Math.max(helper(root.left, level+1), helper(root.right, level+1));
    }

    public int maxDepth(TreeNode root) {
        return helper(root, 0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}