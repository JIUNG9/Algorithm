class Solution {
    static int answer = 0;
    static int counter;
    static final int MAX_LENGTH = 5;
    static final char[] words= {'A','E','I','O','U'};
    
  public void dfs(String target, String input) {
    if (input.length() > MAX_LENGTH) return;
    counter++;

    for (int i = 0; i < MAX_LENGTH; i++) {

      if (input.equals(target)) {
        answer = counter-1;
        break;
      }
      dfs(target, input + words[i]);
    }
  }
    
    public int solution(String word) {

    dfs(word, "");
    return answer;

  }
}