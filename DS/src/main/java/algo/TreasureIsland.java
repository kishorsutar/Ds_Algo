package algo;

import java.util.*;

public class TreasureIsland {

    public static void main(String[] args) {
        char[][] gried = {{'O', 'O', 'O', '0'},
                {'D', 'O', 'D', 'O'},
                {'O', 'O', 'O', 'O'},
                {'X', 'D', 'D', '0'}};
        int[][] grid = new int[][] {{0, 1, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0}};

        System.out.println(findTreasureIsland(gried));
    }

    static int findTreasureIsland(char[][] grid) {

        int steps = 0;
        if (grid.length == 0) return steps;
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        queue.add(new Point(0, 0));
        visited[0][0] = true;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Point p = queue.poll();
                int x = p.x;
                int y = p.y;
                if (grid[x][y] == 'X') return steps;

                for (int[] dir : dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];



                    if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length &&
                    grid[newX][newY] != 'D' && !visited[newX][newY]) {
                        queue.add(new Point(newX, newY));
                        visited[newX][newY] = true;
                    }
                }
            }

            steps++;
        }

        return 0;
    }

    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
