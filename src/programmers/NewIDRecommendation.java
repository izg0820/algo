package programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NewIDRecommendation {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^a-z\\d\\-_.]", "");

        new_id = new_id.replaceAll("\\.{2,}", ".");
        if(new_id.startsWith(".")) {
            new_id = new_id.substring(1);
        }
        if (new_id.endsWith(".")) {
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        if (new_id.equals("")) {
            new_id = "a";
        }
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if (new_id.endsWith(".")) {
                new_id = new_id.substring(0, new_id.length() - 1);
            }
        }
        if (new_id.length() <= 2) {
            String lastChar = new_id.substring(new_id.length() - 1);
            while (new_id.length() != 3) {
                new_id = new_id + lastChar;
            }
        }

        return new_id;
    }

    @Test
    public void result() {
        assertThat(solution("...!@BaT#*..y.abcdefghijklm")).isEqualTo("bat.y.abcdefghi");
        assertThat(solution("z-+.^.")).isEqualTo("z--");
        assertThat(solution("=.=")).isEqualTo("aaa");
        assertThat(solution("123_.def")).isEqualTo("123_.def");
        assertThat(solution("abcdefghijklmn.p")).isEqualTo("abcdefghijklmn");
    }
}
