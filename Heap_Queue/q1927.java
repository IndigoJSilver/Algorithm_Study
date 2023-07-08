/*
 * PriorityQueue 이용하는 문제
 * 힙은 최솟값 또는 최댓값을 빠르게 찾아내기 위해 완전이진트리 형태로 만들어진 자료구조
 * 우선순위 큐는 각 요소들이 각각의 우선 순위를 갖고 있고, 요소들의 대기열에서
 * 우선 순위가 높은 요소가 우선 순위가 낮은 요소보다 먼저 제공되는 자료구조
 * -> 우선순위가 높은 순대로 요소를 제공받음
 * 
 * 우선순위 큐를 구현하는 데 있어 가장 대표적인 구현 방식이 힙을 활용하는 방식
 * 부모 노드는 항상 자식 노드보다 우선순위가 높다
 * 내장되어 있는 우선순위 큐 우선순위 -> 오름차순 => 최소힙
 * 
 */

import java.io.*;
import java.util.*;

public class q1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            int n = Integer.parseInt(br.readLine());

            if(n==0) {
                if(heap.isEmpty()) {
                    System.out.println("0");
                }
                else {
                    System.out.println(heap.poll());
                }
            }
            else {
                heap.add(n);
            }
        }
    }
}