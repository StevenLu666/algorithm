package editor.en;

import java.util.HashMap;
import java.util.Map;

public class _169_MajorityElement{
    
    public void run() {
        Solution s = new Solution();
        int r = s.majorityElement(new int[] {2,2,1,1,1,2,2});
        System.out.println(r);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
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
//leetcode submit region end(Prohibit modification and deletion)


}