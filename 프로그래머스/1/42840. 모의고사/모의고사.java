import java.util.*;
class Solution {
  public int[] solution(int[] answer) {

    int[] a = {1, 2, 3, 4, 5};
    int[] b = {2, 1, 2, 3, 2, 4,2,5};
    int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    int aLen = a.length;
    int bLen = b.length;
    int cLen = c.length;
    int answerLen = answer.length;

    int aCounter = 0;
    int bCounter = 0;
    int cCounter = 0;

    //find the counter value of each student
    for (int i = 0; i < answerLen; i++){
      if(a[i%aLen]==answer[i]) aCounter++;
      if(b[i%bLen]==answer[i]) bCounter++;
      if(c[i%cLen]==answer[i]) cCounter++;
    }


    //get maximum value

    List<Integer> tempList = new ArrayList<>();
    int maxValue = Math.max(aCounter,Math.max(bCounter,cCounter));

    if(aCounter == maxValue) tempList.add(1);
    if(bCounter == maxValue) tempList.add(2);
    if(cCounter == maxValue) tempList.add(3);

    return tempList.stream().mapToInt(i-> i).toArray();


  }
    
}