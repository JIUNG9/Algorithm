class Solution {
    public long solution(int n, int[] times) {
        long left = 0L;
        long right = 1000000000L * 1000000000L;
        long answer =  Long.MAX_VALUE;
        
        while(left <= right){
            long mid = (left + right) / 2;
            long sum = 0L;
            for(Integer t : times){
                sum+=(mid / (long)t);
            }
            if(sum >= n){
                answer = Math.min(mid,answer);
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }        
        return answer;
    }
}