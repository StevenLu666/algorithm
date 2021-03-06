package editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _46_Permutations{
    
    public void run() {
        Solution s = new Solution();
        int[] nums = new int[] {1};
        List<List<Integer>> result = s.permute(nums);
        System.out.println(Arrays.toString(result.toArray()));
    }

    /*
class Solution {

    private void helper(List<Integer> remainList, int index, List<Integer> outputList, List<List<Integer>> result) {

        outputList.add(remainList.remove(index));

        if (remainList.isEmpty()) {
            result.add(outputList);
            return;
        }

        for (int i = 0; i < remainList.size(); i++) {
            helper(new ArrayList<>(remainList), i,new ArrayList<>( outputList), result);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num :
                nums) {
            list.add(num);
        }
        List<Integer> outputList = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            helper(new ArrayList<>(list), i, new ArrayList<>(outputList), result);
        }
        return result;
    }
    */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
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
