import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int len = gems.length;
        Set<String> uniqueGems = new HashSet<>(Arrays.asList(gems));
        int totalUniqueGems = uniqueGems.size();
        
        Map<String, Integer> gemCountMap = new HashMap<>();
        List<int[]> answerList = new ArrayList<>();
        
        int left = 0, right = 0;
        
        while (right < len) {
            // Expand the window by moving the right pointer
            gemCountMap.put(gems[right], gemCountMap.getOrDefault(gems[right], 0) + 1);
            right++;

            // Contract the window by moving the left pointer
            while (gemCountMap.size() == totalUniqueGems) {
                answerList.add(new int[]{left, right - 1});
                String leftGem = gems[left];
                gemCountMap.put(leftGem, gemCountMap.get(leftGem) - 1);
                if (gemCountMap.get(leftGem) == 0) {
                    gemCountMap.remove(leftGem);
                }
                left++;
            }
        }
        
        // Find the smallest range in answerList
        int[] answer = answerList.stream()
            .min((a, b) -> (a[1] - a[0] == b[1] - b[0]) ? Integer.compare(a[0], b[0]) : Integer.compare(a[1] - a[0], b[1] - b[0]))
            .get();
        
        return new int[]{answer[0] + 1, answer[1] + 1};
    }
}

