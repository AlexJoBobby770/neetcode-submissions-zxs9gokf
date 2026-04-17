class Solution {
    public int leastInterval(char[] tasks, int n) {

        int charFreq[] = new int[26];
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>((a, b) -> b - a);
        for(int i = 0; i < tasks.length; i++) {

            charFreq[tasks[i] - 'A']++;
        }
        for(int i = 0; i < 26; i++) {
            if(charFreq[i] > 0) {
                maxHeap.add(charFreq[i]);
            }
        }
        int ans = 0;
        while(!maxHeap.isEmpty()) {

            int taskCycle = 0;
            int cycle = n + 1;

            ArrayList<Integer> list = new ArrayList<>();

            while(cycle > 0 && !maxHeap.isEmpty()) {

                int currTask = maxHeap.poll();

                if(currTask > 1) {
                    list.add(currTask - 1);
                }

                taskCycle++;
                cycle--;
            }

            for(int ele : list) {
                maxHeap.add(ele);
            }


            ans += maxHeap.isEmpty() ? taskCycle : n + 1;
        }

        return ans;
    }
}
