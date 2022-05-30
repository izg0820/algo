package programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

//https://programmers.co.kr/learn/courses/30/lessons/87390
public class N2ArraySplit {

    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = Math.max((int)((left + i) / n), (int)((left + i) % n)) + 1;
        }
        return answer;
    }

    @Test
    public void result() {
        assertThat(solution(3,2, 5)).isEqualTo(new int[]{3,2,2,3});
        assertThat(solution(4,7, 14)).isEqualTo(new int[]{4,3,3,3,4,4,4,4});
    }
}


