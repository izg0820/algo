package programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

//https://programmers.co.kr/learn/courses/30/lessons/43163
public class WordConversion {
    int answer = 0;
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        boolean[] visited = new boolean[words.length];
        dfs(visited, words, begin, target, 0);
        return answer;
    }

    public void dfs(boolean[] visited, String[] words, String begin, String target, int cnt) {

        if(begin.equals(target)) {
            answer = cnt;
            return;
        }
        for (int i = 0; i < words.length; i++) {
            if(visited[i]) continue;

            if (subtract(begin, words[i]) == 1) {
                visited[i] = true;
                dfs(visited, words, words[i], target, cnt + 1);
                visited[i] = false;
            }
        }
    }

    public int subtract(String a, String b) {
        int k = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                k++;
            }
        }
        return a.length() - k;
    }

    @Test
    public void result() {
        assertThat(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"})).isEqualTo(4);
        assertThat(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"})).isEqualTo(0);
    }
}
