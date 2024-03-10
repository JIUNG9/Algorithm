class Solution {
  private boolean[] visited;
  private int answer = Integer.MAX_VALUE;



  public int solution(String begin, String target, String[] words) {
    //1.50개의 단어이므로 완전탐색 접근
    //2.begin에서 한 단어만 수정되어야함 -> 순회시에 체크(달라진 단어가 한 개인지)
    //3. 방문되어있지 않아야함
    //2와 3을 만족하면  visited에 방문처리 후 begin을 업데이트 이후(words[i)) dfs()재귀
    //재귀가 pop이 될 때 visited arr를 false 처리
    //만약 begin과 taret이 일치하면 current의 answer과 비교하여 가장 작은 것을 answer로
    visited = new boolean[words.length];
    dfs(begin, target, words, 0, visited);
    return answer == Integer.MAX_VALUE  ? 0 : answer;

  }

  private void dfs(String begin, String target, String[] words, int counter, boolean[] visited) {

    for (int i = 0; i < words.length; i++) {
      if (begin.equals(target)) {
        answer = Math.min(counter, answer);
      }
      if(!visited[i]&&checkChangeOnlyOneWord(begin,words[i])){
        visited[i] =true;
        dfs(words[i],target,words,counter+1, visited);
        visited[i] =false;
      }
    }
  }

  private boolean checkChangeOnlyOneWord(String begin, String words) {
    int counter = 0;
    int len = begin.length();
    for(int i = 0; i < len ;i++){
      if(begin.charAt(i) == words.charAt(i)) counter++;
    }
      return len - counter <= 1;
  }
}