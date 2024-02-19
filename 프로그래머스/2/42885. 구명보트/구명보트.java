import java.util.Arrays;


class Solution {
  public int solution(int[] people, int limit) {
    int len = people.length;
    int left = 0;
    int right = len-1;
    int counter = 0;
    Arrays.sort(people);

    while(left <= right){
      if(people[left] >= limit) {
        left++;
        counter++;
      }
      else if (people[left] + people[right] <= limit){
        counter++;
        left++;
        right--;
      }
      else if(people[left] + people[right] > limit)
      {
        counter++;
        right--;
      }
    }
      //when break the loop by left index of array.
      //between left and right elements need boat for each person
      return counter;

    }
}