/*
 * List vs ArrayList -> 인터패이스와 클래스. 아래의 결과는 같음. 다만 list가 더 유연하다. 즉 generic하게 쓸 수 있음.
 * List <Object> list = new ArrayList <>();  
 * -> 도형 list = new 정사각형();
 * ArrayList <Object> list = new ArrayList <>();
 * -> 정사각형 list = new 정사각형();
 * 
 * ArrayList vs LinkedList
 * 1. ArrayList(배열과 유사)
 * 중복 허용, 순서 유지하며 인덱스로 데이터 관리. 클래스이므로 배열 추가, 삭제 하는 메소드 존재.
 * 추가했을 때, 배열 크기가 동적으로 커지지 않아, 꽉 차면 더 큰 용량의 배열을 만들어 옮겨야 함.
 * 
 * API 종류
 * add(E element) -> 원소 마지막에 추가
 * add(int index, E element) -> 원소를 지정된 위치에 추가
 * remove(int index) -> 원소의 인덱스로 삭제
 * get(int index) -> 인덱스에 해당하는 원소 찾기
 * 
 * 2. LinkedList(배열 단점 보안 위해)
 * 크기 변경 불가 -> 새 배열 생성하여 복사해야함.
 * 비순차적인 데이터 추가, 삭제 시간 오래 걸림
 * 
 * API 종류
 * 상동
 * 
 * 순차 추가/삭제 -> ArrayList가 빠름
 * 중간 데이터 추가/삭제 -> LinkedList가 빠름
 * 
 * 시간복잡도
 *                  ArrayList   LinkedList
 * add()                O(1)        O(1)
 * add(index, value)    O(N)        O(1)
 * remove(index)        O(N)        O(1)
 * remove(value)        O(N)        O(1)
 * get(index)           O(1)        O(N)
 * indexOf(value)       O(N)        O(N)
 * 
 * 그래서 해당 문제는 ArrayList로 푸는게 메모리 상 좋다.
 * 
 * Queue의 구현체는 LinkedList.
 * 큐는 항상 첫 번째 데이터를 삭제하므로 ArrayList를 사용하게 되면 빈공간을 채우기 위해 데이터의 복사가 발생 -> 비효율적
 * 그래서 중간 데이터 추가/삭제 쉬운 LinkedList 사용.
 * 
 * Queue API
 * add() -> 맨 뒤에 삽입. 추가 성공 true, 꽉 차면 에러
 * offer() -> 맨 뒤에 삽입. 추가 성공 true, 실패 false 반환
 * remove() -> 맨 앞에 있는 값 반환 후 삭제. 비어있으면 에러
 * poll() -> 맨 앞에 있는 값 반환 후 삭제. 비어있으면 null 반환
 * clear() -> 큐 비우기
 * element() -> 맨 앞에 있는 값 반환. 비어있으면 에러
 * peek() -> 맨 앞에 있는 값 반환. 비어있으면 null 반환
 * 에러 -> add, remove, element
 * null, false -> offer, poll, peek
 */
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