import java.util.*;
import java.util.regex.*;

class Solution {
    private int answer =0;
    public int solution(int n, int k) {
        
        String str = convertToN(n,k);
        Pattern p = Pattern.compile("([^0]+)");
        Matcher m = p.matcher(str);
        List<Long> list = new ArrayList<>();
        
        while(m.find()){
            String pat = m.group(0);
            list.add(Long.parseLong(pat));
        }
        for(int i = 0; i < list.size(); i++){
            if(isPrime(list.get(i))) answer++;
        }
               return answer;
    }
    
    public String convertToN(int n, int k){
        StringBuilder sb = new StringBuilder();
        if(n == 0) return "0";
        while(n > 0){
            sb.append(String.valueOf(n%k));
            n/=k;
        }
        return sb.reverse().toString();
    }
    public boolean isPrime(long num){
        if(num<=1) return false;
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num%i==0) return false;
        }
        return true;
    }
}