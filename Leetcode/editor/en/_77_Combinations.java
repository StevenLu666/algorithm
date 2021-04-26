package editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _77_Combinations{
    
    public void run() {
        Solution s = new Solution();
        List<List<Integer>> result = s.combine(4, 2);
        System.out.println(Arrays.toString(result.toArray()));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private void helper(int start, int end, int k, int level, List<Integer> list, List<List<Integer>> result) {


        int stop = end - k + level;

        if (level == k) {

            for (int i = start; i <= stop; i++) {
                list.add(i);
                result.add(new ArrayList<>(list));
                list.remove(list.size()-1);
            }
            return;
        }

        for (int i = start; i <= stop; i++) {
            list.add(i);

            helper(i+1, end, k, level+1, list, result);
            list.remove(list.size()-1);
        }

    }
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        helper(1, n, k, 1, list, result);
        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


}