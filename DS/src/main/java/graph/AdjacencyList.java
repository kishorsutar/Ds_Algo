package graph;

import java.util.ArrayList;
import java.util.Scanner;

public class AdjacencyList {

    ArrayList<Edge>[] edges;

    public AdjacencyList(int vCount) {
        edges = new ArrayList[vCount];
        for (int i = 0; i < vCount; i++) {
            edges[i] = new ArrayList<Edge>();
        }
    }

    static class Edge {
        int src, dst, weight;

       public Edge(int s, int d, int w) {
            src = s;
            dst = d;
            weight = w;
        }

        @Override
        public String toString() {
            return "[" + src + "->" + dst + "(" + weight + ")]";
        }

    }

    public void accept(Scanner sc) {
        System.out.println("Enter Edge count: ");
        int edgeCount = sc.nextInt();
        System.out.println("Enter src ---> dest and weight");

        for (int i = 0; i < edgeCount; i++) {
            int src = sc.nextInt();
            int dst = sc.nextInt();
            int we = sc.nextInt();
            Edge e1 = new Edge(src, dst, we);
            edges[src].add(e1);
            Edge e2 = new Edge(dst, src, we);
            edges[dst].add(e2);

        }
    }

    public void display() {
        for (int i = 0; i < edges.length; i++) {
            System.out.println("V" + "\t" + i);
            for (Edge edge: edges[i]) {
                System.out.println("Edges --" + edge);
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        AdjacencyList obj = new AdjacencyList(6);
        Scanner sc = new Scanner(System.in);
        obj.accept(sc);
        obj.display();
        sc.close();
    }
}
