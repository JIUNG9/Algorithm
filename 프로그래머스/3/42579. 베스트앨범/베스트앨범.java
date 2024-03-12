import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Solution {
  public int[] solution(String[] g, int[] p) {
    Map<String, List<Node>> nodeMap = new HashMap<>();
    Map<String, Integer> weightMap = new HashMap<>();
    for (int i = 0; i < g.length; i++) {
      List<Node> nodeList;
      if (nodeMap.containsKey(g[i])) {
        nodeList = nodeMap.get(g[i]);
        nodeList.add(new Node(i, p[i]));
      } else {
        nodeList = new ArrayList<>();
        nodeList.add(new Node(i, p[i]));
        nodeMap.put(g[i], nodeList);
      }

      weightMap.put(g[i], weightMap.getOrDefault(g[i], 0) + p[i]);
    }

    List<Integer> answerList = new ArrayList<>();
    Set<Entry<String, List<Node>>> nodeSet = nodeMap.entrySet();
    Set<Entry<String, Integer>> weightSet = weightMap.entrySet();
    List<Entry<String,Integer>> weightList = new ArrayList<>(weightSet);
    weightList.sort(((o1, o2) -> Integer.compare(o2.getValue(),o1.getValue())));

    for (Entry<String, Integer> weightEntry : weightList) {
      String genre = weightEntry.getKey();
      for (Entry<String, List<Node>> nodeEntry : nodeSet) {
        if (nodeEntry.getKey().equals(genre)) {
          nodeEntry.getValue().sort((o1, o2) -> {
            if (o1.play == o2.play) {
              return Integer.compare(o1.idx, o2.idx);
            } else {
              return Integer.compare(o2.play, o1.play);
            }
          });
          answerList.add(nodeEntry.getValue().get(0).idx);
          if (nodeEntry.getValue().size() >= 2) {
            answerList.add(nodeEntry.getValue().get(1).idx);
          }
        }
      }
    }
    return answerList.stream().mapToInt(i -> i).toArray();
  }

  class Node {

    private final int idx;
    private final int play;

    public Node(int idx, int play) {
      this.idx = idx;
      this.play = play;
    }


  }
}