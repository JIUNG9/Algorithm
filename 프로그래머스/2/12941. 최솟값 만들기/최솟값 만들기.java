import java.util.*;
import java.util.stream.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        int sum = 0;
        int len = A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i = 0; i < A.length; i++){
            sum += (A[i] * B[len-i-1]);
            
        }
        return sum;
    }
    
}