package editor.en;

import java.util.Arrays;

public class _189_RotateArray{
    
    public void run() {
        Solution s = new Solution();
        int a[] = new int[] {-1,-100,3,99};
        s.rotate(a, 2);
//        int a[] = new int[] {1,2};
//        s.rotate(a, 3);
        System.out.println(Arrays.toString(a));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        if (k > length)
            k = k % length;
        if (k == 0)
            return;
        int[] result = new int[length];
        int j = 0;
        for (int i=length-k; i<length; i++) {
            result[j++] = nums[i];
        }
        for (int i=0; i<length-k; i++) {
            result[j++] = nums[i];
        }
        for (int i=0; i<length; i++) {
            nums[i] = result[i];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}