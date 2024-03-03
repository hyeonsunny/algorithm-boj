package prefixSum.silver03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 구간 합 구하기 4
 * https://www.acmicpc.net/problem/11659
 */
public class B11659 {
    /**
     * 메모리 61928 KB
     * 시간 636 ms
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] prefixSum = new int[N];

        st = new StringTokenizer(br.readLine());

        //누적합
        for(int i = 0; i < N; i++) {
            if(i == 0) {
                prefixSum[0] = Integer.parseInt(st.nextToken());
                continue;
            }

            prefixSum[i] = prefixSum[i-1] + Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        //M개 연산
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a == 1) {
                sb.append(prefixSum[b-1] + "\n");
            }
            else {
                sb.append(prefixSum[b-1] - prefixSum[a-2] + "\n");
            }
        }

        System.out.println(sb.toString());
    }
}
