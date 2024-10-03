import java.util.*;

class Solution {
    public int[] solution(String msg) {
        // Initialize the dictionary
        Map<String, Integer> dict = new HashMap<>();
        List<Integer> answerList = new ArrayList<>();
        int dictSize = 26;
        
        // Initialize dictionary with single characters A-Z
        for (int i = 1; i <= 26; i++) {
            dict.put(String.valueOf((char) (i + 64)), i);  // A=1, B=2, ..., Z=26
        }
        
        int idx = 0;
        int len = msg.length();
        
        while (idx < len) {
            String pat = String.valueOf(msg.charAt(idx));  // Start with a single character
            int nextIdx = idx + 1;
            
            // Expand `pat` while it's in the dictionary
            while (nextIdx < len && dict.containsKey(pat + msg.charAt(nextIdx))) {
                pat += msg.charAt(nextIdx);
                nextIdx++;
            }
            
            // Add the index of the found string to the answer list
            answerList.add(dict.get(pat));
            
            // Add the new pattern `pat + next character` to the dictionary if possible
            if (nextIdx < len) {
                dict.put(pat + msg.charAt(nextIdx), ++dictSize);
            }
            
            // Move to the next character (beyond the current pattern)
            idx = nextIdx;
        }
        
        // Convert the answer list to an array and return
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}
