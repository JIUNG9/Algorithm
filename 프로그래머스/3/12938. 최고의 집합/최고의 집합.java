class Solution {
    public int[] solution(int n, int s) {
        
        int value = s / n;
        int remainder = s % n;
        int len = n;
        int lastIdx = len-1;
        int[] answer = new int[len];
        
        
        for(int i = 0; i < len; i++){
            answer[i] = value;
        }
        
        while(remainder > 0){
            answer[lastIdx--] +=1;
            remainder--;
            if(lastIdx == -1) lastIdx = len - 1;
        }
        return s / n == 0 ? new int[]{-1} : answer;
    }
}