package editor.en;

import java.util.*;

public class _15_ThreeSum{
    
    public void run() {
        Solution s = new Solution();
//        int []a = new int[] {-1,0,1,2,-1,-4};
//        int []a = new int[] {};
        int []a = new int[] {-2,0,0,2,2};
        List<List<Integer>> result = s.threeSum(a);
        System.out.println(result);
    }
    /*
    // first round.
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        if (nums.length == 0 || nums[0] > 0 || nums[nums.length-1] < 0)
            return result;
        for (int i = 0; i < nums.length-2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                int left = nums[i] + nums[j];
                if (left > 0)
                    break;
                while (left+nums[k] > 0 && j<k)
                    k--;
                if (left+nums[k] == 0 && j<k) {
                    List<Integer> list = new LinkedList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ((LinkedList<List<Integer>>) result).push(list);
                }

                while(j < k-1 && nums[j] == nums[j+1])
                    j++;
                j++;
            }
            while(i < nums.length-3 && nums[i] == nums[i+1])
                i++;
        }
        return result;
    }
}*/

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int j = i+1, k = nums.length-1;
            int sum = -nums[i];
            int tmp;
            while (j<k) {
                tmp = nums[j] + nums[k];
                if (tmp == sum) {
                    List<Integer> r = Arrays.asList(nums[i], nums[j], nums[k]);
                    ((LinkedList<List<Integer>>) result).push(r);
                    j++;
                    k--;
                    while(j<k && nums[j] == nums[j-1])  j++;
                    while(j<k && nums[k] == nums[k+1])  k--;
                } else if (tmp < sum) {
                    j++;
                    while(j<k && nums[j] == nums[j-1])  j++;
                } else {
                    k--;
                    while(j<k && nums[k] == nums[k+1])  k--;
                }
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}