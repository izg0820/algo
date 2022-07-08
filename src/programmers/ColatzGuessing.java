package programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

//https://school.programmers.co.kr/learn/courses/30/lessons/12943
public class ColatzGuessing {

    public int solution(int n) {
        long num = n;
        int answer = 0;
        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else{
                num = num * 3 + 1;
            }
            answer++;
            if (answer > 500) {
                return -1;
            }
        }
        return answer;
    }

    @Test
    public void result() {
        assertThat(solution(6)).isEqualTo(8);
        assertThat(solution(16)).isEqualTo(4);
        assertThat(solution(626331)).isEqualTo(-1);
    }
}
