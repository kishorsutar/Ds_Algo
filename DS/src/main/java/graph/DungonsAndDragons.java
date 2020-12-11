package graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class DungonsAndDragons {

    private int R = 4, C = 4;
    private int[][] inputMatrix = new int[R][C];
    private Queue<Integer> rowQueue = new ArrayDeque<>();
    private Queue<Integer> colQueue = new ArrayDeque<>();

    private int nodes_in_layer = 0;
    private int nodes_left_in_layer = 1;

    private int moveCount = 0;

    private boolean reachedEnd = false;

    private boolean[][] visited = new boolean[R][C];

    // direction vectors
    private int[] dr = new int[]{-1, +1, 0, 0};
    private int[] dc = new int[]{0, 0, -1, +1};


    // example input, need to complete all the grid
    private void createDungonMatrix() {
        inputMatrix[0][0] = 'S';
        inputMatrix[2][3] = 'E';
        inputMatrix[1][1] = '#';
        inputMatrix[1][2] = 0;
        inputMatrix[0][1] = 0;
        inputMatrix[3][3] = 0;
        inputMatrix[2][2] = 0;
    }


    // breadth first search
    private int findAShortestPathInDungon() {

        int sr = 0;
        rowQueue.add(sr);
        int sc = 0;
        colQueue.add(sc);
        visited[sr][sc] = true;

        while (!rowQueue.isEmpty()) {

            int row = rowQueue.poll();
            int col = colQueue.poll();

            if (inputMatrix[row][col] == 'E') {
                reachedEnd = true;
                break;
            }

            visitNeighbouringNodes(row, col);
            nodes_left_in_layer--;
            if (nodes_left_in_layer == 0) {
                nodes_left_in_layer = nodes_in_layer;
                nodes_in_layer = 0;
                moveCount++;
            }
        }
        if (reachedEnd) {
            return moveCount;
        }

        return -1;
    }

    private void visitNeighbouringNodes(int row, int col) {
        for (int i = 0; i < 4; i++) {
            int rr = row + dr[i];
            int cc = col + dc[i];

            // skip out of bound locations
            if (rr < 0 || cc < 0) continue;
            if (rr >= R || cc >= C) continue;

            if (visited[rr][cc]) continue;
            if (inputMatrix[rr][cc] == '#') continue;

            visited[rr][cc] = true;
            rowQueue.add(rr);
            colQueue.add(cc);
            nodes_in_layer++;

        }
    }


}
