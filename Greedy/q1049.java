/*
 * 끊어진 기타줄 개수와 기타줄 브랜드 수가 주어진다
 * 팩 가격과 낱개 가격을 비교하여 가장 저렴한 가격을 구하라
 */
import java.util.*;

public class q1049{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 끊어진 기타줄 개수
        int M = sc.nextInt(); // 기타줄 브랜드 수
        int res = 0;

        int[] pack = new int[M]; // 6개 팩 가격
        int[] single = new int[M]; // 낱개 가격

        for(int i=0; i<M; i++){
            pack[i] = sc.nextInt();
            single[i] = sc.nextInt();
        }

        Arrays.sort(pack);
        Arrays.sort(single);

        res = Math.min(((N/6)+1)*pack[0], N*single[0]); // 6개 팩 구매 vs 낱개 구매
        res = Math.min(res, (N/6)*pack[0]+(N%6)*single[0]); // (6개 팩 구매 vs 낱개 구매) vs 6게 팩 + 낱개 구매

        System.out.println(res);
        sc.close();
    }
}