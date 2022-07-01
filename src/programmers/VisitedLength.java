package programmers;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

//https://programmers.co.kr/learn/courses/30/lessons/49994
public class VisitedLength {
    public int solution(String dirs) {
        HashMap<Character, int[]> direct = new HashMap<>();
        direct.put('L', new int[]{-1, 0, 0}); //X, Y
        direct.put('R', new int[]{1, 0, 2});
        direct.put('U', new int[]{0, 1, 1});
        direct.put('D', new int[]{0, -1, 3});
        int answer = 0;
        int x = 5;
        int y = 5;
        boolean[][][] visited = new boolean[11][11][4];
        for (int i = 0; i < dirs.length(); i++) {
            int[] dict = direct.get(dirs.charAt(i));
            int nx = x + dict[0];
            int ny = y + dict[1];
            int d = dict[2];
            if (isRanged(nx, ny)) {
                if (!visited[ny][nx][d]) {
                    visited[ny][nx][d] = true;
                    d = d % 2 == 0 ? 2 - d : 4 - d;
                    visited[y][x][d] = true;
                    answer++;
                }
                x = nx;
                y = ny;
            }
        }
        return answer;
    }

    public boolean isRanged(int x, int y) {
        return 0 <= x && x <= 10 && 0 <= y && y <= 10;
    }

    @Test
    public void result() {
        assertThat(solution("ULURRDLLU")).isEqualTo(7);
        assertThat(solution("LULLLLLLU")).isEqualTo(7);
    }
}
