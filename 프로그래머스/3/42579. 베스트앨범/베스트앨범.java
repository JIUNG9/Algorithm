import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
class Solution {

  public int[] solution(String[] genres, int[] plays) {
      int len = genres.length;
      List<Integer> answerList = new ArrayList<>();
      Map<String,Integer> sumMap = new HashMap<>();
      Map<String, List<Music>> musicMap = new HashMap<>();

      for(int i = 0; i < len; i++){
        String key = genres[i];
        Integer value = plays[i];
        if(!musicMap.containsKey(key)) musicMap.put(key, new ArrayList<>());
        sumMap.put(key,sumMap.getOrDefault(key, 0) + value);
        List<Music> musicList = musicMap.put(key, musicMap.get(key));
        musicList.add(new Music(key,i, value));
        musicMap.put(key,musicList);
      }
      // sort by sumMap DESC
    List<String> sortedKey = sumMap.entrySet().stream().sorted((k1,k2)->{
      return Integer.compare(k2.getValue(),k1.getValue());
    }).map(Entry::getKey).collect(Collectors.toList());

      for(String k : sortedKey){
        List<Music> sortedMusic = musicMap.get(k).stream().sorted((m1,m2)->{
          return Integer.compare(m2.value,m1.value);
        }).collect(Collectors.toList());
        answerList.add(sortedMusic.get(0).idx);
        if(sortedMusic.size()>1){
        answerList.add(sortedMusic.get(1).idx);  
        }
        
      }

      return answerList.stream().mapToInt(i->i).toArray();
  }


  class Music{

    private String genre;
    private int idx;
    private int value;

    public Music(String genre, int idx, int value){
      this.genre= genre;
      this.idx = idx;
      this.value = value;
    }


  }
}