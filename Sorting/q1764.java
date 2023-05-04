/*
 * 
 */

import java.util.*;
import java.io.*;

public class q1764{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] listen = new String[N];
        String[] see = new String[M];
        for(int i=0; i<N; i++){
            listen[i] = br.readLine();
        }
        for(int i=0; i<M; i++){
            see[i] = br.readLine();
        }
    }
}