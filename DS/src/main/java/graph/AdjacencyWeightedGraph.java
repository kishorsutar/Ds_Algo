package graph;

import java.util.*;

public class AdjacencyWeightedGraph {

    private int vertCount, edgeCount;
    int[][] mat;

    public AdjacencyWeightedGraph(int vertexCount) {
        this.vertCount = vertexCount;
        mat = new int[vertCount][vertCount];
        for (int i = 0; i < vertCount; i++) {
            for (int j = 0; j < vertCount; j++) {
                mat[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    public void accept(Scanner sc) {
        System.out.println("Enter edges -  ");
        edgeCount = sc.nextInt();
        System.out.println("Enter number of " + edgeCount + "src - - dst");
        for (int i = 0; i < edgeCount; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();
            mat[src][dest] = weight;
            mat[dest][src] = weight;
        }
    }

    public void display() {
        for (int i = 0; i < vertCount; i++) {
            System.out.print("V" + i);
            for (int j = 0; j < vertCount; j++) {
                if (mat[i][j] == Integer.MAX_VALUE) {
                    System.out.print("\t" + "#");
                } else {
                    System.out.print("\t" + mat[i][j]);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello graph");
        AdjacencyWeightedGraph graph = new AdjacencyWeightedGraph(6);
        graph.accept(scanner);
        graph.display();
        graph.bfsTrav(0);
    }


    private void dfsV(int start) {
        boolean[] visited = new boolean[vertCount];
        Stack<Integer> stack = new Stack<>();

        stack.push(start);
        visited[start] = true;

        while (!stack.isEmpty()) {
            int vert = stack.pop();

            System.out.println(vert);

            for (int j = 0; j < vertCount; j++) {
                if (mat[vert][j] != Integer.MAX_VALUE
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

        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int v = q.poll();

            System.out.println(v + " Trav");

            for (int i = 0; i < vertCount; i++) {
                if (mat[v][i] != Integer.MAX_VALUE
                && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
