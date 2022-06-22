package programmers;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

//https://programmers.co.kr/learn/courses/30/lessons/43238
public class Immigration {

    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long start = 1;
        long end = (long) times[times.length - 1] * n;

        while (start <= end) {
            long sum = 0;
            long mid = (start + end) / 2;
            for(int time : times) {
                sum += mid / time;
            }
            if(sum >= n) {
                end = mid - 1;
                answer = mid;
            } else {
                start = mid + 1;
            }
        }
        return answer;
    }

    @Test
    public void result() {
        assertThat(solution(6, new int[]{7, 10})).isEqualTo(28);
    }
}
