package editor.en;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

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
        if (nums.length < 2 || k < 2)
            return nums;

        int len = nums.length;
        int[] result = new int[len-k+1];

        int[] leftMax = new int[len];
        int[] rightMax = new int[len];

        for (int i = 0; i < len; i++) {
            if (i%k == 0) {
                leftMax[i] = nums[i];
            } else {
                leftMax[i] = Math.max(leftMax[i-1], nums[i]);
            }
        }

        rightMax[len-1] = nums[len-1];
        for (int i = len-2; i >= 0; i--) {
            if (i%k == 0) {
                rightMax[i] = nums[i];
            } else {
                rightMax[i] = Math.max(rightMax[i+1], nums[i]);
            }
        }

        for (int i = 0; i < len - k + 1; i++) {
            result[i] = Math.max(rightMax[i], leftMax[i+k-1]);
        }
        return result;

        /*
        int r = 0;
        Deque<Integer> q = new ArrayDeque<>(); // save index
        for (int i = 0; i < len; i++) {
            // pop expired index
            while(!q.isEmpty() && q.peekFirst() < (i-k+1)) {
                q.pollFirst();
            }

            // pop the index of smaller number than current number
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }

            // offer current number
            q.offerLast(i);

            // record the first number
            if (i >= k-1) {
                result[r++] = nums[q.peekFirst()];
            }
        }
        return result;
        */
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}