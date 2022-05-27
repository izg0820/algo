package programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SkillTree {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String s : skill_trees) {
            String skilltree = s;
            for (int i = 0; i < s.length(); i++) {
                String t = String.valueOf(s.charAt(i));
                if (!skill.contains(t)) {
                    skilltree = skilltree.replace(t, "");
                }
            }

            if (skill.indexOf(skilltree) == 0) {
                answer++;
            }
        }
        return answer;
    }

    @Test
    public void result() {
        assertThat(solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"})).isEqualTo(2);
    }
}
