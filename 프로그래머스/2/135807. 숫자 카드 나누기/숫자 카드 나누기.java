import java.util.*;
import java.util.stream.*;

class Solution {
    Set<Integer> set;
    
        //A와 B의 공약수를 담은 것을 구하여, 해당 공약 수중 한 쪽은 모두 나누어 떨어지지만 한쪽은 모두 나누어 떨어지지 않는다면 해당 수를 반환한다. 그것이 아니라면 0을 반환한다.
    //공약수는 공통인 약수 가장 작은 값의 약수를 구하여 계산한다.
    
    
    public int solution(int[] a, int[] b) {
        set = new HashSet<>();
        int minA = getMinValue(a);
        int minB = getMinValue(b);
        
        addCommonDivisor(minA);
        addCommonDivisor(minB);
        
        List<Integer> sortedList = set.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        
        for(Integer i: sortedList){
           long aCounter = Arrays.stream(a).filter(num -> num%i == 0).count();
            long bCounter = Arrays.stream(b).filter(num -> num%i == 0).count();
            if((aCounter ==0 && bCounter == b.length) || (bCounter == 0 && aCounter == a.length)) return i;
        }
        return 0;
    
    }

    
    public void addCommonDivisor(int num){
        for(int i = 1; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                set.add(num/i);
                set.add(i);
            }
        }
    }
    public int getMinValue(int[] arr){
        int min = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(min > arr[i]) min = arr[i];
        }
        return min;
    }

    
}