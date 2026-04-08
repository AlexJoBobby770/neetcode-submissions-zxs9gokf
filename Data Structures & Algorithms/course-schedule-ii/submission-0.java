class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();

        int arr[]= new int[numCourses];
        int k=0;
        Queue<Integer> q = new LinkedList<>();
        for( int  i=0;i<numCourses;i++)
        {
            list.add(new ArrayList<>());
        }
        int indegree[]= new int[numCourses];
        for(int pre[]:prerequisites)
        {
            int curr=pre[0];
            int prereq=pre[1];
            list.get(prereq).add(curr);
            indegree[curr]++;
        }
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
            q.offer(i);
        }
        int processed=0;
        while(!q.isEmpty())
        {
            int val=q.poll();
            processed++;
        
            arr[k++]=val;
            for(int a:list.get(val))
            {
                
                indegree[a]--;
                if(indegree[a]==0)
                q.offer(a);
            }
        }
        if(processed==numCourses)
        return arr;

        return new int[]{};
    }
}