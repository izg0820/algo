package programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

//https://programmers.co.kr/learn/courses/30/lessons/43105
public class IntegerTriangle {

    public int solution(int[][] triangle) {
        int answer = 0;
        return answer;
    }

    @Test
    public void result() {
        assertThat(solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}))
                .isEqualTo(30);
    }
}
