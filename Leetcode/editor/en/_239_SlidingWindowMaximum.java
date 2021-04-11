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
        int len = nums.length;
        int[] result = new int[len-k+1];
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
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}