import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        k--; 
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        
    
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
    
        long[] factorial = new long[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        

        for (int i = 0; i < n; i++) {
            long fact = factorial[n - 1 - i];
            int index = (int) (k / fact); 
            answer[i] = list.remove(index); 
            k %= fact;
        }
        
        return answer;
    }
}
