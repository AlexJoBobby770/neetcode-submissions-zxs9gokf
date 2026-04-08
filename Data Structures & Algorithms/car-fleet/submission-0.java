class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int distance[][]= new int [position.length][2];
        Stack<Double> stack = new Stack<>();
        for(int i=0;i<position.length;i++)
        {
            distance[i][0]=position[i];
            distance[i][1]=speed[i];

        }
        Arrays.sort(distance,(a,b)-> Integer.compare(b[0],a[0]));
         for (int[] p : distance) {
            stack.push((double) (target - p[0]) / p[1]);
            if (stack.size() >= 2 &&
                stack.peek() <= stack.get(stack.size() - 2))
            {
                stack.pop();
            }
        }
        return stack.size();
    }   
}
