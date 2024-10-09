import java.util.*;
class Solution {
    public int solution(int[] order) {
       //모든 택배를 실을 때까지, 현재 실어야할 택배가 컨테이너 벨트에 가장 위에 있는 택배가 더 작거나 비어있을 때, 현재 실어야할 택배보다 작은 택배들을 모두 컨테이너 벨트에 담는다. 이후 컨테이너 벨트에 존재하는 가장 위쪽의 원소와 동일하다면 정답을 하나 추가하고 컨테이너 벨트에서 한 개의 택배를 빼 트럭에 싣는다. 아니라면 현재 까지 트럭에 실었던 택배 개수를 반환한다.
        int answer = 0;
        int boxOrder = 1;
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < order.length; i++){
            int currentOrder = order[i];
            while(stk.isEmpty() || stk.peek() < currentOrder){
                stk.push(boxOrder++);
            }
            if(stk.peek() == currentOrder){
                stk.pop();
                answer++;
            }
            else{
                break;
            }
        }
        return answer;
    }
}