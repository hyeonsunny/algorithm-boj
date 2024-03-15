package greedy.silver04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 걷기
 * https://www.acmicpc.net/problem/1459
 */
public class B1459 {
    /**
     * 메모리 14236 KB
     * 시간 124 ms
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer("4 2 3 10");
        System.out.println(solution(st));

        st = new StringTokenizer("4 2 3 5");
        System.out.println(solution(st));

        st = new StringTokenizer("2 0 12 10");
        System.out.println(solution(st));

        st = new StringTokenizer("25 18 7 11");
        System.out.println(solution(st));

        st = new StringTokenizer("24 16 12 10");
        System.out.println(solution(st));

        st = new StringTokenizer("10000000 50000000 800 901");
        System.out.println(solution(st));

        st = new StringTokenizer("135 122 43 29");
        System.out.println(solution(st));
    }

    public static long solution(StringTokenizer st) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        long result = 0;
        long X = Integer.parseInt(st.nextToken());
        long Y = Integer.parseInt(st.nextToken());
        long W = Integer.parseInt(st.nextToken());
        long S = Integer.parseInt(st.nextToken());

        long max = Math.max(X, Y);
        long min = Math.min(X, Y);
        long case1, case2, case3 = 0;

        case1 = (X + Y) * W;
        case2 = (min * S) + ((max - min) * W);
        case3 = (X + Y) % 2 == 0 ? max * S : ((max - 1) * S) + W;

        result = Math.min(case1, Math.min(case2, case3));

        return result;
    }

    //fail
    public static long solution01(StringTokenizer st) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        long result = 0;
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int p = X > Y ? Y : X;

        X -= p;
        Y -= p;

        result = W > S ? p * S : p * W;
        p = W < S ? W : S;
        result += (X * W) + (Y * W);

        return result;
    }
}
