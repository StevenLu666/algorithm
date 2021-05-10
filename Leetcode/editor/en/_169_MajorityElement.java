package editor.en;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _169_MajorityElement{
    
    public void run() {
        Solution s = new Solution();
        int r = s.majorityElement(new int[] {8,9,8,9,8});
        System.out.println(r);
    }

    // Hash table
    class Solution1 {
        public int majorityElement(int[] nums) {
            if (nums.length == 1)
                return nums[0];
            Map<Integer, Integer> set = new HashMap<>();
            for(int num: nums) {
                if (!set.containsKey(num)) {
                    set.put(num, 1);
                } else {
                    int value = set.get(num)+1;
                    if (value > nums.length/2)
                        return num;
                    set.put(num, value);
                }
            }
            return 0;
        }
    }

    // sort
    class Solution2 {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length/2];
        }
    }

    // same number will increase count, and different number will decrease count.
    class Solution3 {
        public int majorityElement(int[] nums) {
            int major = nums[0];
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (count == 0) {
                    major = nums[i];
                    count++;
                } else if (major == nums[i]) {
                    count++;
                } else {
                    count--;
                }
            }
            return major;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // Divide and conquer
    class Solution {
        public int majorityElement(int[] nums) {
            return majority(nums, 0, nums.length-1);
        }

        private int majority(int[] nums, int l, int r) {
            if (l == r)
                return nums[l];
            int m = (l+r)/2;
            int lm = majority(nums, l, m);
            int mr = majority(nums, m+1, r);
            if (lm == mr)
                return lm;
            int countLm = 0, countMr = 0;
            for (int i = l; i <= r; i++) {
                if (nums[i] == lm)
                    countLm++;
                else if (nums[i] == mr)
                    countMr++;
            }
            return countLm > countMr ? lm : mr;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}