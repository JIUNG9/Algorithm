class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        int length = arr1.length;
        int width = arr2[0].length;
        
        int theWidthOfArr1 = arr1[0].length;
        
        int[][] target = new int[length][width];
        
        for(int i = 0; i < length; i++){
            for(int j = 0; j < width; j++){
                int sum = 0;
                for(int t = 0; t < theWidthOfArr1; t++){
                    sum+=(arr1[i][t] * arr2[t][j]);
                }
                target[i][j] = sum;
            }
        }
        return target;
        
        
        
    }

}