package editor.en;

import java.util.Arrays;

public class _70_ClimbingStairs{
    
    public void run() {
        Solution s = new Solution();
        System.out.println(s.climbStairs(5));
    }


/*class Solution {
    public int climbStairs(int n) {
        if (n < 0)
            return 0;
        if (n==1)
            return 1;
        if (n==2)
            return 2;
        int []result = new int[n];
        result[0] = 1;
        result[1] = 2;
        for (int i = 2; i<n; i++) {
            result[i] = result[i-1] + result[i-2];
        }
        return result[n-1];
    }
}*/

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        if (n < 0)
            return 0;
        if (n==1)
            return 1;
        if (n==2)
            return 2;
        int []nums = new int[n+1];
        Arrays.fill(nums, 0);
        nums[1] = 1;
        nums[2] = 2;
        return fibonacci(n, nums);
    }

    private int fibonacci(int n, int []nums) {
        if (n < 3)
            return nums[n];
        if (nums[n] != 0)
            return nums[n];
        nums[n] = fibonacci(n-1, nums) + fibonacci(n-2, nums);
        return nums[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}