import java.util.stream.*;
import java.util.*;
class Solution {
    List<Integer> list;
    List<Integer> answerList;
    public int[] solution(int n, long left, long right) {
        list = new ArrayList<>();
        answerList = new ArrayList<>();
        
        int startRow = (int)(left / n) ;
        int endRow = (int) (right / n) ; 
        int startRemainder = (int)(left % n);
        int endRemainder = (int) (right % n);
        
        for(int i = startRow; i <= endRow; i++){
            int num = i+1;
            for(int j = 0; j < num; j++){
                list.add(num);
            }
            for(int k = num+1 ; k <= n; k++){
                list.add(k);
            }
    }

    for(int i = startRemainder; i <= list.size() - n + endRemainder; i++){
        answerList.add(list.get(i));
    }
    
    return answerList.stream().mapToInt(i -> i).toArray();
    
}
}