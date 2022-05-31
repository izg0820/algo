package programmers;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import static org.assertj.core.api.Assertions.assertThat;

//https://programmers.co.kr/learn/courses/30/lessons/12981
public class EnglishWordRelay {
    public int[] solution(int n, String[] words) {
        int[] answer = {0 ,0};
        int rotateCnt = 0;
        int who;
        String prev = "";
        HashSet<String> usedWords = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            who = i + 1;
            if (i > n - 1) {
                who = (i % n) + 1;
            }
            if (i % n == 0) {
                rotateCnt++;
            }
            if (usedWords.contains(words[i]) || !words[i].startsWith(prev) || words[i].length() == 1) {
                answer[0] = who;
                answer[1] = rotateCnt;
                break;
            } else {
                usedWords.add(words[i]);
                prev = words[i].substring(words[i].length() - 1);
            }
        }
        return answer;
    }

    @Test
    public void result() {
        assertThat(solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})).isEqualTo(new int[]{3, 3});
        assertThat(solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"}))
                .isEqualTo(new int[]{0, 0});
        assertThat(solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"})).isEqualTo(new int[]{1, 3});
    }
}
