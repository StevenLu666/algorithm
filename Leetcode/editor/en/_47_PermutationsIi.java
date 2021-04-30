package editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _47_PermutationsIi{
    
    public void run() {
        Solution s = new Solution();
        List<List<Integer>> result = s.permuteUnique(new int[] {1, 1, 3});
        System.out.println(Arrays.toString(result.toArray()));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean []used = new boolean[nums.length];
        Arrays.fill(used, false);
        Arrays.sort(nums);
        helper(result, list, nums, used);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            if (i>0 && nums[i] == nums[i-1] && !used[i-1])
                continue;
            used[i] = true;
            list.add(nums[i]);
            helper(result, list, nums, used);
            list.remove(list.size()-1);
            used[i] = false;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)


}