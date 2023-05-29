/*
 * 퀸은 상하좌우, 대각선으로 움직일 수 있다
 * 첫 번째 열에 퀸을 놓고, 두 번째 퀸을 넣고.. 반복하다보면 결국 하나의 열에 한 개의 퀸 넣을 수 있음
 * -> 1차원 배열 이용(index를 퀸 위치 열cols, 값을 퀸 위치 행rows)
 * 
 * 
 */
import java.io.*;

public class q9663 {
    public static int[] arr;
    public static int N;
    public static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        nQueen(0);
        System.out.println(count);
    }    

    public static void nQueen(int depth) {
        if(depth == N) {
            count++;
            return;
        }

        for(int i=0; i<N; i++) {
            arr[depth] = i; // arr[0] = 0 즉, arr[열] = 행
            if(Possibility(depth)) { // 퀸을 놓을 수 있으면
                nQueen(depth+1); // 재귀
            }
        }
    }

    public static boolean Possibility(int cols) {
        for(int i=0; i<cols; i++) {
            if(arr[cols] == arr[i]) { // 같은 열일 때, 같은 행에 퀸이 있으면(중복 퀸)
                return false;
            }
            else if(Math.abs(cols-i) == Math.abs(arr[cols]-arr[i])) { // 대각선에 퀸이 있을 때. 열과 행의 차 == 대각선 위치
                return false;
            }
        }
        return true;
    }
}