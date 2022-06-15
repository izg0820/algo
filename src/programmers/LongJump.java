package programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongJump {

    public int solution(int n) {
        int[] answer = new int[n + 1];
        answer[0] = 1;
        if (n == 1) {
            return 1;
        }
        answer[1] = 2;

        for (int i = 2; i < n; i++) {
            answer[i] = (answer[i - 2] + answer[i - 1]) % 1234567;
        }
        return answer[n-1];
    }

    @Test
    public void result() {
        assertThat(solution(4)).isEqualTo(5);
        assertThat(solution(3)).isEqualTo(3);
    }

}
