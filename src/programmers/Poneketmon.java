package programmers;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

//https://school.programmers.co.kr/learn/courses/30/lessons/1845
public class Poneketmon {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        return Math.min(nums.length / 2, set.size());
    }

    @Test
    public void result() {
        assertThat(solution(new int[]{3, 1, 2, 3})).isEqualTo(2);
        assertThat(solution(new int[]{3, 3, 3, 2, 2, 4})).isEqualTo(3);
        assertThat(solution(new int[]{3, 3, 3, 2, 2, 2})).isEqualTo(2);
    }
}
