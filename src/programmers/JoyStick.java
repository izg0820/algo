package programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

//https://programmers.co.kr/learn/courses/30/lessons/42860
public class JoyStick {
    public int solution(String name) {
        int answer = 0;
        int endA = 0;
        int move = name.length() - 1;
        for (int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            endA = i + 1;
            while (endA < name.length() && name.charAt(endA) == 'A') {
                endA++;
            }
            move = Math.min(move, i * 2 + (name.length() - endA)); //왔던 길을 다시 되돌아가서 뒤로 간 경우
            move = Math.min(move, i + (name.length() - endA) * 2);
        }
        return answer + move;
    }

    @Test
    public void result() {
        assertThat(solution("JEROEN")).isEqualTo(56);
        assertThat(solution("JAN")).isEqualTo(23);
    }
}
