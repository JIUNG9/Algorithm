import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        //0번째 행은 1이 1개, 1번째 행은 2가 2개, 2번쨰 행은 3이 3개이다. 이후 각 행에는 다음에 올 숫자부터 n까지의 원소가 온다. i번째 행은 i+1을 i+1개만큼 집어넣고 이후 i+2부터 n까지의 값을 집어 넣는다.
        //모든 행과열의 경우의 수를 세게 된다면 10^14이므로 해당 행에 속하는 경우의 수만 고른다.
        
        //left에는 나머지 연산자 값 부터 right는 전체 사이즈에서 - (n - 나머지 연산자) 값 까지의 값을 구하여 해당 sub array를 반환한다.
        
        int ld = (int)(left / n);
        int rd = (int)(right / n);
        List<Integer> list = new ArrayList<>();
        for(int i = ld; i <= rd; i++){
            for(int k = 0; k < i + 1; k++){
                list.add(i+1);
            }
            for(int z = i + 2; z <= n; z++){
                list.add(z);
            }
        }
        // for(Integer i : list){
        //     System.out.println("i :" + i);
        // }
        
        
        return list.subList((int)(left%n), (list.size() + 1) - (n - (int)(right % n))).stream().mapToInt(i ->i).toArray();
        
    }
}