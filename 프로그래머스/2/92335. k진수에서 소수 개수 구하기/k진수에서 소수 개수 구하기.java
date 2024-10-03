import java.util.*;
import java.util.regex.*;

class Solution {
    private int answer =0;
    public int solution(int n, int k) {
        //문제 풀이 0P0, P0, 0P, P를 표현할 수 있는 정규식을 찾아야한다.
        //4개의 모든 경우는 0을 제외하고 표현되는 숫자의 연속이다. 따라서 맨 앞의 0을 제외한 연속된 숫자의 연속적인 그룹핑은 0P, 0P0, 0P를 표현하고 0이 없다면 P를 표현할 수 있다. 따라서 정규식을 사용할 수도 있고, split "0"을 사용할 수도 있다.
        //1,000,000를 2진수로 표현하면 21억 즉 Integer의 범위를 벗어난다. 따라서 Long으로 형전환을 해야한다.
        
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