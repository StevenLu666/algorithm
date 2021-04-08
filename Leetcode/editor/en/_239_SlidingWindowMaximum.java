package editor.en;

import java.util.Arrays;

public class _239_SlidingWindowMaximum{
    
    public void run() {
        Solution s = new Solution();
        int a[] = new int[] {1,3,1,2,0,5};
        int[] r = s.maxSlidingWindow(a, 3);
        System.out.println(Arrays.toString(r));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] result = new int[len-k+1];
        int maxIndex = -1, maxNum = nums[0];
        for (int i = 0; i <= len - k; i++) {
            if (maxIndex == -1) {
                maxIndex = i;
                maxNum = nums[i];
                for (int j = i; j < i+k; j++) {
                    if (nums[j] >= maxNum) {
                        maxIndex = j;
                        maxNum = nums[j];
                    }
                }
                result[i] = maxNum;
            } else {
                if (nums[i+k-1] >= maxNum) {
                    maxIndex = i+k-1;
                    maxNum = nums[i+k-1];
                } else if (i > maxIndex) {
                    maxIndex = i;
                    maxNum = nums[i];
                    for (int j = i; j < i+k; j++) {
                        if (nums[j] >= maxNum) {
                            maxIndex = j;
                            maxNum = nums[j];
                        }
                    }
                }
                result[i] = maxNum;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}