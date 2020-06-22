package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class AdjacencyUnweightedGraph {

    private int vertCount, edgeCount;
    int[][] mat;

    public AdjacencyUnweightedGraph(int vertexCount) {
        this.vertCount = vertexCount;
        mat = new int[vertCount][vertCount];
    }

    public void accept(Scanner sc) {
        System.out.println("Enter edges -  ");
        edgeCount = sc.nextInt();
        System.out.println("Enter number of " + edgeCount + "src - - dst");
        for (int i = 0; i < edgeCount; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            mat[src][dest] = 1;
            mat[dest][src] = 1;  // for unweighted graphs the value is 1.
        }
    }

    public void display() {
        for (int i = 0; i < vertCount; i++) {
            System.out.print("V"+i);
            for (int j = 0; j < vertCount; j++) {
                System.out.print("\t" + mat[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello graph");
        AdjacencyUnweightedGraph graph = new AdjacencyUnweightedGraph(6);
        graph.accept(scanner);
        graph.display();
        graph.bfsTrav(0);
    }




    private void dfsV(int start) {
        boolean[] visited = new boolean[vertCount];
        Stack<Integer> stack = new Stack<>();

        stack.push(start);
        visited[start] = true;

        while(!stack.isEmpty()) {
            int vert = stack.pop();

            System.out.println(vert);

            for (int j = 0; j < vertCount; j++) {
                if (mat[vert][j] == 1
                && !visited[j]) {
                    visited[j] = true;
                    stack.push(j);
                }
            }
        }
    }

    private void bfsTrav(int start) {
        boolean[] visited = new boolean[vertCount];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int v = q.poll();

            System.out.println(v + " ");

            for (int i = 0; i < vertCount; i++) {
                if (mat[v][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
