package editor.en;

import java.util.Arrays;

public class _80_RemoveDuplicatesFromSortedArrayIi{
    
    public void run() {
        Solution s = new Solution();
        int [] nums = new int[] {0,0,1,1,1,1,2,3,3};
        System.out.println(Arrays.toString(nums));
        int r = s.removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(r);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int removeDuplicates(int[] nums) {
//        if (nums.length < 3)
//            return nums.length;
//        int id = 2;
//        for (int i = 2; i<nums.length; i++) {
//            if (nums[i] == nums[id-1] && nums[i] == nums[id-2])
//                continue;
//            nums[id++] = nums[i];
//        }
//        return id;
//    }
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3)
            return nums.length;
        int id = 1;
        int count = 0;
        int last = nums[0];
        for (int i = 1; i<nums.length; i++) {
            if (nums[i] == last) {
                count++;
            } else {
                count = 0;
                last = nums[i];
            }

            if (count < 2)
                nums[id++] = nums[i];
        }
        return id;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}