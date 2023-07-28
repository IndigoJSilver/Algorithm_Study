import java.util.*;
import java.io.*;

public class q11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));      

        int N = Integer.parseInt(br.readLine());
        List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        
        int[] parent = new int[N+1];
        for(int i=0; i<N+1; i++) {
            list.add(new ArrayList<Integer>());
        }

        for(int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            list.get(n1).add(n2);
            list.get(n2).add(n1);
        }

        boolean[] visited = new boolean[N+1];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(1); // 최상위 루트는 항상 1
        visited[1] = true;

        while(!queue.isEmpty()) { // BFS
            int tmp = queue.remove(); // 현재 처리중인 노드
            for(int node : list.get(tmp)) { // tmp와 연결된 자식 노드들을 담은 리스트를 반환
                if(!visited[node]) { // 자식 노드 방문 안했으면 실행
                    visited[node] = true; // 방문했으니 true
                    queue.add(node);
                    parent[node] = tmp;
                }
            }
        }

        for(int i=2; i<N+1; i++) { // 부모 노드 출력(2번 노드부터)
            System.out.println(parent[i]);
        }
    }
}