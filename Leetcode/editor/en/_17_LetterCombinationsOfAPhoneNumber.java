package editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _17_LetterCombinationsOfAPhoneNumber{
    
    public void run() {
        Solution s = new Solution();
        List<String> res = s.letterCombinations("23");
        System.out.println(Arrays.toString(res.toArray()));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // simple recursive solution
class Solution {
    public Solution() {
        numberMap[0] = "0";
        numberMap[1] = "1";
        numberMap[2] = "abc";
        numberMap[3] = "def";
        numberMap[4] = "ghi";
        numberMap[5] = "jkl";
        numberMap[6] = "mno";
        numberMap[7] = "pqrs";
        numberMap[8] = "tuv";
        numberMap[9] = "wxyz";
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits.isEmpty())
            return res;

        StringBuilder str = new StringBuilder();
        helper(digits, str, 0, res);
        return res;
    }

    private void helper(String digits, StringBuilder str, int n, List<String>res) {
        if (digits.length() == n) {
            res.add(str.toString());
            return;
        }
        int index = digits.charAt(n) - '0';
        for (int i = 0; i < numberMap[index].length(); i++) {
            str.append(numberMap[index].charAt(i));
            helper(digits, str, n+1, res);
            str.deleteCharAt(str.length()-1);
        }
    }

    private String[] numberMap = new String[10];

}
//leetcode submit region end(Prohibit modification and deletion)


}