package editor.en;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _169_MajorityElement{
    
    public void run() {
        Solution s = new Solution();
        int r = s.majorityElement(new int[] {2,2,1,1,1,2,2});
        System.out.println(r);
    }
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
    class Solution2 {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length/2];
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // same number will increase count, and different number will decrease count.
    class Solution {
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
//leetcode submit region end(Prohibit modification and deletion)


}