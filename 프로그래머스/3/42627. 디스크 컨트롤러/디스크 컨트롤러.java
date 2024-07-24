import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Job> jobQueue = new PriorityQueue<>((a, b) -> Integer.compare(a.duration, b.duration));
        
        int currentTime = 0;
        int totalWaitTime = 0;
        int jobIndex = 0;
        int jobCount = jobs.length;

        while (jobIndex < jobCount || !jobQueue.isEmpty()) {
            while (jobIndex < jobCount && jobs[jobIndex][0] <= currentTime) {
                jobQueue.add(new Job(jobs[jobIndex][0], jobs[jobIndex][1]));
                jobIndex++;
            }

            if (jobQueue.isEmpty()) {
                currentTime = jobs[jobIndex][0];
            } else {
                Job currentJob = jobQueue.poll();
                currentTime += currentJob.duration;
                totalWaitTime += (currentTime - currentJob.requestTime);
            }
        }

        return totalWaitTime / jobCount;
    }

    class Job {
        int requestTime;
        int duration;

        Job(int requestTime, int duration) {
            this.requestTime = requestTime;
            this.duration = duration;
        }
    }
}
     