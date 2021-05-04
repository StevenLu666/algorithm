package editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _78_Subsets{
    
    public void run() {
        Solution s = new Solution();
        List<List<Integer>> r = s.subsets(new int[] {2, 1, 3});
        System.out.println(Arrays.toString(r.toArray()));
    }


    // Recursive solution:
    // 1. sort nums.
    // 2. In each recursive level, choose one number in remaining numbers.
    class Solution1 {
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

    // iteration solution.
    // just like shake hands: the new person (n) should shake hands with all exist persons [0, n-1].
    class Solution2 {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            for (int num: nums) {
                int len = result.size();
                for (int i = 0; i < len; i++) {
                    ArrayList<Integer> tmp = new ArrayList<>(result.get(i));
                    tmp.add(num);
                    result.add(tmp);
                }
            }
            return result;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // Recursive solution
    // we have two choice on every elements: select it, or not.
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            helper(result, new ArrayList<>(), 0, nums);
            return result;
        }

        private void helper(List<List<Integer>> result, List<Integer> list, int level, int[] nums) {
            if (level == nums.length) {
                result.add(new ArrayList<>(list));
                return;
            }

            helper(result, list, level+1, nums);
            list.add(nums[level]);
            helper(result, list, level+1, nums);
            list.remove(list.size()-1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}