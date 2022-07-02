package programmers;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

//https://programmers.co.kr/learn/courses/30/lessons/12982
public class Budget {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);

        for (int department : d) {
            if (budget <  department) {
                break;
            }
            budget -= department;
            answer++;
        }
        return answer;
    }

    @Test
    public void result() {
        assertThat(solution(new int[]{1, 3, 2, 5, 4}, 9)).isEqualTo(3);
        assertThat(solution(new int[]{2, 2, 3, 3}, 10)).isEqualTo(4);
    }
}
