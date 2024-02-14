class Solution {
    
      private int counter = 0;

public int solution(int[] numbers, int target) {
    dfs(0, numbers, 0, target);
    return counter;
  }

  public void dfs(int i,int[] numbers, int sum, int target){


    if(i == numbers.length){
      if(sum== target) counter++;
    }
else{
      dfs(i+1,numbers,sum+numbers[i],target);
      dfs(i+1,numbers,sum+(-1)*numbers[i],target);
    }






  }
}