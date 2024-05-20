import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(B);
        Arrays.sort(A);
        
        int answer = 0;
        int aIdx = 0;
        int bIdx = 0;
        int aLen = A.length;
        int bLen = B.length;
        
        while(aIdx < aLen && bIdx < bLen){
            if(B[bIdx] > A[aIdx]){
                bIdx++;
                aIdx++;
                answer++;
                continue;
            }
            if(B[bIdx] <= A[aIdx]){
                bIdx++;
            }
                    
        }
        
        return answer;
    }
}