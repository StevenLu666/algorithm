package editor.en;

import java.util.Arrays;

public class _283_MoveZeroes{
    
    public void run() {
        Solution s = new Solution();
        int []a = new int[] {7,3,4,5,0,0,6};
        System.out.println(Arrays.toString(a));
        s.moveZeroes(a);
        System.out.println(Arrays.toString(a));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (; j<nums.length; j++) {
            nums[j] = 0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}