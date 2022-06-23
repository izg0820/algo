package programmers;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

//https://programmers.co.kr/learn/courses/30/lessons/1844
public class GameMapShortDistance {
    int endY, endX;
    final int[][] direct = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int solution(int[][] maps) {
        endY = maps.length - 1;
        endX = maps[0].length - 1;
        Queue<Position> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length];

        queue.offer(new Position(0, 0, 1));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Position cur = queue.poll();

            if (cur.x == endX && cur.y == endY) {
                return cur.cost;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + direct[i][0];
                int nx = cur.x + direct[i][1];
                if (isRanged(ny, nx) && maps[ny][nx] == 1 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    queue.offer(new Position(ny, nx, cur.cost + 1));
                }
            }
        }

        return -1;
    }

    public class Position {
        int x, y, cost;

        public Position(int y, int x, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    public boolean isRanged(int y, int x) {
        return 0 <= y && y <= endY && 0 <= x && x <= endX;
    }

    @Test
    public void result() {
        assertThat(solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}})).isEqualTo(11);
        assertThat(solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}})).isEqualTo(-1);
    }
}
