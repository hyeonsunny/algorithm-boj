package prefixSum.silver03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 줄줄이 박수
 * https://www.acmicpc.net/problem/29718
 *
 * 키워드 : 누적합, 슬라이딩 윈도우 알고리즘
 */
public class B29718 {
    /**
     * 메모리 266992 KB
     * 시간 928 ms
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] numArr = new int[N][M];

        //N행 별 박수
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++) {
                numArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());

        int[] prefixSum = new int[M];

        //M열(구간) 별 박수 누적합
        for(int i = 0; i < M; i++) {
            int sum = numArr[0][i];

            for(int j = 1; j < N; j++) {
                sum += numArr[j][i];
            }

            prefixSum[i] = sum;
        }

        int max = slidingWindow(A, prefixSum);
        System.out.println(max);
    }

    public static int slidingWindow(int A, int[] prefixSum) {
        int sum = 0;

        for(int i = 0; i < A; i++) {
            sum += prefixSum[i];
        }

        int max = sum;
        for(int i = A; i < prefixSum.length; i++) {
            sum += prefixSum[i] - prefixSum[i-A];
            max = Math.max(sum, max);
        }

        return max;
    }
}
