class Solution {
    private boolean[] visited;
    private int answer = 0;
    public int solution(int[] numbers, int target) {
        //모든 숫자를 !순차적으로!(single path) 한 번씩 + 혹은 -를 통하여 모두 사용하여 총합이 target이 된다면 정답의 가지 수를 1만큼 추가하여 반환한다.
        //완탐, dfs, heap -> answer, 방문 배열 stack -> 총 합, target, 현재 depth, len, for loop를 사용하는가 사용하지 않는가
        //틀린 부분 -> for loop를 사용 : graph traversal을 사용
        //고친 부분 -> 해당 문제는 single path이므로 for loop를 사용하지 않고 구현
        int len = numbers.length;
        visited = new boolean[len];
        dfs(0,numbers,target, 0,len);
        return answer;
        
    }
    public void dfs(int sum, int[] n,int target, int depth, int len){
        if(depth == len && sum == target) {
            answer++;
        }
         else if(depth < len){
            dfs(sum+n[depth], n , target, depth +1, len);
            dfs(sum-n[depth], n , target, depth +1, len);
         }
                
        }
    }
