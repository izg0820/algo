package programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

//https://programmers.co.kr/learn/courses/30/lessons/70129
public class RotateBinaryChange {
    public int[] solution(String s) {
        int[] answer = {0 ,0};

        while (!"1".equals(s)) {
            answer[0]++;
            answer[1] = countZero(answer[1], s);
            s = s.replaceAll("0", "");
            s = Integer.toBinaryString(s.length());
        }
        return answer;
    }

    public int countZero(int cnt, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                cnt++;
            }
        }
        return cnt;
    }

    @Test
    public void result() {
        assertThat(solution("110010101001")).isEqualTo(new int[]{3, 8});
        assertThat(solution("01110")).isEqualTo(new int[]{3, 3});
        assertThat(solution("1111111")).isEqualTo(new int[]{4, 1});
    }
}
