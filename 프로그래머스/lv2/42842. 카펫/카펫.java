class Solution {
    
    
    public int[] solution(int brown, int yellow) {
        //1. 약수 구하기 (x가 더 큰 약수)
        int area = brown + yellow;
        int limit =(int) Math.sqrt(area);
        for(int i = area; i >= limit; i--){
            if(area % i == 0){
                int x = i;
                int y = area / i;
                if((x-2) * (y-2) == yellow){
                    return new int[]{x,y};
                }
            }
        }
        return null;
    }
   
}