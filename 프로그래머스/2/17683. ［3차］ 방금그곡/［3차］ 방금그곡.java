import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        // List to store matching music entries
        List<Music> musicList = new LinkedList<>();

        // Convert the remembered melody by handling sharp notes properly
        String convertedM = convertMelody(m);
        
        for (String current : musicinfos) {
            String[] currentArr = current.split(",");
            String[] startStrTime = currentArr[0].split(":");
            String[] endStrTime = currentArr[1].split(":");

            int startHour = Integer.parseInt(startStrTime[0]);
            int startMin = Integer.parseInt(startStrTime[1]);
            int endHour = Integer.parseInt(endStrTime[0]);
            int endMin = Integer.parseInt(endStrTime[1]);

            String title = currentArr[2];
            String melody = convertMelody(currentArr[3]);  // Convert melody to handle sharp notes properly

            int minDifference = (endHour * 60 + endMin) - (startHour * 60 + startMin);

            // Repeat the melody to cover the full duration
            StringBuilder playedMelody = new StringBuilder();
            while (playedMelody.length() < minDifference) {
                playedMelody.append(melody);
            }
            // Cut the melody to fit the exact duration
            String finalMelody = playedMelody.substring(0, minDifference);

            // Check if the remembered melody is a part of the played melody
            if (finalMelody.contains(convertedM)) {
                musicList.add(new Music(minDifference, title));
            }
        }
        
        if (musicList.size() == 0) return "(None)";

        // Sort the list by duration descending, and by the order of appearance
        return musicList.stream()
                .sorted((m1, m2) -> Integer.compare(m2.getLength(), m1.getLength()))
                .collect(Collectors.toList())
                .get(0)
                .getTitle();
    }
    
    // Convert melody to handle sharp notes properly by replacing them with single characters
    private String convertMelody(String melody) {
        melody = melody.replace("C#", "c");
        melody = melody.replace("D#", "d");
        melody = melody.replace("F#", "f");
        melody = melody.replace("G#", "g");
        melody = melody.replace("A#", "a");
        melody = melody.replace("B#", "b");
        return melody;
    }
    
    class Music {
        private String title;
        private int length;
        
        public Music(int length, String title) {
            this.length = length;
            this.title = title;
        }
        
        public int getLength() {
            return this.length;
        }
        
        public String getTitle() {
            return this.title;
        }
    }
}
