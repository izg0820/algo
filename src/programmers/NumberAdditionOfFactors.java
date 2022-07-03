package programmers;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

//https://programmers.co.kr/learn/courses/30/lessons/77884
public class NumberAdditionOfFactors {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            if (countDivisor(i)%2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        return answer;
    }

    public int countDivisor(int num) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                list.add(i);
                if (i != num / i) {
                    list.add(num / i);
                }
            }
        }
        return list.size();
    }

    @Test
    public void result() {
        assertThat(solution(13, 17)).isEqualTo(43);
        assertThat(solution(24, 27)).isEqualTo(52);
    }
}
