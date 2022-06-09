package programmers;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

//https://programmers.co.kr/learn/courses/30/lessons/42839
public class FindPrime {
    HashSet<Integer> hashMap;
    int answer;
    public int solution(String numbers) {
        hashMap = new HashSet<>();
        answer = 0;

        boolean[] visited = new boolean[numbers.length()];
        permutation("", 0, numbers, visited);
        return answer;
    }

    public boolean isPrime(int num) {
        int cnt = 2;
        boolean result = true;
        if(num <= 1) return false;
        while (cnt < num) {
            if (num % cnt == 0) {
                result = false;
                break;
            }
            cnt++;
        }
        return result;
    }

    public void permutation(String num, int depth, String numbers, boolean[] visited) {
        if(depth > 0) {
            int t = Integer.parseInt(num);
            if (!hashMap.contains(t) && isPrime(t)) {
                answer++;
                hashMap.add(t);
            }
        }

        for (int i = 0; i < numbers.length(); i++) {
            if(visited[i]) continue;
            visited[i] = true;
            permutation(num + numbers.charAt(i), depth + 1, numbers, visited);
            visited[i] = false;
        }
    }

    @Test
    public void result() {
        assertThat(solution("17")).isEqualTo(3);
        assertThat(solution("011")).isEqualTo(2);
    }
}
