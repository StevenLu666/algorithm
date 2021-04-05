package editor.en;

import java.util.Arrays;

public class _26_RemoveDuplicatesFromSortedArray{
    
    public void run() {
        Solution s = new Solution();
        int []nums = new int[] {0,0,1,1,1,2,2,3,3,4};
//        int []nums = new int[] {1, 1};
        System.out.println(Arrays.toString(nums));
        int len = s.removeDuplicates(nums);
        System.out.println(len);
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int removeDuplicates(int[] nums) {
//        int count = 0;
//        for (int i = 1; i<nums.length; i++) {
//            if (nums[i] == nums[i-1])
//                count++;
//            else
//                nums[i-count] = nums[i];
//        }
//        return nums.length - count;
//    }
    public int removeDuplicates(int[] nums) {
        int n = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1])
                continue;
            nums[n++] = nums[i];
        }
        return n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}