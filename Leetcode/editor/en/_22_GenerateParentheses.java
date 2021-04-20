package editor.en;

import java.util.ArrayList;
import java.util.List;

public class _22_GenerateParentheses{
    
    public void run() {
        Solution s = new Solution();
        List<String> list = s.generateParenthesis(3);
        System.out.println(list.toString());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        String str = "";
        recursion(0, 0, n, str, result);
        return result;
    }

    private void recursion(int left, int right, int n, String str, List<String> result) {
        if (left == n && right == n) {
            result.add(str);
            return;
        }

        if (left < n)
            recursion(left + 1, right, n, str + "(", result);

        if (right < left)
            recursion(left, right + 1, n, str + ")", result);

    }
}
//leetcode submit region end(Prohibit modification and deletion)


}