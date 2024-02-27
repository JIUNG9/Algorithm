# [level 2] 튜플 - 64065 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/64065) 

### Consideration
- core logic: The Bigger number which the number of frequency should be front side.
- Use the Map for getting frequecy(weight)


#### How to remove bracket
``` java
public Map<Integer,Integer> getOnlyNumberHashMap(String s){
        
        int len = s.length();
        Map<Integer,Integer> map = new HashMap<>();
        
        
        for(int i = 0; i < len; i++){
                String temp="";
                for(; i < len && s.charAt(i) >= 48 && s.charAt(i) <=57 ; i++){
                    temp = temp.concat(String.valueOf(s.charAt(i)));
                }
                    if(!temp.equals("")){
                        Integer value = Integer.valueOf(temp);
                        map.put(value,map.getOrDefault(value,0) + 1);
                    }
                }
        return map;
            }
        }

```

- Alternative
  
``` java
Charater.getNumericValue()

```

#### How to change Map to Arr by value with DESC order


``` java
    List<Entry<Integer, Integer>> entry = map.entrySet().stream()
        .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue())).collect(Collectors.toList());

    int size = entry.size();
    int counter = 0;
    int[] arr = new int[size];
    for(Entry<Integer,Integer> e : entry){
      arr[counter++] = e.getKey();
    }
```
  
> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
