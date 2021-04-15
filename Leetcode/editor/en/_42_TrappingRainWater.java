package editor.en;

public class _42_TrappingRainWater{
    
    public void run() {
        Solution s = new Solution();
        int []a = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(s.trap(a));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        // two pointers
        public int trap(int[] height) {
            int len = height.length;
            if (len < 3)
                return 0;
            int result = 0;

            int left = 0;
            int right = len - 1;
            int leftMax = 0;
            int rightMax = 0;

            while(left < right) {
                leftMax = Math.max(leftMax, height[left]);
                rightMax = Math.max(rightMax, height[right]);
                if (leftMax < rightMax) {
                    result += leftMax - height[left];
                    left++;
                } else {
                    result += rightMax - height[right];
                    right--;
                }
            }

            return result;
        }
/*
    // DP
    public int trap(int[] height) {
        int len = height.length;
        if (len < 3)
            return 0;
        int []leftMax = new int[len];
        int []rightMax = new int[len];
        leftMax[0] = height[0];
        rightMax[len-1] = height[len-1];
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
            rightMax[len-i-1] = Math.max(rightMax[len-i], height[len-i-1]);
        }
        int result = 0;
        for (int i = 0; i < len; i++) {
            result += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return result;
    }
*/
}
//leetcode submit region end(Prohibit modification and deletion)


}