import java.util.PriorityQueue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42861
 * https://muhly.tistory.com/124
 * 크루스칼 알고리즘
 */
public class Algorithm_230113 {
    public static void main(String[] args) {

        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};

        System.out.println(solution(4, costs));
    }

    private static class Edge implements Comparable<Edge> {
        int from, to, cost;

        Edge(int from, int to, int cost) { // 간선문제는 from to를 만들어주는것이 좋다.
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    private static int[] parent;
    private static PriorityQueue<Edge> pq;

    public static int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        pq = new PriorityQueue<>();

        for (int i = 0; i < costs.length; ++i) {
            Edge edge = new Edge(costs[i][0], costs[i][1], costs[i][2]);
            pq.offer(edge);
        }

        for (int i = 0; i < n; ++i) parent[i] = i;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (find(edge.from) == find(edge.to)) {
                System.out.println(edge.from + "-" + edge.to + "패스");
                continue;
            } else {
                union(edge.from, edge.to);//유니온 알고리즘이 중요.
                answer += edge.cost;
            }
        }

        return answer;
    }

    public static int find(int n) {
        if (parent[n] == n) return n;
        return parent[n] = find(parent[n]);//재귀로 부모노드를 찾는 메소드
    }

    public static void union(int a, int b) {
        System.out.print("(" + a + "," + b + ")");
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
            System.out.println("rootB가 rootA로 변경:" + parent[rootB]);
        }
    }
}
