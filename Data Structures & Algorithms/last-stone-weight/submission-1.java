class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue <Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num:stones)
        {
            pq.offer(num);
        }
        while(pq.size()>1)
        {
            int x=pq.poll();
            int y=pq.poll();
            if(x<y)
            pq.offer(y-x);
            if(x>y)
            pq.offer(x-y);
        }
        if(pq.size()==0)
        return 0;

        return pq.peek();
    }
}
