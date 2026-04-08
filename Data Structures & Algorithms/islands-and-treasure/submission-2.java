class Solution {
    public void islandsAndTreasure(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        // Step 1: Add all treasure cells (0) to queue
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(grid[r][c] == 0) {
                    q.add(new int[]{r, c});
                }
            }
        }

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        // Step 2: BFS
        while(!q.isEmpty()) {

            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            for(int[] d : directions) {

                int newR = r + d[0];
                int newC = c + d[1];

                // check bounds
                if(newR < 0 || newC < 0 || newR >= rows || newC >= cols)
                    continue;

                // skip walls and already visited cells
                if(grid[newR][newC] != 2147483647)
                    continue;

                // update distance
                grid[newR][newC] = grid[r][c] + 1;

                q.add(new int[]{newR, newC});
            }
        }
    }
}