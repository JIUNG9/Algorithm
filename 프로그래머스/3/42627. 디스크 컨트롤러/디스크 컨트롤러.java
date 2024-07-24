import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // Convert input array to a list of jobs with start times and durations
        List<Job> jobList = new ArrayList<>();
        for (int[] job : jobs) {
            jobList.add(new Job(job[0], job[1]));
        }
        
        // Sort jobs by their request time
        jobList.sort(Comparator.comparingInt(a -> a.requestTime));
        
        // PriorityQueue to process jobs by their duration (shortest job first)
        PriorityQueue<Job> jobQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.duration));
        
        int currentTime = 0;
        int totalWaitTime = 0;
        int jobIndex = 0;
        int jobCount = jobList.size();
        
        while (jobIndex < jobCount || !jobQueue.isEmpty()) {
            while (jobIndex < jobCount && jobList.get(jobIndex).requestTime <= currentTime) {
                jobQueue.offer(jobList.get(jobIndex));
                jobIndex++;
            }
            
            if (jobQueue.isEmpty()) {
                currentTime = jobList.get(jobIndex).requestTime;
            } else {
                Job currentJob = jobQueue.poll();
                currentTime += currentJob.duration;
                totalWaitTime += (currentTime - currentJob.requestTime);
            }
        }
        
        return totalWaitTime / jobCount;
    }
    
    // Inner class to represent a job
    static class Job {
        int requestTime;
        int duration;
        
        Job(int requestTime, int duration) {
            this.requestTime = requestTime;
            this.duration = duration;
        }
    }
}
