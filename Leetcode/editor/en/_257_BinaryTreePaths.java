package editor.en;

import java.util.LinkedList;
import java.util.List;

public class _257_BinaryTreePaths{
    
    public void run() {
        Solution s = new Solution();
        TreeNode treeNode = new TreeNode(new Integer[] {1,2,3,null,5});
        List<String> r = s.binaryTreePaths(treeNode);
        System.out.println(r.toString());
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
    private void helper(TreeNode root, List<String> result, String s) {
        if (root.left == null && root.right == null) {
            result.add(s);
            return;
        }
        if (root.left != null)
            helper(root.left, result, s + "->" + String.valueOf(root.left.val));
        if (root.right != null)
            helper(root.right, result, s + "->" + String.valueOf(root.right.val));
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        String s = String.valueOf(root.val);
        helper(root, result, s);
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}