class Solution {
    private int counter = 0;
    public int solution(int n) {
        //만약 현재 sum이 n보다 작다면 right pointer를 증가시켜 sum에 더한다.
        //만약 현재 sum이 n보다 크다면 left pointer를 증가시켜 sum을 뺀다.
        //left와 right가 같아질 때까지 반복한다.
        int left = 1;
        int right = 1;
        int sum = 0;
        while(left <= right && left <= n){
            if(sum == n) 
            {
                counter++; 
                sum-=left++;
            }
            else if(sum < n){
                sum+=right++;
            }
            else{
                sum-=left++;
            }
        }
            return counter;
        
    }
}