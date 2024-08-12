class Solution {
    private int answer = 0;
    public int solution(int[] numbers, int target) {
        
        dfs(target, 0, numbers,0);
        return answer;
    }
    public void dfs(int target, int sum, int[] numbers, int depth){
        if(depth == numbers.length){
            if(target == sum) answer++; 
                return;
        }
                dfs(target, sum + numbers[depth], numbers, depth+1);
                dfs(target, sum - numbers[depth], numbers, depth+1);
        
    }
}