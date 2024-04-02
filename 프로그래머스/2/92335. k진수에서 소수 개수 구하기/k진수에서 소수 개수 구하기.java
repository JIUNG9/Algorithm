import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int counter = 0;
        List<Long> list = getNumberListByDigit(k,n);
        
        for(Long l : list){
            if(isPrime(l)) counter++;
        }
        return counter;
    }
    
    public List<Long> getNumberListByDigit(int digit, int num ){
        List<Long> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while( num / digit != 0){
            sb.append(String.valueOf(num%digit));
            num/=digit;
        }
            sb.append(num%digit);
        
        String[] criteria = sb.reverse().toString().split("0");
        
        for(String s: criteria){
            if(s.equals("")) continue;
            list.add(Long.parseLong(s));
        }
        return list;
    }
    
    public boolean isPrime(Long l){
        if(l==1) return false;
        if(l==2) return true;
        for(int i = 3; i <= Math.sqrt(l); i++){
            if(l%2 == 0) return false;
            if(l%i == 0) return false;
        }
        return true;
    }
}