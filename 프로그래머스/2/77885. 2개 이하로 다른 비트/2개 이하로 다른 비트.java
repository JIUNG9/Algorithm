class Solution {
    private long[] num;
    public long[] solution(long[] numbers) {
        
        long[] answer = new long[numbers.length];
        int answerIdx = 0;
        initDecimalArr();
        for(int i = 0; i < numbers.length; i++){
            int idx = 0;
            String criteria = converToDecimal(numbers[i]);
            while(!isDifferentUnder2(criteria,converToDecimal(numbers[i] + num[idx]))){
                idx++;
                //1,2,4를 더해야지 3,7 이렇게 누적합을 구하는 게 아니지
            }
            
            answer[answerIdx++] = numbers[i] + num[idx];
        }
        return answer;
        
    }
    public String converToDecimal(long number){
        StringBuilder sb = new StringBuilder();
        while(number > 0){
            sb.append(String.valueOf(number%2));
            number/=2;
        }
        return sb.reverse().toString();
    }
    public boolean isDifferentUnder2(String a ,String b){
        int counter = 0;

        while(a.length() < b.length()){
            a = "0" + a;
        }
        
        for(int i = a.length() -1 ; i >= 0; i--){
            if(a.charAt(i) != b.charAt(i)) counter++;
            if(counter > 2) return false;
        }
        
        
        return true;
        
    }
    
    
    public void initDecimalArr(){
        num = new long[100];
        num[0] = 1;
        num[1] = 2;
        for(int i = 2; i < 100; i++){
            num[i] = num[i-1] * 2;
        }
        
    
    }
    
}