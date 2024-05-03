class Solution {
      private int answer = Integer.MIN_VALUE;
  public int solution(int[] stones, int k) {
   // mid 값을 순차적으로 뺏을 때 0 이하의 숫자가 연속적으로 K개 이상 나탔을 때
   // 해당 숫자는 건널 수 없다. -> 값을 줄인다. -> r = mid -1;
   // 만약 해당 숫자가 건널 수 있다. -> 값을 키운다.  l = mid + 1;

    int len = stones.length;
    int l = 0;
    int r = -1;
    int max = Integer.MIN_VALUE;
    for(Integer i : stones){
      if(i > max) max = i;
    }

    r = max;

    while(l <= r){
      int mid = (l+r)/2;
      int counter = 0;
      int maxCounter = 0;
      for(int i = 0; i < len; i++){
        if(stones[i] - mid < 0){
          counter++;
          maxCounter = Math.max(maxCounter,counter);
        }
        else{
          counter = 0;
        }
      }
      //건널 수 없다.
      if(maxCounter >= k){
        r = mid-1;
      }
      else{
        answer = Math.max(answer,mid);
        l = mid + 1;
      }

    }

    return answer;
}
}