class Solution {
    public String solution(String s) {
        //s의 길이가 200 문자열 -> 띄어쓰기로만해도 200개 -> n^2을 해도 괜찮다.
        //숫자는 단어의 첫 문자로만 나옵니다. -> 매번 숫자인지 아닌지 확인, 숫자가 아니라면 upperCase
        //구현 방법: 공백 기준으로 문자열을 나눈 후 첫 문자가 숫자가 아니라 영어라면 upper case로 수정
        //이후 하나의 문자열로 합치기
        
        
        String answer = "";
        s = s.toLowerCase();
        
        for(int i = 1; i < s.length(); i++){
            boolean flag = false;
            while(s.charAt(i) ==' ' && i < s.length()-1){
                    answer = answer.concat(" ");                        
                    i++;
                flag = true;
                
            }
            
            if(flag){
                answer = answer.concat(String.valueOf(Character.toUpperCase(s.charAt(i))));
            }
            else{
                answer = answer.concat(String.valueOf(s.charAt(i)));
                
            }
            
            
        }
        
        
        return String.valueOf(s.charAt(0)).toUpperCase() + answer;
        
    }
}
