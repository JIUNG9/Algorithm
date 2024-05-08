class Solution {
    private int counter =0;
    private int answer = 0;
    public int solution(String word) {
        String[] arr = new String[]{"A","E","I","O","U"};
        dfs(word,"",arr);
        return answer;
        
    }
    public void dfs(String target, String curr,  String[] arr){
        for(int i = 0; i < arr.length; i++){
            if(target.equals(curr+arr[i])){
                answer = counter+1;
                System.out.println(curr);
            }
            if(curr.length() < arr.length){
                counter++;
                dfs(target,curr+arr[i],arr);
            }
        }
    }
}