package programmers;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

//https://school.programmers.co.kr/learn/courses/30/lessons/118667
public class MakeSameSumQueue {

    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long q1Sum = 0, q2Sum = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int i = 0; i < queue1.length; i++) {
            q1Sum += queue1[i];
            q1.offer(queue1[i]);

            q2Sum += queue2[i];
            q2.offer(queue2[i]);
        }

        while(q1Sum != q2Sum) {
            answer++;
            if(q1Sum > q2Sum) {
                int pop = q1.poll();
                q1Sum -= pop;
                q2Sum += pop;
                q2.offer(pop);
            } else {
                int pop = q2.poll();
                q1Sum += pop;
                q2Sum -= pop;
                q1.offer(pop);
            }

            if (answer > (queue1.length + queue2.length) * 2) return -1;
        }

        return answer;
    }


    @Test
    public void result() {
        assertThat(solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1})).isEqualTo(2);
        assertThat(solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2})).isEqualTo(7);
        assertThat(solution(new int[]{1, 1}, new int[]{1, 5})).isEqualTo(-1);
    }
}
