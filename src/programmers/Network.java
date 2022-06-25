package programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

//https://programmers.co.kr/learn/courses/30/lessons/43162
public class Network {
    int answer;
    public int solution(int n, int[][] computers) {
        answer = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i, visited, computers);
                //총 영역의 수
                answer++;
            }
        }
        return answer;
    }

    public void dfs(int v, boolean[] visited, int[][] computers) {
        visited[v] = true;
        for(int i = 0; i<computers[v].length; i++) {
            if (v != i && computers[v][i] == 1 && visited[i] == false) {
                //영역의 넓이를 구할때
                dfs(i, visited, computers);
            }
        }
    }

    @Test
    public void result() {
        assertThat(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}})).isEqualTo(2);
        assertThat(solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}})).isEqualTo(1);
    }
}
