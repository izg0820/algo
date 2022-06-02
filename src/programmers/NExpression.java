package programmers;

import java.util.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NExpression {
    public int solution(int N, int number) {

        if (N == number) {
            return 1;
        }

        int answer = 0;
        List<HashSet<Integer>> dp = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < 8; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < i + 1; j++) {
                sb.append(N);
            }
            HashSet<Integer> hashSet = new HashSet<>();
            hashSet.add(Integer.parseInt(sb.toString()));
            dp.add(hashSet);
        }

        for (int i = 1; i < 8; i++) {
            for (int k = 0; k < i ; k++) {
                for (int d1 : dp.get(k)) {
                    for (int d2 : dp.get(i - k - 1)) {
                        dp.get(i).add(d1 + d2);
                        dp.get(i).add(d1 - d2);
                        dp.get(i).add(d1 * d2);
                        if (d2 != 0) {
                            dp.get(i).add(d1 / d2);
                        }

                    }
                }
            }
            if (dp.get(i).contains(number)) {
                answer = i + 1;
                flag = true;
                break;
            }
        }
        if (!flag) {
            return -1;
        }
        return answer > 8 ? -1 : answer;
    }

    @Test
    public void result() {
        assertThat(solution(5, 12)).isEqualTo(4);
        assertThat(solution(2, 11)).isEqualTo(3);
    }
}
