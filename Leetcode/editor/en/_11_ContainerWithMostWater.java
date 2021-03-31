package editor.en;

public class _11_ContainerWithMostWater{
    
    public void run() {
        Solution s = new Solution();
        int []height = new int[] {1,8,6,2,5,4,8,3,7};
        int area = s.maxArea(height);
        System.out.println(area);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length-1;
        int max = 0, area = 0, minHeight = 0;
        while(i < j) {
            while (height[i] <= minHeight && i < j)
                i++;
            while (height[j] <= minHeight && i < j)
                j--;
            minHeight = Math.min(height[i], height[j]);
            area = minHeight * (j-i);
            max = Math.max(max, area);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}