import java.util.*;
class Solution {
    public int solution(int[] arr) {
        
        //arr의 원소의 끝에 도달할 때까지 arr을 정렬하여, 첫 원소부터 2개의 원소의 최소공배수를 구하여 현재 검사하는 원소를 두 수의 최소공배수로 업데이트하고 그 다음 원소와 다시 공약수를 구하여 최소공배수를 구하여 반복한다. 최종적으로 존재하는 값이 모든 수의 최소공배수이다.
        Arrays.sort(arr);
        for(int i = 1; i < arr.length; i++){
            //최소공배수
            //두 수의 공약수들 중 가장 큰 수를 얻어 arr의 원소들을 나눈 값과 공약수들 중 가장 큰 값을 구한다.
            //2번 째 comment의 의미는 GCD를 의미한다.
            List<Integer> cdList = getCD(arr[i-1], arr[i]);
            int lcd = cdList.get(cdList.size()-1);    
            
            
        
            arr[i] = lcd * (arr[i-1]/lcd) * (arr[i]/lcd);
        }
        return arr[arr.length-1];
    }
    public List<Integer> getCD(int min, int max){
        //공약수를 구하는 법은 1부터 작은 수를 기준으로 min까지 모두 양쪽을 나누어 둘 다 나누어 떨어지는 것이 공약수이다.
        List<Integer> cd = new ArrayList<>();
        for(int i = 1; i <= min ; i++){
            if(min%i == 0 && max % i == 0)
            {
                cd.add(i);
            }
        }
        return cd;
    }
    
}