public class longestSubsequence {
    public int longestSubsequence(int[] arr, int difference) {
        // Map the number to the exist max sequence.
        Map<Integer, Integer> m = new HashMap<>();
        int maxLength = 1;
        for(int num: arr){
            int expectedNum = num - difference;
            if(m.containsKey(expectedNum)){
                int count = m.get(expectedNum) + 1;
                m.put(num, count);
                if (count > maxLength) {
                    maxLength = count;
                }
            }else{
                m.put(num, 1);
            }
        }
        return maxLength;
    }
}