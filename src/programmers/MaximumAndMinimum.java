package programmers;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

//https://programmers.co.kr/learn/courses/30/lessons/12939
public class MaximumAndMinimum {
    public String solution(String s) {
        List<Integer> list = Arrays.stream(s.split(" ")).map(i -> Integer.valueOf(i)).collect(Collectors.toList());
        Collections.sort(list);
        return list.get(0) + " " + list.get(list.size() - 1);
    }

    @Test
    public void result() {
        assertThat(solution("1 2 3 4")).isEqualTo("1 4");
        assertThat(solution("-1 -2 -3 -4")).isEqualTo("-4 -1");
        assertThat(solution("-1 -1")).isEqualTo("-1 -1");
    }
}
