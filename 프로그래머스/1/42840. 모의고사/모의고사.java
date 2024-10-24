import java.util.*;

class Solution {
    private int[] a = {1,2,3,4,5};
    private int[] b = {2,1,2,3,2,4,2,5};
    private int[] c = {3,3,1,1,2,2,4,4,5,5};
    private int aCounter = 0;
    private int bCounter = 0;
    private int cCounter = 0;
    
    public int[] solution(int[] answers) {
        //각 수포자의 규칙을 구하여, 해당 규칙에 맞는 정답의 개수를 각각 구하여 가장 정답을 많이 맞춘 사람의 번호를 반환한다. 이때 여러명이라면 모두 담고 오름차순 정렬한다.
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == a[i%5]) aCounter++;
            if(answers[i] == b[i%8]) bCounter++;
            if(answers[i] == c[i%10]) cCounter++;
        }
        list.add(new int[]{1,aCounter});
        list.add(new int[]{2,bCounter});
        list.add(new int[]{3,cCounter});
        
        list.sort((arr1,arr2)->{
            return Integer.compare(arr2[1], arr1[1]);
        });
        
        if(list.get(0)[1] == list.get(1)[1] && list.get(1)[1] == list.get(2)[1]) return new int[]{1,2,3};
        if(list.get(0)[1] == list.get(1)[1]) return new int[]{list.get(0)[0], list.get(1)[0]};
        else{
          return new int[]{list.get(0)[0]};
        } 
        
        
        

    }
}