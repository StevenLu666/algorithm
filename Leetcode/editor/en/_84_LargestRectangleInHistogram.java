package editor.en;

import java.util.ArrayDeque;
import java.util.Deque;

public class _84_LargestRectangleInHistogram{
    
    public void run() {
        Solution s = new Solution();
        int[] nums = new int[] {2,1,5,6,2,3};
        int ret = s.largestRectangleArea(nums);
        System.out.println(ret);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] nums = new int[len+2];

        for (int i = 0; i < len; i++) {
            nums[i+1] = heights[i];
        }
        len += 2;
        nums[0] = 0;
        nums[len-1] = 0;

        Deque stack = new ArrayDeque();
        stack.addLast(nums[0]);
        int left, height;
        int max = 0;
        for (int i = 1; i < len; i++) {
            while (nums[(int)stack.peekLast()] > nums[i]) {
                height = nums[(int)stack.pollLast()];
                left = (int)stack.peekLast();
                int area = (i-left-1)*height;
                max = Math.max(area, max);
            }
            stack.addLast(i);
        }

        return max;
    }
//    public int largestRectangleArea(int[] heights) {
//        int len = heights.length;
//        int[] hei = new int[len+2];
//
//        for (int i = 0; i < len; i++) {
//            hei[i+1] = heights[i];
//        }
//        len += 2;
//        hei[0] = 0;
//        hei[len-1] = 0;
//
//        int left = 0, right = 0;
//        int max = 0;
//        for (int i = 1; i < len; i++) {
//            for (int j = i; j >= 0; j--) {
//                if (hei[j] < hei[i]) {
//                    left = j;
//                    break;
//                }
//            }
//            for (int j = i; j < len; j++) {
//                if (hei[j] < hei[i]) {
//                    right = j;
//                    break;
//                }
//            }
//            int area = (right-left-1) * hei[i];
//            max = Math.max(area, max);
//        }
//        return max;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)


}