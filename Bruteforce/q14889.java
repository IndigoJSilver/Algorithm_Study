/*
 * 4*4 일 때, 조합 방법
 * (1, 2), (3, 4) / (1, 3), (2, 4) / (1, 4), (2, 3)
 * dfs
 */
import java.util.*;
import java.io.*;

public class q14889 {
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int Min = Integer.MAX_VALUE;
    /*
     * public static int Min = Integer.MAX_VALUE; 이렇게 하면 
     * 하단에 Min = Math.min(score, Min); score에 에러 뜸
     * 이유는,
     * 'public 접근 제어자는 해당 멤버(변수 또는 메서드)에 대한 외부 접근을 허용.
     * 즉, 다른 클래스나 패키지에서도 접근할 수 있게 됀다.
     * 정적 변수 Min이 public으로 선언되면 외부에서 직접 접근하여 수정할 수 있다.
     * 다른 클래스나 패키지에서 Min 변수를 수정할 수 있다는 것은 예상치 못한 결과를 초래할 수 있으며,
     * 코드의 유지보수나 디버깅을 어렵게 할 수 있다.
     * 
     * Java에서는 객체 지향 프로그래밍의 개념에 따라 캡슐화를 지향.
     * 따라서 클래스의 멤버 변수는 보통 private 접근 제어자를 사용하여 외부에서 직접 접근할 수 없도록 힘.
     * 이를 통해 클래스 내부의 데이터를 보호하고 무결성을 유지할 수 있다.
     * 따라서 public static int Min = Integer.MAX_VALUE;와 같이 public 접근 제어자를 사용은 권장되지 않음.
     * 대신 private static int Min = Integer.MAX_VALUE;와 같이 private으로 선언하여 클래스 외부에서 접근할 수 없도록 하는 것이 더 좋은 설계.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        N  = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combi(0, 0);
        System.out.println(Min);
    }  
    
    static void combi(int idx, int c) { // idx는 index, c는 조합 개수(=재귀 깊이)
        if(c == N/2) { // 조합이 완성될 경우
            diff(); // 방문한 팀, 방문하지 않은 팀을 나누어 각각 팀 점수를 구하고 최솟값 찾기
            return;
        }

        for(int i=idx; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                combi(i+1, c+1);
                visited[i] = false;
            }
        }
    }

    static void diff() {
        int start = 0;
        int link = 0;

        for(int i=0; i<N-1; i++) { //   0       1   2
            for(int j=i+1; j<N; j++) { //1 2 3  2 3 3
                if(visited[i] == true && visited[j] == true) { // 방문한 팀
                    start += arr[i][j];
                    start += arr[j][i];
                }
                else if(visited[i] == false && visited[j] == false) { // 방문하지 않은 팀
                    link += arr[i][j];
                    link += arr[j][i];
                }
            }
        }

        int score = Math.abs(start-link); // 최솟값
        if(score == 0) { // 최솟값 0이면 가장 낮은 최솟값이므로 종료
            System.out.println(score);
            System.exit(0); // 정상종료
        }
        Min = Math.min(score, Min);
    }
}
