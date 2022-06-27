package programmers;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

//https://programmers.co.kr/learn/courses/30/lessons/43164
public class TravelRoute {

    List<String> answer = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        answer = new ArrayList<>();
        boolean[] visited = new boolean[tickets.length];

        dfs("ICN", "ICN", tickets, visited);
        Collections.sort(answer);

        return answer.get(0).split(" ");
    }

    private void dfs(String start, String route, String[][] tickets, boolean[] visited) {

        if (allVisited(visited)) {
            answer.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(start)) {
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, visited);
                visited[i] = false;
            }
        }
    }

    public boolean allVisited(boolean[] visited) {
        boolean flag = true;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    @Test
    public void result() {
        assertThat(solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})).isEqualTo(new String[]{"ICN", "JFK", "HND", "IAD"});
        assertThat(solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}})).isEqualTo(new String[]{"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"});
        assertThat(solution(new String[][]{{"A", "B"}, {"A", "C"}, {"B", "D"}, {"C", "A"}, {"ICN", "A"}})).isEqualTo(new String[]{"ICN", "A", "C", "A", "B", "D"});
        assertThat(solution(new String[][]{{"ICN", "AAA"}, {"ICN", "AAA"}, {"ICN", "AAA"}, {"AAA", "ICN"}, {"AAA", "ICN"}})).isEqualTo(new String[]{"ICN", "AAA", "ICN", "AAA", "ICN", "AAA"});
    }
}
