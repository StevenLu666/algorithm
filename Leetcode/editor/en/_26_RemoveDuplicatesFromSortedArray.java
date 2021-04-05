package editor.en;

import java.util.Arrays;

public class _26_RemoveDuplicatesFromSortedArray{
    
    public void run() {
        Solution s = new Solution();
//        int []nums = new int[] {1, 1, 2};
        int []nums = new int[] {1, 1};
        System.out.println(Arrays.toString(nums));
        int len = s.removeDuplicates(nums);
        System.out.println(len);
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2)
            return nums.length;

        int i = 1, j = 1;
        while(i < nums.length && j < nums.length) {
            if (nums[i] > nums[i-1]) {
                i++;
                continue;
            }
            if (nums[j] < nums[i-1])
                j = i;
            while(j < nums.length && nums[j] == nums[i-1])
                j++;
            if (j == nums.length)
                break;
            nums[i++] = nums[j++];
        }
        return i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}