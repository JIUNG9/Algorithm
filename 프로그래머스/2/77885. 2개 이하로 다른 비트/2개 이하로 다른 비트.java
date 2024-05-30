import java.util.*;

class Solution {
    private List<Long> cache;
    private long[] answer;
    public long[] solution(long[] numbers) {
        int len = numbers.length;
        int idx = 0;
        answer = new long[len];
        
        initCache();
        for(int i = 0; i < len; i++){
            long num = numbers[i];
            String strNum = convertToString(num);
            String reversed = new StringBuilder(strNum).reverse().toString();
            
            for(int j = 0; j < reversed.length(); j++){
                
                if(reversed.substring(j, j + 1).equals("0")) {
                    num+=cache.get(j);
                    for(int k = j-1; k >= 0; k--){
                        if(reversed.substring(k,k+1).equals("1")){
                            num-=cache.get(k);
                            break;

                        }
                    }
                    break;
                }
            }
            
            answer[idx++] = num;
        
        }
        
       
        
        return answer;
    }
    

    
    private void initCache(){
        cache = new ArrayList<>();
        cache.add(1L);
        int idx = 0;
        while(idx < 47){
            long recent = cache.get(idx);
            cache.add(recent * 2L);
            idx++;
        }
    }
 
    
    private String convertToString(long num){
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            sb.append(String.valueOf(num%2));
            num/=2;
        }
        sb.append("0");
        return sb.reverse().toString();
        
    }
    private long covnertToLong(String num){
        long result = 0L;
        StringBuilder sb = new StringBuilder(num);
        num = sb.reverse().toString();
        for(int i = 0 ;i < num.length(); i++){
            if(num.substring(i, i+1).equals("1")){
                result+=cache.get(i);
            }
        }
                    return result;

    }
    
    
    
}