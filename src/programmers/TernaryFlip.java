package programmers;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

//https://programmers.co.kr/learn/courses/30/lessons/68935
public class TernaryFlip {
    public int solution(int n) {
        List<Integer> list = changeTernary(n);
        return changeDecimal(list);
    }

    public List<Integer> changeTernary(int n) {
        List<Integer> ternary = new ArrayList<>();
        while (n > 2) {
            ternary.add(n % 3);
            n /= 3;
        }
        ternary.add(n);
        return ternary;
    }

    public int changeDecimal(List<Integer> ternary) {
        int decimal = 0;
        for (int i = 0; i < ternary.size(); i++) {
            decimal += ternary.get(ternary.size() - i - 1) * Math.pow(3, i);
        }
        return decimal;
    }

    @Test
    public void result() {
        assertThat(solution(45)).isEqualTo(7);
        assertThat(solution(125)).isEqualTo(229);
    }
}
