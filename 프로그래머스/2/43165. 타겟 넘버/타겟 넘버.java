class Solution {
    private int counter = 0;
    public int solution(int[] numbers, int target) {
        
        dfs(0,target, numbers,0);
        return counter;
    }
    public void dfs(int sum, int target, int[] numbers, int idx){
        if(idx == numbers.length){
          if(sum == target) counter++;  
        } 
        
        if(idx < numbers.length){
                dfs(sum + numbers[idx], target, numbers, idx+1);
                dfs(sum - numbers[idx], target, numbers, idx+1);
            }
    }
}