package programmers;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

//https://programmers.co.kr/learn/courses/30/lessons/42889
public class FailureRate {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        HashMap<Integer, Double> failureRate = new HashMap<>();
        int user = stages.length;
        for (int i = 1; i <= N; i++) {
            double cnt = 0;
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] == i ) {
                    cnt++;
                }
            }
            if (user > 0) {
                failureRate.put(i, (cnt / user));
            } else {
                failureRate.put(i, 0.0);
            }
            user = (int) (user - cnt);
        }
        List<Map.Entry<Integer, Double>> entryList = new LinkedList<>(failureRate.entrySet());
        entryList.sort(((o1, o2) -> failureRate.get(o2.getKey()).compareTo(failureRate.get(o1.getKey()))));

        for (int i = 0; i < N; i++) {
            answer[i] = entryList.get(i).getKey();
        }
        return answer;
    }

    @Test
    public void result() {
        assertThat(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})).isEqualTo(new int[]{3, 4, 2, 1, 5});
        assertThat(solution(4, new int[]{4,4,4,4,4})).isEqualTo(new int[]{4,1,2,3});
        assertThat(solution(5, new int[]{3,3,3,3})).isEqualTo(new int[]{4,1,2,3});
    }
}
