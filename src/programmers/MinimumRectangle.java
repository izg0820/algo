package programmers;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

//https://school.programmers.co.kr/learn/courses/30/lessons/86491
public class MinimumRectangle {
    public int solution(int[][] sizes) {
        int maxWidth = 0, maxHeight = 0;
        for (int i = 0; i < sizes.length; i++) {
            int tempWidth = Math.max(sizes[i][0], sizes[i][1]);
            int tempHeight = Math.min(sizes[i][0], sizes[i][1]);
            maxWidth = Math.max(maxWidth, tempWidth);
            maxHeight = Math.max(maxHeight, tempHeight);
        }
        return maxWidth * maxHeight;
    }

    @Test
    public void result() {
        assertThat(solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}})).isEqualTo(4000);
        assertThat(solution(new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}})).isEqualTo(120);
        assertThat(solution(new int[][]{{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}})).isEqualTo(133);
    }
}
