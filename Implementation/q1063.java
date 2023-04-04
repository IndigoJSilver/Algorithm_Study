/*
 * 체스판 범위 설정(킹과 돌이 범위 외에 있을 시 움직이지 않음)
 * 기존 좌표에 기반하여 움직이므로 clone() 필요
 * 킹과 돌의 위치 비교가 필요(같을 시 돌을 움직임)
 * case문을 사용하여 해당 문자가 입력되면 해당 조건에 맞게 움직이도록 조건을 걸어줌
 */

import java.io.*;
import java.util.*;

public class q1063{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] king = st.nextToken().toCharArray(); // 킹의 위치
        char[] stone = st.nextToken().toCharArray(); // 돌의 위치
        int N = Integer.parseInt(st.nextToken()); // 움직이는 횟수

        for(int i=0; i<N; i++){
            String str = br.readLine();
            char[] posK = king.clone(); // 킹 위치 클론하기(기존 좌표에 따라 움직이므로)
            char[] posS = stone.clone(); // 돌 위치 클론하기(이하 동문)

            move(str, posK); // 입력받은 움직여야 할 조건에 따라 킹 움직이기
            if(range(posK)){ // 옮길 킹의 위치가 체스판 범위 밖에 있으면
                continue; // 움직이지 않고 그냥 냅둠
            }
            if(Arrays.equals(posK, posS)){ // 움직인 킹과 돌의 위치가 같다면
                move(str, posS); // 돌의 위치를 움직인다
                if(range(posS)){ // 움직일 돌의 위치가 범위 밖이라면
                    continue; // 움직이지 않고 그냥 둔다
                }
            }
            king = posK;
            stone = posS;
        }
        System.out.println(king);
        System.out.println(stone);
    }
    public static boolean range(char[] next){ // 체스판 범위 외 설정
        return (next[0]<'A' || next[0]>'H' || next[1]<'1' || next[1]>'8');
    }

    public static void move(String pos, char[] next){
        switch(pos){
            case "R":{ // 한 칸 오른쪽으로
                next[0]++;
                break;
            }
            case "L":{ // 한 칸 왼쪽으로
                next[0]--;
                break;
            }
            case "B":{ // 한 칸 아래로
                next[1]--;
                break;
            }
            case "T":{ // 한 칸 위로
                next[1]++;
                break;
            }
            case "RT":{ // 오른쪽 위 대각선으로 
                next[0]++;
                next[1]++;
                break;
            }
            case "LT":{ // 왼쪽 위 대각선으로
                next[0]--;
                next[1]++;
                break;
            }
            case "RB":{ // 오른쪽 아래 대각선으로
                next[0]++;
                next[1]--;
                break;
            }
            case "LB":{ // 왼쪽 아래 대각선으로
                next[0]--;
                next[1]--;
                break;
            }
        }
    }
}