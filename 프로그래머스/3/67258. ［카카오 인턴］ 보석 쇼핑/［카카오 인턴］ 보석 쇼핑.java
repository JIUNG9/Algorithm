import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        // Get the total number of unique gems
        Set<String> uniqueGems = new HashSet<>(Arrays.asList(gems));
        int totalUniqueGems = uniqueGems.size();

        // Map to keep track of the count of each gem in the current window
        Map<String, Integer> gemCountMap = new HashMap<>();
        int start = 0, end = 0;
        int leftPointer = 0, rightPointer = 0;
        int minLength = Integer.MAX_VALUE;

        // Two-pointer technique to find the smallest window
        while (rightPointer < gems.length) {
            // Expand the window by moving the right pointer
            gemCountMap.put(gems[rightPointer], gemCountMap.getOrDefault(gems[rightPointer], 0) + 1);
            rightPointer++;

            // Check if the current window contains all unique gems
            while (gemCountMap.size() == totalUniqueGems) {
                // Update the smallest window if the current one is smaller
                if (rightPointer - leftPointer < minLength) {
                    minLength = rightPointer - leftPointer;
                    start = leftPointer;
                    end = rightPointer;
                }

                // Shrink the window by moving the left pointer
                String leftGem = gems[leftPointer];
                gemCountMap.put(leftGem, gemCountMap.get(leftGem) - 1);
                if (gemCountMap.get(leftGem) == 0) {
                    gemCountMap.remove(leftGem);
                }
                leftPointer++;
            }
        }

        // Return the 1-based index of the start and end of the smallest window
        return new int[]{start + 1, end};
    }
}

