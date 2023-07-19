import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final int MAX_CANDIDATES = 20;
    private static final int MAX_VOTERS = 1000;

    private static final Map<String, Integer> candidateVotes = new HashMap<>();
    private static int numCandidates;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> candidateNames = new ArrayList<>();
        int[][] votes = new int[MAX_VOTERS][MAX_CANDIDATES];
        String input;
        int voterCount = 0;

        numCandidates = Integer.parseInt(reader.readLine());
        if (numCandidates > MAX_CANDIDATES) {
            throw new IOException("후보자 수가 " + MAX_CANDIDATES + "명보다 많습니다. " + MAX_CANDIDATES + "명 이하로 입력하세요");
        }

        for (int i = 0; i < numCandidates; i++) {
            String name = reader.readLine();
            if (name.length() > 80) {
                throw new IOException("후보자 이름이 80글자 이하로 작성하시오");
            }
            candidateVotes.put(name, 0);
            candidateNames.add(name);
        }

        while ((input = reader.readLine()) != null && input.length() > 0) {
            StringTokenizer tokenizer = new StringTokenizer(input);
            if (voterCount >= MAX_VOTERS) {
                throw new IOException("최대 투표 가능 인원수는 " + MAX_VOTERS + "명입니다.");
            }
            for (int i = 0; i < numCandidates; i++) {
                votes[voterCount][i] = Integer.parseInt(tokenizer.nextToken());
            }
            voterCount++;
        }

        for (int i = 0; i < voterCount; i++) {
            String name = candidateNames.get(votes[i][0] - 1);
            candidateVotes.put(name, candidateVotes.getOrDefault(name, 0) + 1);
        }

        while (true) {
            List<Map.Entry<String, Integer>> candidateList = new ArrayList<>(candidateVotes.entrySet());
            candidateList.sort(Map.Entry.comparingByValue());
            double maxPercentage = (candidateList.get(candidateList.size() - 1).getValue() / (double) voterCount) * 100;
            int minValue = candidateList.get(0).getValue();
            int maxValue = candidateList.get(candidateList.size() - 1).getValue();

            if (maxPercentage > 50 || minValue == maxValue) {
                Stack<String> winnerStack = new Stack<>();
                for (int i = candidateList.size() - 1; i >= 0; i--) {
                    winnerStack.push(candidateList.get(i).getKey());

                    if (i == 0 || !candidateList.get(i).getValue().equals(candidateList.get(i - 1).getValue())) {
                        break;
                    }
                }
                while (!winnerStack.isEmpty()) {
                    System.out.println(winnerStack.pop());
                }
                break;
            }

            for (int i = 0; i < candidateList.size() - 1; i++, voterCount--) {
                String name = candidateList.get(i).getKey();
                int index = candidateNames.indexOf(name);

                candidateList.remove(0);
                candidateVotes.remove(name);

                updateNextVote(votes, index + 1, candidateNames, minValue);

                if (!candidateList.isEmpty() && minValue != candidateList.get(0).getValue()) {
                    break;
                }
            }
        }
    }

    public static void updateNextVote(int[][] votes, int idx, List<String> candidateNames, int min) {
        for (int[] vote : votes) {
            if (vote[0] != idx) {
                continue;
            }

            for (int j = 1; j < numCandidates; j++) {
                String name = candidateNames.get(vote[j] - 1);

                if (candidateVotes.containsKey(name)) {
                    if (min < candidateVotes.get(name)) {
                        candidateVotes.put(name, candidateVotes.get(name) + 1);
                    }
                    break;
                }
            }
        }
    }
}