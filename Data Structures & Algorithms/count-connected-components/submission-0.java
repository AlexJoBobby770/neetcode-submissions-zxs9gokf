class Solution {
    public int countComponents(int n, int[][] edges) {

        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            list.get(a).add(b);
            list.get(b).add(a);
        }

        boolean[] visited = new boolean[n];
        int components = 0;

        for(int i = 0; i < n; i++){
            if(!visited[i]){

                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                visited[i] = true;

                while(!q.isEmpty()){
                    int node = q.poll();

                    for(int nei : list.get(node)){
                        if(!visited[nei]){
                            visited[nei] = true;
                            q.offer(nei);
                        }
                    }
                }

                components++;
            }
        }

        return components;
    }
}