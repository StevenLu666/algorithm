package editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _78_Subsets{
    
    public void run() {
        Solution s = new Solution();
        List<List<Integer>> r = s.subsets(new int[] {2, 1, 3});
        System.out.println(Arrays.toString(r.toArray()));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums, int start) {
        result.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            helper(result, list, nums, i+1);
            list.remove(list.size()-1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        helper(result, new ArrayList<>(), nums, 0);
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}