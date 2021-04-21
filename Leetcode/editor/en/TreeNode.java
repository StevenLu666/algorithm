package editor.en;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    TreeNode(Integer []array) {
        Import(array);
    }

    private TreeNode Import(Integer []array) {
        if (array.length == 0)
            return null;

        int i = 0;
        LinkedList list = new LinkedList();
        val = array[i++];
        list.addLast(this);

        while (!list.isEmpty()) {
            TreeNode curr = (TreeNode)list.removeFirst();
            if (curr == null) {
                i += 2;
                continue;
            }

            if (i < array.length) {
                if (array[i] == null) {
                    curr.left = null;
                    list.addLast(null);
                } else {
                    TreeNode left = new TreeNode(array[i]);
                    curr.left = left;
                    list.addLast(left);
                }
            } else {
                break;
            }
            i++;

            if (i < array.length) {
                if (array[i] == null) {
                    curr.right = null;
                    list.addLast(null);
                } else {
                    TreeNode right = new TreeNode(array[i]);
                    curr.right = right;
                    list.addLast(right);
                }
            } else {
                break;
            }
            i++;
        }

        return this;
    }

    private int CountHelper(TreeNode node, int count) {
        if (node == null)
            return 0;

        int left = CountHelper(node.left, count);
        int right = CountHelper(node.right, count);

        return left + right + 1;
    }

    public int Count() {
        return CountHelper(this, 0);
    }

    public Integer[] ExportNode() {
        LinkedList<Integer> result = new LinkedList<>();
        LinkedList<TreeNode> list = new LinkedList<>();

        list.addLast(this);
        int i = 0;
        int count = Count();
        while(!list.isEmpty() && i < count) {
            TreeNode curr = list.removeFirst();
            if (curr == null) {
                result.addLast(null);
                list.addLast(null); //left
                list.addLast(null); //right
            } else {
                result.addLast(curr.val);
                list.addLast(curr.left); // left
                list.addLast(curr.right); // right
                i++;
            }
        }

        return result.toArray(new Integer[0]);
    }

}
