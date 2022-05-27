package programmers;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

//https://programmers.co.kr/learn/courses/30/lessons/42583?language=java
public class TruckCrossingBridge {

    public int solution (int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int bridgeWeight = 0, idx = 0;
        Queue<Integer> inBridge = new LinkedList<>();

        while (true) {
            if(idx == truck_weights.length) break;
            if (inBridge.size() == bridge_length) {
                bridgeWeight -= inBridge.poll();
            } else if (bridgeWeight + truck_weights[idx] > weight) {
                inBridge.offer(0);
                answer++;
            } else{
                inBridge.offer(truck_weights[idx]);
                bridgeWeight += truck_weights[idx];
                answer++;
                idx++;
            }
        }

        return answer + bridge_length;
    }
    
    @Test
    public void result() {
        assertThat(solution(2, 10, new int[]{7, 4, 5, 6})).isEqualTo(8);
        assertThat(solution(100, 100, new int[]{10})).isEqualTo(101);
        assertThat(solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10})).isEqualTo(110);
    }
}
