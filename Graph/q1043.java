/*
 * LinkedList + BFS
 */

import java.util.*;
import java.io.*;

public class q1043 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int secret = Integer.parseInt(st.nextToken());
        
        LinkedList<Integer> know = new LinkedList<>();
        for(int i=0; i<secret; i++) {
            know.add(Integer.parseInt(st.nextToken()));
        }

        boolean[][] party = new boolean[M][N+1];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int partyN = Integer.parseInt(st.nextToken());
            for(int j=0; j<partyN; j++) {
                party[i][Integer.parseInt(st.nextToken())] = true;
            }
        }

        boolean[] knowing = new boolean[N+1];
        while(!know.isEmpty()) {
            int i = know.poll();
            knowing[i] = true;
            for(int j=0; j<M; j++) {
                if(party[j][i]) {
                    for(int k=1; k<N+1; k++) {
                        if(party[j][k] && !knowing[k]) {
                            know.add(k);
                            knowing[k] = true;
                        }
                    }
                }
            }
        }

        int sum = 0;
        for(int i=0; i<M; i++) {
            sum++;
            for(int j=1; j<N+1; j++) {
                if(party[i][j] && knowing[j]) {
                    sum--;
                    break;
                }
            }
        }
        System.out.println(sum);
    }
}