import java.util.*;
class Solution {
    private List<Integer> answerList;
    private boolean[][] visited;
    private int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
    public int[] solution(String[] maps) {
        int len = maps.length;
        int width = maps[0].length();
        visited = new boolean[len][width];
        answerList = new ArrayList<>();
        
        for(int i = 0; i < len; i++)
        {
            for(int j = 0; j < width; j++){
                char c = maps[i].charAt(j);
                if(c!='X' && !visited[i][j]){
                    int counter = 0;
                    Queue<Person> q = new LinkedList<>(); 
                    counter+=Character.getNumericValue(maps[i].charAt(j));
                    q.add(new Person(0,new Location(i,j)));
                    visited[i][j] = true;

                    while(!q.isEmpty()){
                        Person person = q.poll();
                        Location l = person.location;

                        for(int[] m : move){
                            int y = l.y + m[0];
                            int x = l.x + m[1];
                            if(rangeCheck(y,x,len,width) && !visited[y][x] && maps[y].charAt(x) !='X'){
                                visited[y][x] = true;
                                counter+=Character.getNumericValue(maps[y].charAt(x));
                                Person newP = new Person(0,new Location(y,x));
                                q.add(newP);    
                            }
                        }
                    }
                    answerList.add(counter);
                }
            }
                    
        }    
        if(answerList.size()==0) return new int[]{-1};
        return answerList.stream().sorted().mapToInt(i->i).toArray();
        
    
    }
    
    public boolean rangeCheck(int y,int x ,int len, int width){
        if(x >= 0 && y >= 0 && x < width && y < len) return true;
        return false;
    }
     class Person{
        private int stayNight;
        private Location location;
         
        public Person(int stayNight, Location location){
            this.stayNight = stayNight;
            this.location = location;
        }
    }
     class Location{
        int y;
        int x;
        public Location(int y, int x){
            this.x = x;
            this.y = y;
        }
        
    }
}