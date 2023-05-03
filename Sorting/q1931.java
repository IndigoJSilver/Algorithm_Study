/*
 * Comparator를 사용하여 정렬
 * 회의는 겹치지 않고 중간에 중단될 수 없음 -> 종료 시간을 기준으로 정렬
 * 종료시간이 같으면 시작 시간이 더 빠른순으로 정렬
 * 회의의 최대 개수는 정렬된 회의 시간들 중에 전 회의 종료 시간이 다음 회의 시작 시간보다 작거나 같은것 찾기
 */

import java.util.*;
import java.io.*;

public class q1931{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] time = new int[N][2];
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            time[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간 
        }
        Arrays.sort(time, new Comparator<int[]>() {
            public int compare(int[] t1, int[] t2){
                if(t1[1] == t2[1]){ // 종료 시간을 기준으로 같으면
                    return t1[0] - t2[0]; // 시작 시간이 빠른 순으로 정렬
                }
                return t1[1] - t2[1]; // 종료 시간 순으로 정렬. 양수면 시작시간이 크고 음수면 종료시간이 큼
            }
        });

        int I = 0;
        int prev = 0;
        for(int i=0; i<N; i++){
            if(prev <= time[i][0]){ // 전 회의 종료 시간이 시작시간보다 같거나 작으면 회의 개수++
                prev = time[i][1];
                I++;
            }
        }
        System.out.println(I);
    }
}