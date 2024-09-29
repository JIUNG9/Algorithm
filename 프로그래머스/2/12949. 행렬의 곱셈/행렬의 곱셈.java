class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int len = arr1.length;
        int width = arr2[0].length;
        int[][] answer = new int[len][width];
        
        for(int i = 0; i < len; i++){
            for(int j = 0; j < width; j++){
                int sum = 0;
                for(int k = 0; k < arr2.length; k++){
                    sum+=(arr1[i][k] * arr2[k][j]);
                }
                answer[i][j] = sum;
            }
        }
        return answer;
        
    }
}