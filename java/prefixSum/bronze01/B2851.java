package prefixSum.bronze01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 슈퍼 마리오
 * https://www.acmicpc.net/problem/2851
 */
class B2851 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];
        arr[0] = Integer.parseInt(br.readLine());

        for(int i = 1; i < arr.length; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(br.readLine());
        }

        int result = 0;
        for(int i = 1; i < arr.length; i++) {
            int prev = arr[i-1];
            int curr = arr[i];

            int c = Math.abs(100 - curr);
            int p = Math.abs(100 - prev);

            if(p == c) {
                result = prev > curr ? prev : curr;
            }
            else if(p > c) {
                result = curr;
            }
        }

        System.out.println(result);
    }
}