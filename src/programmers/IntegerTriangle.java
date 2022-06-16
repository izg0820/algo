package programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

//https://programmers.co.kr/learn/courses/30/lessons/43105
public class IntegerTriangle {

    public int solution(int[][] triangle) {
        int answer = 0;
        int[] dp = new int[triangle.length];
        dp[0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            for (int k = 0; k < triangle[i].length; k++) {
                int left = -1, right = -1;
                if (k > 0) {
                    left = triangle[i - 1][k - 1] + triangle[i][k];
                }
                if( k < triangle[i-1].length) {
                    right = triangle[i - 1][k] + triangle[i][k];
                }
                triangle[i][k] = Math.max(left, right);
                answer = Math.max(answer, triangle[i][k]);
            }
        }
        return answer;
    }

    public int solution2(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;

        for (int i = 1; i < n; i++) {
            for (int k = 0; k <= i; k++) {
                if (k == 0) { //맨 왼쪽 오른쪽으로 갔을때만 계산
                    triangle[i][k] += triangle[i - 1][k];
                } else if (i == k) { //맨 오른쪽 왼쪽으로 갔을 때만 계산
                    triangle[i][k] += triangle[i - 1][k - 1];
                } else{
                    triangle[i][k] += Math.max(triangle[i - 1][k], triangle[i - 1][k - 1]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, triangle[n - 1][i]);
        }
        return answer;
    }


    @Test
    public void result() {
        assertThat(solution2(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}))
                .isEqualTo(30);
    }
}
