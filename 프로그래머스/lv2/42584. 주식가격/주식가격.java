import java.util.Stack;

class Solution {
 public int[] solution(int[] p) {
    int len = p.length;
    int maxIndex = len -1;
    int[] returnArr = new int[len];
    Stack<Integer> stk = new Stack<>();
    for(int i = 0; i < len; i++){
      while(!stk.isEmpty() && p[i] < p[stk.peek()]){
        int index = stk.pop();
        returnArr[index] = i - index;
        }
      stk.push(i);
    }

    while(!stk.isEmpty()){
      int index = stk.pop();
      returnArr[index] = maxIndex - index;
    }
    return returnArr;
  }

}