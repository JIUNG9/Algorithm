import java.util.Arrays;


class Solution
{
 public int solution(int[] A, int[] B) {

    Arrays.sort(A);
    Arrays.sort(B);

    int len = A.length;
    int result = 0;
    for(int i = 0; i < len; i++){
      result+=A[i] * B[(len-1)-i];
    }

    return result;
  }
}