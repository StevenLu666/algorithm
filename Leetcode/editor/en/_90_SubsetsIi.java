package editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _90_SubsetsIi{
    
    public void run() {
        Solution s = new Solution();
        List<List<Integer>> result = s.subsetsWithDup(new int[] {4,4,4,1,4});
        System.out.println(Arrays.toString(result.toArray()));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        helper(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums, int start) {
        result.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            helper(result, list, nums, i+1);
            while(i+1<nums.length && nums[i] == nums[i+1])
                i++;
            list.remove(list.size()-1);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)


}