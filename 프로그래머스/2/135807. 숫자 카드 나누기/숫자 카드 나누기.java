import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        List<Integer> factorListA = getFactorByMinValue(arrayA);
        List<Integer> factorListB = getFactorByMinValue(arrayB);
        
        factorListA.sort((i1,i2)->{
            return i1.compareTo(i2);
        });
        factorListB.sort((i1,i2)->{
            return i1.compareTo(i2);
        });
        //get max value from the A 
        for(int i = factorListA.size()-1; i >= 0; i--){
            int input = factorListA.get(i);
            //모든원소가 나누어 떨어지지 않는 경우
            if(!isAtLeastElementDiviedByInput(arrayB,input)){
                answer = Math.max(answer,input);
            }
        }
        
        for(int i = factorListB.size()-1; i >= 0; i--){
                int input = factorListB.get(i);
                //모든원소가 나누어 떨어지지 않는 경우
                if(!isAtLeastElementDiviedByInput(arrayA,input)){
                    answer = Math.max(answer,input);
                }
        }
        
        
        return answer;
    }
    
    
    
    List<Integer> getFactorByMinValue(int[] sortedArr){
       int min = sortedArr[0];
        List<Integer> factorList = new ArrayList<>();
        List<Integer> commonFactor = new ArrayList<>();
        for(int i = min; i > 1; i--){
            if(min % i == 0) factorList.add(i);
        }
        
  
            for(int k = factorList.size()-1 ; k >=0; k--){
                boolean flag = true;
                int factor = factorList.get(k);
                for(int j = 0; j < sortedArr.length; j++){
                if(sortedArr[j] % factor != 0) 
                {
                    flag = false;
                    break;
                }
            }
            if(flag) commonFactor.add(factor);
        }
        
        return commonFactor;
    }
    
    public boolean isAtLeastElementDiviedByInput(int[] arr, int input){
        for(Integer i : arr){
            if(i % input == 0) return true;
        }
        return false;
    }
}