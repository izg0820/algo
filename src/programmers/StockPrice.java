package programmers;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class StockPrice {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> time = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!time.isEmpty() && prices[i] < prices[time.peek()]) {
                answer[time.peek()] = i - time.peek();
                time.pop();
            }
            time.push(i);
        }

        while (!time.isEmpty()) {
            answer[time.peek()] = prices.length - time.peek() - 1;
            time.pop();
        }
        return answer;
    }

    @Test
    public void result() {
        assertThat(solution(new int[]{1, 2, 3, 2, 3})).isEqualTo(new int[]{4, 3, 1, 1, 0});
    }
}
