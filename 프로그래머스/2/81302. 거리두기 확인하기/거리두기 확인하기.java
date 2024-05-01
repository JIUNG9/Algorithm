import java.util.*;
class Solution {
    
    
    private final int[][] moved = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private List<Integer> answerList;
    
  private boolean isRangeExceed(int currentX, int currentY, int len, int width) {
    return !(currentY < len && currentX < width && currentX >= 0 && currentY >= 0);
  }

  private boolean canGo(int currentX, int currentY, String[] arr) {
    return !isRangeExceed(currentX, currentY, arr.length, arr[0].length())
        && arr[currentY].charAt(currentX) != 'X';

  }

  //파티션으로 막혀있지 않으면 GO, 진행한 방향에서 돌아가지 않는 조건으로 한 번 더 GO, 만약 해당 위치가 P라면 anwserList에 0
  public int[] solution(String[][] places) {
    answerList = new ArrayList<>();
    for (String[] p : places) {
      boolean isViolated = false;
      for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
          if (p[i].charAt(j) == 'P') {
            int currentX = j;
            int currentY = i;
            for (int[] first : moved) {
              int firstStepX = currentX + first[0];
              int firstStepY = currentY + first[1];
              if (canGo(firstStepX, firstStepY, p)) {
                if (p[firstStepY].charAt(firstStepX) == 'P') {
                  isViolated = true;
                  break;
                }
                for (int[] second : moved) {
                  int secondStepX = firstStepX + second[0];
                  int secondStepY = firstStepY + second[1];
                  if (canGo(secondStepX, secondStepY, p)){
                    if (p[secondStepY].charAt(secondStepX) == 'P' && (secondStepX != currentX || secondStepY != currentY)) {
                      isViolated = true;
                      break;
                    }

                  }
                }

              }
            }
          }
        }
      }
      if(isViolated) answerList.add(0);
      else{
        answerList.add(1);
      }
    }
      return answerList.stream().mapToInt(i->i).toArray();
  }


}