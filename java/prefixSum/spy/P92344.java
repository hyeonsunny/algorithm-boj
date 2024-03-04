package prefixSum.spy;

import java.util.Arrays;

/**
 * 파괴되지 않은 건물
 * https://school.programmers.co.kr/learn/courses/30/lessons/92344
 */
public class P92344 {
    public static void main(String[] args) {
        int[][] board01 = {{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}};
        int[][] skill01 = {{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}};
        int result01 = 0;   //10

        int[][] board02 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] skill02 = {{1, 1, 1, 2, 2, 4}, {1, 0, 0, 1, 1, 2}, {2, 2, 0, 2, 0, 100}};
        int result02 = 0;   //6

        System.out.println(solution01(board01, skill01));
        System.out.println(solution01(board02, skill02));
    }

    /**
     * 정확성: 53.8
     * 효율성: 46.2
     * 합계: 100.0 / 100.0
     *
     * 정확성  테스트
     * 테스트 1 〉	통과 (0.02ms, 73.4MB)
     * 테스트 2 〉	통과 (0.03ms, 70.3MB)
     * 테스트 3 〉	통과 (0.08ms, 75MB)
     * 테스트 4 〉	통과 (0.12ms, 75.2MB)
     * 테스트 5 〉	통과 (0.19ms, 77.7MB)
     * 테스트 6 〉	통과 (0.29ms, 79.2MB)
     * 테스트 7 〉	통과 (0.40ms, 76.1MB)
     * 테스트 8 〉	통과 (0.90ms, 79.6MB)
     * 테스트 9 〉	통과 (0.70ms, 79.3MB)
     * 테스트 10 〉	통과 (1.15ms, 78MB)
     *
     * 효율성  테스트
     * 테스트 1 〉	통과 (68.25ms, 222MB)
     * 테스트 2 〉	통과 (66.08ms, 215MB)
     * 테스트 3 〉	통과 (63.26ms, 209MB)
     * 테스트 4 〉	통과 (62.82ms, 214MB)
     * 테스트 5 〉	통과 (46.04ms, 217MB)
     * 테스트 6 〉	통과 (41.79ms, 219MB)
     * 테스트 7 〉	통과 (58.88ms, 217MB)
     */
    public static int solution01(int[][] board, int[][] skill) {
        /*
        (x1, y1)+n, (x1, y2+1)-n
        (x2+1, y1)-n, (x2+1, y2+1)+n
         */
        int answer = 0;

        int[][] prefixSum = new int[board.length+1][board[0].length+1];

        for(int i = 0; i < skill.length; i++) {
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][5];

            prefixSum[r1][c1] = type == 1 ? prefixSum[r1][c1] - degree : prefixSum[r1][c1] + degree;
            prefixSum[r1][c2+1] = type == 1 ? prefixSum[r1][c2+1] + degree : prefixSum[r1][c2+1] - degree;
            prefixSum[r2+1][c1] = type == 1 ? prefixSum[r2+1][c1] + degree : prefixSum[r2+1][c1] - degree;
            prefixSum[r2+1][c2+1] = type == 1 ? prefixSum[r2+1][c2+1] - degree : prefixSum[r2+1][c2+1] + degree;
        }

        for(int i = 0; i < prefixSum.length; i++) {
            for(int j = 1; j < prefixSum[i].length; j++) {
                prefixSum[i][j] = prefixSum[i][j-1] + prefixSum[i][j];
            }
        }

        for(int i = 0; i < prefixSum[0].length; i++) {
            for(int j = 1; j < prefixSum.length; j++) {
                prefixSum[j][i] = prefixSum[j-1][i] + prefixSum[j][i];
            }
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                board[i][j] += prefixSum[i][j];

                if(board[i][j] > 0) answer++;
            }
        }

        return answer;
    }

    /**
     * 정확성: 53.8
     * 효율성: 0.0
     * 합계: 53.8 / 100.0
     *
     * 정확성
     * 테스트 1 〉	통과 (0.02ms, 80.6MB)
     * 테스트 2 〉	통과 (0.04ms, 64.7MB)
     * 테스트 3 〉	통과 (0.08ms, 79.9MB)
     * 테스트 4 〉	통과 (0.25ms, 80.9MB)
     * 테스트 5 〉	통과 (0.42ms, 78.1MB)
     * 테스트 6 〉	통과 (0.50ms, 76.2MB)
     * 테스트 7 〉	통과 (1.35ms, 72.5MB)
     * 테스트 8 〉	통과 (1.81ms, 79.2MB)
     * 테스트 9 〉	통과 (2.40ms, 76MB)
     * 테스트 10 〉	통과 (2.90ms, 81.1MB)
     *
     * 효율성
     * 테스트 1 〉	실패 (시간 초과)
     * 테스트 2 〉	실패 (시간 초과)
     * 테스트 3 〉	실패 (시간 초과)
     * 테스트 4 〉	실패 (시간 초과)
     * 테스트 5 〉	실패 (시간 초과)
     * 테스트 6 〉	실패 (시간 초과)
     * 테스트 7 〉	실패 (시간 초과)
     */
    public static int solution(int[][] board, int[][] skill) {
        int answer = 0;

        for(int i = 0; i < skill.length; i++) {
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][5];

            for(int j = r1; j <= r2; j++) {
                for(int k = c1; k <= c2; k++) {
                    if(type == 1) {
                        board[j][k] -= degree;
                    }
                    else {
                        board[j][k] += degree;
                    }
                }
            }
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] > 0) answer++;
            }
        }

        return answer;
    }
}
