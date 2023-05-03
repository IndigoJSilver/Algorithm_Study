/*
 * upperbound
 * '거리(distance)'를 기준으로 최소 거리에 따라 설치할 수 있는 공유기 개수가 달라짐
 * 최소 거리에 따라 설치 가능한 공유기 개수를 찾아 설치해야 할 공유기 개수를 비교하여 최대 거리를 찾아낸다
 * 거리를 줄이면 설치 가능한 공유기 개수가 늘어나고,
 * 거리를 늘리면 설치 가능한 공유기 개수가 줄어든다.
 * install(mid) < C 라면 거리가 너무 길어서 설치 가능 개수가 작다는 의미 -> max를 줄인다
 * install(mid) >= C 라면 거리가 너무 작아서 설치 가능 개수가 많다는 의미 -> min을 줄인다
 */

import java.util.*;
import java.io.*;

public class q2110 {
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int min = 1; // 최소 거리가 가질 수 있는 최솟값
        int max = arr[N-1] - arr[0] + 1; // 최소 거리가 가질 수 있는 최댓값, upperbound은 초과하는 첫 위치 반환이니 +1(초과)해줌
        while(min < max) {
            int mid = (min + max) / 2;
            
            if(install(mid) < C) { // mid거리에 따라 설치 가능한 공유기 개수가 C보다 적으면 거리 좁혀야 함
                max = mid; // max를 줄인다
            }
            else { // 설치 가능한 공유기 개수가 C보다 크거나 같으면, 거리 늘림 + 최소 거리가 가질 수 있는 '최대 거리' 찾아낸다
                min = mid + 1;
            }
        }
        System.out.println(min - 1); // upperbound -> -1 해줌
    }

    public static int install(int distance) { // 거리에 따라 설치 가능한 공유기 개수 찾기
        int count = 1; // 첫 번째 집은 설치했다고 가정
        int last = arr[0]; // 바로 직전에 설치한 집 위치

        for(int i=1; i<arr.length; i++){
            int locate = arr[i]; // 현재 탐색하는 집 위치
            if(locate - last >= distance) {  // 현재 탐색 집 위치 - 마지막 설치 집 위치가 최소거리(distance)보다 크거나 같으면
                count++; // 공유기 설치 개수 늘림
                last = locate; // 마지막 집 위치 업데이트
            }
        }
        return count; // 설치한 공유기 개수 반환
    }
}